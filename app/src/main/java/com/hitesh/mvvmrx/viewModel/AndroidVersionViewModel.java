package com.hitesh.mvvmrx.viewModel;

import android.content.Context;

import com.hitesh.mvvmrx.api.AndroidUserAPI;
import com.hitesh.mvvmrx.model.AndroidVersion;
import com.hitesh.mvvmrx.util.RetrofitAPI;

import java.util.List;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class AndroidVersionViewModel extends Observable {

    private AndroidVersion mVersion;
    private Context mContext;
    private List<AndroidVersion> dataList;


    public AndroidVersionViewModel(Context mContext) {
        this.mContext = mContext;
    }

    public AndroidVersionViewModel(Context mContext, AndroidVersion mVersion) {
        this.mContext = mContext;
        this.mVersion = mVersion;
    }

    public void getAndroidVersionList(Observer mObserver) {


        new RetrofitAPI().getRetrofit().create(AndroidUserAPI.class)
                .getAndroidVersion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(mObserver);

    }

    private void updateVersionDataList(List<AndroidVersion> list) {
        dataList.addAll(list);
        setChanged();
        notifyObservers();
    }


    public List<AndroidVersion> getDataList() {
        return dataList;
    }


}
