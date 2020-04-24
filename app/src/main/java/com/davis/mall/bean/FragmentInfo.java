package com.davis.mall.bean;


import androidx.fragment.app.Fragment;

/**
 * @author 王阳
 * @time 2019/11/9  22:32
 * @desc
 */
public class FragmentInfo {

    public FragmentInfo(String title, Fragment fragment) {
        this.title = title;
        mFragment = fragment;
    }

    public String title;
    public Fragment mFragment;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }
}
