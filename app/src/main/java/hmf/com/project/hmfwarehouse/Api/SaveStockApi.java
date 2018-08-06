package hmf.com.project.hmfwarehouse.Api;

import hmf.com.project.hmfwarehouse.domains.SimpleRes;
import hmf.com.project.hmfwarehouse.domains.StockInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by home on 6/28/2018.
 */

public interface StockApi {


    @Headers("Content-Type: application/json")
    @POST("warehouseDetails")
    Call<SimpleRes> getUser(@Body StockInfo stockInfo);
}
