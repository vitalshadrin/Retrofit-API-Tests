package core.rest_entity.github;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {
    @GET("users/list")
    Call<GetUser> getUser();
}
