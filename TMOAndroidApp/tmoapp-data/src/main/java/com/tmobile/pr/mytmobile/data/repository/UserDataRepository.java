
package com.tmobile.pr.mytmobile.data.repository;

import com.tmobile.pr.mytmobile.data.entity.UserEntity;
import com.tmobile.pr.mytmobile.data.entity.mapper.UserEntityDataMapper;
import com.tmobile.pr.mytmobile.data.repository.datasource.UserDataStore;
import com.tmobile.pr.mytmobile.data.repository.datasource.UserDataStoreFactory;
import com.tmobile.pr.mytmobile.domain.model.User;
import com.tmobile.pr.mytmobile.domain.repository.UserRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * {@link UserRepository} for retrieving user data.
 */
@Singleton
public class UserDataRepository implements UserRepository {

    private final UserDataStoreFactory userDataStoreFactory;
    private final UserEntityDataMapper userEntityDataMapper;

    /**
     * Constructs a {@link UserRepository}.
     *
     * @param dataStoreFactory     A factory to construct different data source implementations.
     * @param userEntityDataMapper {@link UserEntityDataMapper}.
     */
    @Inject
    UserDataRepository(UserDataStoreFactory dataStoreFactory,
                       UserEntityDataMapper userEntityDataMapper) {
        this.userDataStoreFactory = dataStoreFactory;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public Observable<List<User>> users() {
        //we always get all users from the cloud
        final UserDataStore userDataStore = this.userDataStoreFactory.createCloudDataStore();
        return userDataStore.userEntityList().map(new Function<List<UserEntity>, List<User>>() {
            @Override
            public List<User> apply(List<UserEntity> userEntities) throws Exception {
                return userEntityDataMapper.transform(userEntities);
            }
        });
    }

}
