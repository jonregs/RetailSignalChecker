
package com.tmobile.pr.mytmobile.data.repository.datasource;

import com.tmobile.pr.mytmobile.data.entity.mapper.UserEntityJsonMapper;
import com.tmobile.pr.mytmobile.data.net.RestApi;
import com.tmobile.pr.mytmobile.data.net.RestApiImpl;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link UserDataStore}.
 */
@Singleton
public class UserDataStoreFactory {

  @Inject
  public UserDataStoreFactory(){
  }
  /**
   * Create {@link UserDataStore} to retrieve data from the Cloud.
   */
  public UserDataStore createCloudDataStore() {
    final UserEntityJsonMapper userEntityJsonMapper = new UserEntityJsonMapper();
    final RestApi restApi = new RestApiImpl(userEntityJsonMapper);

    return new CloudUserDataStore(restApi);
  }
}
