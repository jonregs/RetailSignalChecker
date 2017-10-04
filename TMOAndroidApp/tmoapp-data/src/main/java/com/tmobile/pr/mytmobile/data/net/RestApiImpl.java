
package com.tmobile.pr.mytmobile.data.net;

import com.tmobile.pr.mytmobile.data.entity.UserEntity;
import com.tmobile.pr.mytmobile.data.entity.mapper.UserEntityJsonMapper;
import com.tmobile.pr.mytmobile.data.exception.NetworkConnectionException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.net.MalformedURLException;
import java.util.List;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
public class RestApiImpl implements RestApi {

    private final UserEntityJsonMapper userEntityJsonMapper;

    /**
     * Constructor of the class
     *
     * @param userEntityJsonMapper {@link UserEntityJsonMapper}.
     */
    public RestApiImpl(UserEntityJsonMapper userEntityJsonMapper) {
        if (userEntityJsonMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.userEntityJsonMapper = userEntityJsonMapper;
    }

    @Override
    public Observable<List<UserEntity>> userEntityList() {
        return Observable.create(new ObservableOnSubscribe<List<UserEntity>>() {
            @Override
            public void subscribe(ObservableEmitter<List<UserEntity>> emitter) throws Exception {
                try {
                    String responseUserEntities = getUserEntitiesFromApi();
                    if (responseUserEntities != null) {
                        emitter.onNext(userEntityJsonMapper.transformUserEntityCollection(
                                responseUserEntities));
                        emitter.onComplete();
                    } else {
                        emitter.onError(new NetworkConnectionException());
                    }
                } catch (Exception e) {
                    emitter.onError(new NetworkConnectionException(e.getCause()));
                }
            }
        });
    }


    private String getUserEntitiesFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_URL_GET_USER_LIST).requestSyncCall();
    }

    private String getUserDetailsFromApi(int userId) throws MalformedURLException {
        String apiUrl = API_URL_GET_USER_DETAILS + userId + ".json";
        return ApiConnection.createGET(apiUrl).requestSyncCall();
    }

}
