package hmf.com.project.hmfwarehouse.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hmf.com.project.hmfwarehouse.Adpter.ImagesAdpter;
import hmf.com.project.hmfwarehouse.R;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by home on 7/3/2018.
 */

public class ImagesActivity extends AppCompatActivity {


    List<String> infos;
    RecyclerView recyclerView;
    ImagesAdpter houseAdpter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        getSupportActionBar().setTitle("WareHouse Images");
        infos=new ArrayList<String>();
        infos = (ArrayList<String>) getIntent().getSerializableExtra("imageslist");
        recyclerView = (RecyclerView)findViewById(R.id.imagesview);
        int s=infos.size();
        houseAdpter = new ImagesAdpter(ImagesActivity.this,infos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(s);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setAdapter(houseAdpter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ImagesActivity.this));


    }
}
