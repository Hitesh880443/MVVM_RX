package com.hitesh.mvvmrx.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.hitesh.mvvmrx.model.AndroidVersion;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionAdapterViewHolder> {


    @Override
    public VersionAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VersionAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class VersionAdapterViewHolder extends RecyclerView.ViewHolder{



        public VersionAdapterViewHolder(View itemView) {
            super(itemView);
        }
        void bindVersion(AndroidVersion version){

        }
    }
}
