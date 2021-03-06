package com.ren.test.presenter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.ren.test.modle.BaseModle;
import com.ren.test.ui.BaseView;
import com.ren.test.utils.InstanceUtils;

public class BasePresenter<V extends BaseView, M extends BaseModle> {
    private V mView;
    private M mModle;

    public void onCreate(@NonNull Activity activity) {
        this.mView = (V) activity;
        this.mModle = InstanceUtils.getInstance(activity, 1);
        if (!(activity instanceof BaseView)) {
            throw new IllegalArgumentException(activity.getClass().getSimpleName() + " is a not supported type which must implements BaseView(创建P失败)");
        }
        if (mModle == null) {
            throw new IllegalArgumentException("can not get the ParameterizedType of(创建P失败)" + activity.getClass().getSimpleName());
        }
}

    public void onCreate(@NonNull Fragment fragment) {
        this.mView = (V) fragment;
        this.mModle = InstanceUtils.getInstance(fragment, 1);

        if (!(fragment instanceof BaseView)) {
            throw new IllegalArgumentException(fragment.getClass().getSimpleName() + " is a not supported type which must implements BaseView(创建P失败)");
        }
        if (mModle == null) {
            throw new IllegalArgumentException("can not get the ParameterizedType of(创建P失败)" + fragment.getClass().getSimpleName());
        }
    }

    public V getView() {
        return mView;
    }

    public M getModle() {
        return mModle;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onResume() {

    }

    public void onPause() {
    }

    public void onStop() {

    }

    public void onDestroy() {
    }
}