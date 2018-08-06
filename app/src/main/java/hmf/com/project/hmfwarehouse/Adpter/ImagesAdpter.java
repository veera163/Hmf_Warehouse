package hmf.com.project.hmfwarehouse.Adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import hmf.com.project.hmfwarehouse.Holder.Holder;
import hmf.com.project.hmfwarehouse.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by home on 7/3/2018.
 */

public class ImagesAdpter extends RecyclerView.Adapter<Holder>  {


    private Context context;
    private List<String> imageUrlList;

    public ImagesAdpter(Context context, List<String> imageUrlList) {
        this.context = context;
        this.imageUrlList = imageUrlList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.imageslist, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Log.e("veera",imageUrlList.toString());

        if(imageUrlList!=null){

            Glide.with(context)
                        .load(imageUrlList.get(position))
                        .crossFade()
                        .thumbnail(0.5f)
                        .error(R.drawable.ic_account_circle_black_24dp)      // optional
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.image);

        }
        else {

            Glide.with(context)
                    .load("http://www.hiremyfarmer.com/assets/images/seller1.png")
                    .crossFade()
                    .thumbnail(0.5f)
                    .error(R.drawable.ic_account_circle_black_24dp)      // optional
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.image);
        }



    }

    @Override
    public int getItemCount() {

        return imageUrlList.size();
    }
}
