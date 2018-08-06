package hmf.com.project.hmfwarehouse.domains;

/**
 * Created by home on 7/6/2018.
 */

public class StockFilterInfo {

    private String cropName;
    private String farmerName;
    private String farmerPhoneNumber;
    private String farmerVillage;
    private String warehouseName;

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public String getFarmerPhoneNumber() {
        return farmerPhoneNumber;
    }

    public void setFarmerPhoneNumber(String farmerPhoneNumber) {
        this.farmerPhoneNumber = farmerPhoneNumber;
    }

    public String getFarmerVillage() {
        return farmerVillage;
    }

    public void setFarmerVillage(String farmerVillage) {
        this.farmerVillage = farmerVillage;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    @Override
    public String toString() {

        return "StockFilterInfo{" +
                "cropName='" + cropName + '\'' +
                ", farmerName='" + farmerName + '\'' +
                ", farmerPhoneNumber='" + farmerPhoneNumber + '\'' +
                ", farmerVillage='" + farmerVillage + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                '}';
    }
}
