package com.davis.mall.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.davis.mall.interfac.IMVP;
import com.davis.mall.presenter.BaseFragmentPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author 王阳
 * @time 2019/11/2  1:09
 * @desc aa
 */
public abstract class BaseFragment<T extends BaseFragmentPresenter> extends Fragment implements IMVP {

    private Unbinder bind;
    private Boolean isPrepare=false;
    private T mPresenter;
    private boolean isVisiable;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("lazyload", "onCreateView: ");
        return inflater.inflate(setLayout(),container,false);
    }


    //当fragment创建的时候都会执行onViewCreated
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("lazyload", "onViewCreated: ");
        bind = ButterKnife.bind(this,view);
        mPresenter = createPresenter();
        initView();
        isPrepare = true;
        lazyload();
    }

    //这是懒加载，当界面完全显示后需要做的事情

    public void lazyload() {
        if (isVisiable && isPrepare){
            Log.e("lazyload", "lazyload: start");
            bindData();
            bindListenter();
        }
    }


    //懒加载的聪明之处，就是当界面显示出来时刷新界面数据而不是重新创建视图，比如在
    //底部导航栏进行切换时，会刷新数据而不需要重新创建fragment
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("lazyload", "isVisibleToUser: "+isVisibleToUser);
        //seems stupied?
        if (getUserVisibleHint()){
            isVisiable=true;
            lazyload();
        }else {
            isVisiable=false;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    public void setVisiable(boolean visiable) {
        isVisiable = visiable;
    }

    protected abstract int setLayout();

    protected abstract void initView();//创建视图后只需要执行一次的代码
    protected abstract void bindData();//懒加载，当页面显示后进行的更新数据操作

    protected abstract void bindListenter();
    protected abstract T createPresenter();
    public  T getPresenter(){
        return mPresenter;
    }
}
