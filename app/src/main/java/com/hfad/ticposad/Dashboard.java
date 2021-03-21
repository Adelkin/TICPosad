package com.hfad.ticposad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.WindowManager;

import com.hfad.ticposad.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.hfad.ticposad.HelperClasses.HomeAdapter.FeaturedHelperClass;

import java.util.ArrayList;

public class  Dashboard extends AppCompatActivity {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);

        featuredRecycler();
    }

    private void featuredRecycler(){

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.prisvin_img,"Restaurant Prishvin", "there will be description"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_1,"Govyadino", "there will be description"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.city_2,"Gostevaya izba", "there will be description"));

        adapter = new FeaturedAdapter(featuredLocations);
        featuredRecycler.setAdapter(adapter);

        //вроде просто пример для градиента
        GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT,new int[]{0xffeff400, 0xffaff600});

    }
}