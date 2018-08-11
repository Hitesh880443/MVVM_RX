package com.hitesh.mvvmrx.viewModel;

import android.content.Context;
import android.support.annotation.IntDef;

import com.hitesh.mvvmrx.api.AndroidUserAPI;
import com.hitesh.mvvmrx.model.AndroidVersion;
import com.hitesh.mvvmrx.util.RetrofitAPI;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
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
        this.dataList = new ArrayList<AndroidVersion>();
    }

    public void getAndroidVersionList(Observer mObserver) {

        new RetrofitAPI().getRetrofit().create(AndroidUserAPI.class)
                .getAndroidVersion()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(mObserver);

    }

    public void updateVersionDataList(List<AndroidVersion> list) {
        dataList = list;
    }

    public List<AndroidVersion> getDataList() {
        return dataList;
    }


    public boolean hasData(){
         if(getDataList()!=null && getDataList().size()>0)
             return true;
         return false;
    }




}
