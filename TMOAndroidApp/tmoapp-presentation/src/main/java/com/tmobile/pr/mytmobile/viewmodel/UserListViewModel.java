package com.tmobile.pr.mytmobile.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import com.tmobile.pr.mytmobile.domain.interactor.DefaultObserver;
import com.tmobile.pr.mytmobile.domain.interactor.browse.GetUserList;
import com.tmobile.pr.mytmobile.domain.model.User;
import com.tmobile.pr.mytmobile.mapper.UserModelDataMapper;
import com.tmobile.pr.mytmobile.model.UserModel;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class UserListViewModel extends AndroidViewModel {
    private MutableLiveData userLiveData = new MutableLiveData<>();
    private final GetUserList getUserListUseCase;
    private final UserModelDataMapper userModelDataMapper;

    @Inject
    public UserListViewModel(@NonNull Application application, GetUserList getUserListUserCase,
                                UserModelDataMapper userModelDataMapper) {
        super(application);
        // If any transformation is needed, this can be simply done by Transformations class ...
        this.getUserListUseCase = getUserListUserCase;
        this.userModelDataMapper = userModelDataMapper;
        getUserList();
    }

    /**
     * Create Usecase and pass the default Observer
     */
    private void getUserList() {
        this.getUserListUseCase.execute(new UserListObserver(), null);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        getUserListUseCase.dispose();
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<UserModel>> getProjectListObservable() {
        return userLiveData;
    }

    /**
     * Passing Default Oberver implementation to the use case
     * and once results are retried update the UI
     */
    private final class UserListObserver extends DefaultObserver<List<User>> {

        @Override
        public void onComplete() {
            //Need to implement
        }

        @Override
        public void onError(Throwable e) {
            //Need to implement
        }

        @Override
        public void onNext(List<User> users) {
            showUsersCollectionInView(users);
        }
    }

    private void showUsersCollectionInView(@NonNull Collection<User> usersCollection) {
        final Collection<UserModel> userModelsCollection =
                this.userModelDataMapper.transform(usersCollection);
        userLiveData.postValue(userModelsCollection);
    }
}
