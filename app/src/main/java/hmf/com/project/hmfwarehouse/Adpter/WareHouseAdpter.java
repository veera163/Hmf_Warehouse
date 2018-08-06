package hmf.com.project.hmfinspection.Adpter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import hmf.com.project.hmfinspection.Holder.Holder;
import hmf.com.project.hmfinspection.R;
import hmf.com.project.hmfinspection.domains.InspectionPendingRes;
import hmf.com.project.hmfinspection.domains.WareHouseInfo;
import hmf.com.project.hmfinspection.views.CircleTransform;

/**
 * Created by home on 6/22/2018.
 */

public class WareHouseAdpter extends RecyclerView.Adapter<Holder>  {

    private Context context;
    private List<WareHouseInfo> wareHouseInfos;

    public WareHouseAdpter(Context context, List<WareHouseInfo> wareHouseInfos) {
        this.context = context;
        this.wareHouseInfos = wareHouseInfos;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.warehouse_list, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        holder.veera.setVisibility(View.GONE);

        holder.add1.setText(wareHouseInfos.get(position).getWarehouseName());
        holder.add2.setText(wareHouseInfos.get(position).getPhoneNumber());
        holder.add3.setText(wareHouseInfos.get(position).getLocation());

        holder.warehouseName.setText(wareHouseInfos.get(position).getWarehouseName());
        holder.location.setText(wareHouseInfos.get(position).getLocation());
        holder.city.setText(wareHouseInfos.get(position).getCity());
        holder.state.setText(wareHouseInfos.get(position).getState());
        holder.pincode.setText(wareHouseInfos.get(position).getPincode());
        holder.phoneNumber.setText(wareHouseInfos.get(position).getPhoneNumber());
        holder.alternatePhoneNumber.setText(wareHouseInfos.get(position).getAlternatePhoneNumber());
        holder.emailId.setText(wareHouseInfos.get(position).getEmailId());
        holder.website.setText(wareHouseInfos.get(position).getWebsite());


        StringBuilder builder = new StringBuilder();
        for (String details : wareHouseInfos.get(position).getFacilities()) {
            builder.append(details + ",");
        }
        holder.facilities.setText(builder.toString());

      //  holder.facilities.setText(wareHouseInfos.get(position).getFacilities().toString());
        holder.contactPerson.setText(wareHouseInfos.get(position).getContactPerson());
        holder.inOperationSince.setText(wareHouseInfos.get(position).getInOperationSince());
        holder.standardsAndCertifications.setText(wareHouseInfos.get(position).getStandardsAndCertifications());

        StringBuilder builder1 = new StringBuilder();
        for (String details : wareHouseInfos.get(position).getMaterialsHandling()) {
            builder1.append(details + ",");
        }

        holder.materialsHandling.setText(builder1.toString());

        Glide.with(context)
                .load(wareHouseInfos.get(position).getImageUrlList().get(0))
                .crossFade()
                .thumbnail(0.5f)
                .bitmapTransform(new CircleTransform(context))
                .error(R.drawable.ic_account_circle_black_24dp)      // optional
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);


        holder.venkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.veera.getVisibility()==View.GONE)
                {
                    holder.veera.setVisibility(View.VISIBLE);

                }
                else if(holder.veera.getVisibility()==View.VISIBLE) {
                    holder.veera.setVisibility(View.GONE);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return wareHouseInfos.size();
    }
}
