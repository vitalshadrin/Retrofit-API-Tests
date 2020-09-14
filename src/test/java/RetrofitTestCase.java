import core.rest_entity.github.GitHubService;
import core.retrofit.AbstractRetrofit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RetrofitTestCase extends AbstractRetrofit {

    @Test
    public void verifyLogin_Test() throws IOException {
        String login = create(GitHubService.class).getUser().execute().body().getLogin();
        Assert.assertEquals(login, "list");
    }
}
