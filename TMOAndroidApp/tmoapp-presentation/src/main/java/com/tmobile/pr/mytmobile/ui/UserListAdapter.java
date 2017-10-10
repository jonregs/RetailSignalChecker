package com.tmobile.pr.mytmobile.ui;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.databinding.UserItemBinding;
import com.tmobile.pr.mytmobile.model.UserModel;
import com.tmobile.pr.mytmobile.ui.common.recyclerview.DataBoundListAdapter;

import java.util.Objects;

public class UserListAdapter extends DataBoundListAdapter<UserModel,UserItemBinding>{
    @Override
    protected UserItemBinding createBinding(ViewGroup parent) {
        return DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.user_item,
                        parent, false);
    }

    @Override
    protected void bind(UserItemBinding binding, UserModel item) {
        binding.setUserModel(item);
    }

    @Override
    protected boolean areItemsTheSame(UserModel oldItem, UserModel newItem) {
        return Objects.equals(oldItem.getFullName(), newItem.getFullName());
    }

    @Override
    protected boolean areContentsTheSame(UserModel oldItem, UserModel newItem) {
        return Objects.equals(oldItem.getFollowers(), newItem.getFollowers());
    }
}
