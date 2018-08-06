package hmf.com.project.hmfinspection.domains;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by home on 6/22/2018.
 */

public class WareHouseInfo {

    @SerializedName("warehouseId")
    @Expose
    private String warehouseId;
    @SerializedName("warehouseName")
    @Expose
    private String warehouseName;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("alternatePhoneNumber")
    @Expose
    private String alternatePhoneNumber;
    @SerializedName("emailId")
    @Expose
    private String emailId;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("facilities")
    @Expose
    private List<String> facilities = null;
    @SerializedName("contactPerson")
    @Expose
    private String contactPerson;
    @SerializedName("inOperationSince")
    @Expose
    private String inOperationSince;
    @SerializedName("standardsAndCertifications")
    @Expose
    private String standardsAndCertifications;
    @SerializedName("materialsHandling")
    @Expose
    private List<String> materialsHandling = null;
    @SerializedName("cropList")
    @Expose
    private Object cropList;
    @SerializedName("villageList")
    @Expose
    private Object villageList;
    @SerializedName("imageUrlList")
    @Expose
    private List<String> imageUrlList = null;
    @SerializedName("latLng")
    @Expose
    private String latLng;

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlternatePhoneNumber() {
        return alternatePhoneNumber;
    }

    public void setAlternatePhoneNumber(String alternatePhoneNumber) {
        this.alternatePhoneNumber = alternatePhoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getInOperationSince() {
        return inOperationSince;
    }

    public void setInOperationSince(String inOperationSince) {
        this.inOperationSince = inOperationSince;
    }

    public String getStandardsAndCertifications() {
        return standardsAndCertifications;
    }

    public void setStandardsAndCertifications(String standardsAndCertifications) {
        this.standardsAndCertifications = standardsAndCertifications;
    }

    public List<String> getMaterialsHandling() {
        return materialsHandling;
    }

    public void setMaterialsHandling(List<String> materialsHandling) {
        this.materialsHandling = materialsHandling;
    }

    public Object getCropList() {
        return cropList;
    }

    public void setCropList(Object cropList) {
        this.cropList = cropList;
    }

    public Object getVillageList() {
        return villageList;
    }

    public void setVillageList(Object villageList) {
        this.villageList = villageList;
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public String getLatLng() {
        return latLng;
    }

    public void setLatLng(String latLng) {
        this.latLng = latLng;
    }

}
