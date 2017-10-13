package com.tmobile.pr.mytmobile.databinding;
import com.tmobile.pr.mytmobile.R;
import com.tmobile.pr.mytmobile.BR;
import android.view.View;
public class MyaccountItemBinding extends android.databinding.ViewDataBinding  {

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
    private com.tmobile.pr.mytmobile.model.MyAccountModel mMyAccountModel;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public MyaccountItemBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
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
            case BR.myAccountModel :
                setMyAccountModel((com.tmobile.pr.mytmobile.model.MyAccountModel) variable);
                return true;
        }
        return false;
    }

    public void setMyAccountModel(com.tmobile.pr.mytmobile.model.MyAccountModel MyAccountModel) {
        this.mMyAccountModel = MyAccountModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.myAccountModel);
        super.requestRebind();
    }
    public com.tmobile.pr.mytmobile.model.MyAccountModel getMyAccountModel() {
        return mMyAccountModel;
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
        com.tmobile.pr.mytmobile.model.MyAccountModel myAccountModel = mMyAccountModel;
        java.lang.String myAccountModelAccountName = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (myAccountModel != null) {
                    // read myAccountModel.accountName
                    myAccountModelAccountName = myAccountModel.getAccountName();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.textView, myAccountModelAccountName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static MyaccountItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static MyaccountItemBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<MyaccountItemBinding>inflate(inflater, com.tmobile.pr.mytmobile.R.layout.myaccount_item, root, attachToRoot, bindingComponent);
    }
    public static MyaccountItemBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static MyaccountItemBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.tmobile.pr.mytmobile.R.layout.myaccount_item, null, false), bindingComponent);
    }
    public static MyaccountItemBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static MyaccountItemBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/myaccount_item_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new MyaccountItemBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): myAccountModel
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}