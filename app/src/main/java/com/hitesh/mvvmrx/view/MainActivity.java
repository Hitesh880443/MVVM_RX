package com.hitesh.mvvmrx.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.hitesh.mvvmrx.R;
import com.hitesh.mvvmrx.databinding.ActivityMainBinding;
import com.hitesh.mvvmrx.model.AndroidVersionResposne;
import com.hitesh.mvvmrx.util.Logger;
import com.hitesh.mvvmrx.viewModel.AndroidVersionViewModel;

import io.reactivex.observers.DisposableObserver;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding mMainActivityBinding;
    private AndroidVersionViewModel mAndroidVersionViewModel;
    private DisposableObserver mGetAndroidVersion;
    private RecyclerView mVersionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setSupportActionBar(mMainActivityBinding.toolbar);
        initRecylerView();
        mMainActivityBinding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAndroidVersion();
            }
        });
    }

    private void initRecylerView() {
        mVersionList = mMainActivityBinding.rlVersionlist;
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }


    private void initDataBinding() {
        mMainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mAndroidVersionViewModel = new AndroidVersionViewModel(this);
        mMainActivityBinding.setAndroidversion(mAndroidVersionViewModel);

    }

    private void getAndroidVersion() {
        mGetAndroidVersion = new DisposableObserver<AndroidVersionResposne>() {
            @Override
            public void onNext(AndroidVersionResposne data) {
                if (data != null && data.getData().size() > 0) {
                    Logger.d("Android dataSize", String.valueOf(data.getData().size()));
                    Toast.makeText(MainActivity.this, "List  "+data.getData().size(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onError(Throwable e) {
                Logger.d("Android error", e.getMessage());
            }

            @Override
            public void onComplete() {
                Logger.d("Android complete","done");
            }
        };


        mAndroidVersionViewModel.getAndroidVersionList(mGetAndroidVersion);
    }


}
