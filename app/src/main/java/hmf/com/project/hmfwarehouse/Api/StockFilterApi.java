package hmf.com.project.hmfwarehouse.Api;

import java.util.List;

import hmf.com.project.hmfwarehouse.domains.StockFilterInfo;
import hmf.com.project.hmfwarehouse.domains.StockInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by home on 7/6/2018.
 */

public interface StockFilterApi {

    @Headers("Content-Type: application/json")
    @POST("/stockDetails/getStockDetailsBySearchFilter")
    Call<List<StockInfo>> getUser(@Body StockFilterInfo filterInfo);
}
