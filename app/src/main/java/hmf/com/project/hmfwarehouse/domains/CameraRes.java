package hmf.com.project.hmfwarehouse.domains;

import java.util.List;

/**
 * Created by home on 7/2/2018.
 */

public class CameraRes {

    private List<String> imageUrlList;

    @Override
    public String toString() {
        return "CameraRes{" +
                "imageUrlList=" + imageUrlList +
                '}';
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }
}
