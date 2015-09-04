package com.pikamoney.app.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/*** Created by wei-shang on 2014/10/27. */
public abstract class FragmentActivity extends android.support.v4.app.FragmentActivity{

    protected FragmentManager mFragmentManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
    }

    public void replaceFragment(int containerViewId, Fragment fragment, boolean addStack){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(containerViewId, fragment);
        if(addStack)
            transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(containerViewId, fragment);
        transaction.commitAllowingStateLoss();
    }

    public abstract Fragment getFragment(int fid);
}



