package com.hitesh.mvvmrx.viewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.hitesh.mvvmrx.model.AndroidVersion;

public class ItemVersionViewModel extends BaseObservable {
    AndroidVersion mItemVersion;
    private Context mContext;

    public ItemVersionViewModel(Context mContext) {
        this.mContext = mContext;
    }

    public AndroidVersion getmItemVersion() {
        return mItemVersion;
    }

    public void setmItemVersion(AndroidVersion mItemVersion) {
        this.mItemVersion = mItemVersion;
    }
}
