package core.retrofit;

import core.file_reader.PropertiesReader;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class AbstractRetrofit {
    PropertiesReader propertiesReader;

    @BeforeClass(alwaysRun = true)
    protected void preconditions(ITestContext context) {
        this.propertiesReader = new PropertiesReader(context);
    }

    protected <T> T create(Class<T> entity) {
        return new Retrofit.Builder()
                .baseUrl(propertiesReader.getProperties().getProperty("baseUrl"))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(entity);
    }
}
