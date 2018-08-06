package hmf.com.project.hmfinspection.Api;

import java.util.List;

import hmf.com.project.hmfinspection.domains.WareHouseInfo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by home on 6/22/2018.
 */

public interface WareHouseApi {
    @GET
    Call<List<WareHouseInfo>> getData(@Url String url);
}
