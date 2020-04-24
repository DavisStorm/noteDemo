package com.davis.mall.utils;

import android.content.Context;
import android.graphics.Bitmap;

import com.davis.mall.MallApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyw on 2016/11/3.
 */

public class FileUtil {
    private static FileUtil instance;
    private static final String DIR_CACHE = "cache";
    private static final String DIR_BUG = "bug";
    private static final String DIR_PRINT = "print";

    private static final String DIR_DATA = "data";
    private static final String DIR_PATCH = "patch";
    private static final String FILE_BUG_POSTFIX = ".bug";
    //文件名字
    public static final String APK_NAME = "HuNanApp.apk";
    public static final String PATCH_NAME = "patch.jar";
    public static final String DB_NAME = "userdata.dbx";

    private Context mContext;


    public FileUtil(Context mContext) {
        this.mContext = mContext;
    }

    public synchronized static FileUtil getInstance() {
        if (instance == null) {
            instance = new FileUtil(MallApplication.getContext());
        }
        return instance;
    }

    public File getDirPrint() {
        return mContext.getExternalFilesDir(DIR_PRINT);
    }

    public File getBugDir() {
        return mContext.getExternalFilesDir(DIR_BUG);
    }

    public String getBugDirPath() {
        return getBugDir().getAbsolutePath();
    }

    public File getCacheDir() {
        return mContext.getExternalFilesDir(DIR_CACHE);
    }

    public String getCacheDirPath() {
        return getCacheDir().getAbsolutePath();
    }


    /**
     * apk文件位置
     *
     * @return
     */
//    public File getApkFile() {
//        return new File(Environment.getExternalStorageDirectory(), APK_NAME);
//    }

    /**
     * db文件位置
     *
     * @return
     */
//    public File getDbFile() {
//        return new File(getCacheDir(), DB_NAME);
//    }

    /**
     * 拷贝到apk安装路径的数据库目录下
     *
     * @return 拷贝是否成功
     */
    public boolean copyToInterPath(String srcFile, String destFile) {
        boolean b = false;
        //判断文件夹是否存在
        String dirPath = destFile.substring(0, destFile.lastIndexOf(File.separator) + 1);
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File dest = new File(destFile);
        if (!(b = isFileExists(dest, true))) {
            InputStream is = null;
            OutputStream os = null;
            try {
                is = new FileInputStream(new File(srcFile));
                os = new FileOutputStream(dest);
                int length;
                byte[] buf = new byte[1024 * 2];
                while ((length = is.read(buf)) != -1) {
                    os.write(buf, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return !b;
    }

    private static boolean isFileExists(File f, boolean refresh) {
        boolean b = false;
        if (f.exists()) {
            if (refresh) {
                f.delete();
                b = false;
            } else {
                b = true;
            }
        }
        return b;
    }

    /**
     * patch文件位置
     *
     * @return
     */
    public File getOuterPatchFile() {
        return new File(getPatchDir(), PATCH_NAME);
    }

    /**
     * 内部 patch文件位置
     *
     * @return
     */
    public File getInternalPatchFile() {
        File file = new File(mContext.getFilesDir(), "patch");
        if (!file.exists()) file.mkdirs();
        return new File(file, PATCH_NAME);
    }

    /**
     * 检查DB文件是否存在
     *
     * @param f       文件名
     * @param refresh 是否覆盖之前的db文件
     * @return
     */
    private static boolean isDbFileExists(File f, boolean refresh) {
        boolean b = false;
        if (f.exists()) {
            if (refresh) {
                f.delete();
                b = false;
            } else {
                b = true;
            }
        }
        return b;
    }

    /**
     * 图片保存
     */
    public String save2Local(Bitmap bitmap, String path) {
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] photoBytes = baos.toByteArray();
            if (photoBytes != null) {
                new FileOutputStream(new File(path)).write(photoBytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null)
                    baos.close();
                if (bitmap != null) bitmap.recycle();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    public List<String> getPrintList(String flag) {
        List<String> paths = new ArrayList<>();
        File file = new File(FileUtil.getInstance().getCacheDirPath());
        for (File f : file.listFiles()) {
            if (f.getName().split("_")[0].equals(flag))
                paths.add(f.getAbsolutePath());
        }
        return paths;
    }

    public File getPatchDir() {
        return mContext.getExternalFilesDir(DIR_PATCH);
    }

}
