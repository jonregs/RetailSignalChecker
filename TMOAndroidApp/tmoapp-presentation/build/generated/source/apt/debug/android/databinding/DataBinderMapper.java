
package android.databinding;
import com.tmobile.pr.mytmobile.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 19;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.tmobile.pr.mytmobile.R.layout.user_item:
                    return com.tmobile.pr.mytmobile.databinding.UserItemBinding.bind(view, bindingComponent);
                case com.tmobile.pr.mytmobile.R.layout.fragment_user_list:
                    return com.tmobile.pr.mytmobile.databinding.FragmentUserListBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -1353761389: {
                if(tag.equals("layout/user_item_0")) {
                    return com.tmobile.pr.mytmobile.R.layout.user_item;
                }
                break;
            }
            case 52834841: {
                if(tag.equals("layout/fragment_user_list_0")) {
                    return com.tmobile.pr.mytmobile.R.layout.fragment_user_list;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"isLoading"
            ,"userModel"};
    }
}