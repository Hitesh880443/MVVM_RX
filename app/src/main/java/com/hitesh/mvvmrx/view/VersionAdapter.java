package com.hitesh.mvvmrx.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hitesh.mvvmrx.R;
import com.hitesh.mvvmrx.databinding.ItemVersionLayoutBinding;
import com.hitesh.mvvmrx.model.AndroidVersion;

import java.util.List;

public class VersionAdapter extends RecyclerView.Adapter<VersionAdapter.VersionAdapterViewHolder> {


    private List<AndroidVersion> mList;
    private LayoutInflater mInflater;

    @Override
    public VersionAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }

        ItemVersionLayoutBinding binding
                = DataBindingUtil.inflate(mInflater, R.layout.item_version_layout, parent, false);
        return new VersionAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(VersionAdapterViewHolder holder, int position) {
        holder.binding.setSingleVersion(mList.get(position));

    }

    @Override
    public int getItemCount() {
        if (mList != null && mList.size() > 0)
            return mList.size();
        else
            return 0;
    }

    public static class VersionAdapterViewHolder extends RecyclerView.ViewHolder {

        private final ItemVersionLayoutBinding binding;

        public VersionAdapterViewHolder(ItemVersionLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public void showList(List<AndroidVersion> noteList) {
        this.mList = noteList;
        notifyDataSetChanged();
    }
}
