package com.tmobile.pr.mytmobile.databinding;
import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.BR;
import android.view.View;
public class UserItemBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    private final android.support.v7.widget.CardView mboundView0;
    public final android.widget.TextView textView;
    // variables
    private com.tmobile.pr.mytmobile.model.UserModel mUserModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public UserItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.support.v7.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.textView = (android.widget.TextView) bindings[1];
        this.textView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.userModel :
                setUserModel((com.tmobile.pr.mytmobile.model.UserModel) variable);
                return true;
        }
        return false;
    }

    public void setUserModel(com.tmobile.pr.mytmobile.model.UserModel UserModel) {
        this.mUserModel = UserModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.userModel);
        super.requestRebind();
    }
    public com.tmobile.pr.mytmobile.model.UserModel getUserModel() {
        return mUserModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String userModelFullName = null;
        com.tmobile.pr.mytmobile.model.UserModel userModel = mUserModel;

        if ((dirtyFlags & 0x3L) != 0) {



                if (userModel != null) {
                    // read userModel.fullName
                    userModelFullName = userModel.getFullName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView, userModelFullName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static UserItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UserItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<UserItemBinding>inflate(inflater, com.tmobile.pr.mytmobile.R.layout.user_item, root, attachToRoot, bindingComponent);
    }
    public static UserItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UserItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tmobile.pr.mytmobile.R.layout.user_item, null, false), bindingComponent);
    }
    public static UserItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UserItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/user_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new UserItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): userModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}