package hmf.com.project.hmfwarehouse.Api;

import java.util.List;

import hmf.com.project.hmfwarehouse.domains.WarehouseFilterInfo;
import hmf.com.project.hmfwarehouse.domains.WareHouseInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by home on 7/6/2018.
 */

public interface WarehouseFilterApi {

    @Headers("Content-Type: application/json")
    @POST("/warehouseDetails/getWarehouseDetailsBySearchFilter")
    Call<List<WareHouseInfo>> getUser(@Body WarehouseFilterInfo filterInfo);
}
