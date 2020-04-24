package com.davis.mall.utils;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import com.davis.mall.ui.MainActivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashHandler implements UncaughtExceptionHandler {
	private static final String TAG = "CrashHandler";
	private static final boolean DEBUG = true;
	public static String PATH;
	private static final String FILE_NAME = "crash";
	private static final String FILE_NAME_SUFFIX = ".txt";
	private static CrashHandler sInstance = new CrashHandler();
	private UncaughtExceptionHandler mDefaultCrashHandler;
	private Context mContext;
	
	
	
	private CrashHandler() {
	}

	public static CrashHandler getInstance(){
		return sInstance;
	}

	public void init(Context context){
        PATH = FileUtil.getInstance().getBugDirPath();
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(getInstance());
		mContext = context;
	}
	
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            if(DEBUG){
                Log.w(TAG, "sdcard unmounted,skip dump exception");
                return;
            }
        }
        if (ex == null && mDefaultCrashHandler != null) {
            mDefaultCrashHandler.uncaughtException(thread, ex);
        } else {
            Log.w(TAG, ex);
            File dir = new File(PATH);
            if(!dir.exists()){
                dir.mkdirs();
            }
            long current = System.currentTimeMillis();
            String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(current));
            File file = new File(PATH+ File.separator+FILE_NAME+time+FILE_NAME_SUFFIX);
            PrintWriter pw;
            try {
                pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
                pw.println(time);
                writeMobileInfo( mContext, pw);
                pw.println();
                ex.printStackTrace(pw);
                ex.printStackTrace();
                pw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }catch (Exception e) {
                Log.e(TAG, "dump crash info faild");
            }

            /**
             * 改进 增加崩溃次数 当3次do what 5次 do what
             */
            //清空内部补丁文件
            File innerFile = FileUtil.getInstance().getInternalPatchFile();
            if (innerFile.exists()) {
                innerFile.delete();
            }

            //清空外部补丁文件
            File outterPatch = FileUtil.getInstance().getOuterPatchFile();
            if (outterPatch.exists()) {
                outterPatch.delete();
            }
            System.exit(0);
            //清空sp
//            SPUtils.getInstance().removeKey(Constance.SP_DB_VERSION);
//            SPUtils.getInstance().removeKey(Constance.SP_PATCH_VERSION);
        Intent intent = new Intent(mContext, MainActivity.class);
        PendingIntent restartIntent = PendingIntent.getActivity(mContext, 0, intent, PendingIntent.FLAG_ONE_SHOT);
//        //退出程序
        AlarmManager mgr = (AlarmManager)mContext.getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 1000,
                restartIntent); // 1秒钟后重启应用
        android.os.Process.killProcess(android.os.Process.myPid());
        }
    }


    //手机设备信息
    private static void writeMobileInfo(Context context, PrintWriter pw)
            throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        PackageInfo pi = pm.getPackageInfo(context.getPackageName(),
                PackageManager.GET_ACTIVITIES);
        pw.print("App Version：");
        pw.print(pi.versionName);
        pw.print("_");
        pw.println(pi.versionCode);

        //Android版本
        pw.print("OS Version：");
        pw.print(Build.VERSION.RELEASE);
        pw.print("_");
        pw.println(Build.VERSION.SDK_INT);

        //手机制造商
        pw.print("Vendor：");
        pw.println(Build.MANUFACTURER);

        pw.print("Model：");
        pw.println(Build.MODEL);
    }

}
