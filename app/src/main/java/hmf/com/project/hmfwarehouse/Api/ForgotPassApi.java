package hmf.com.project.hmfinspection.Api;

import hmf.com.project.hmfinspection.domains.SimpleRes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by home on 6/21/2018.
 */

public interface ForgotPassApi {

    @GET
    Call<SimpleRes> getData(@Url String url);
}
