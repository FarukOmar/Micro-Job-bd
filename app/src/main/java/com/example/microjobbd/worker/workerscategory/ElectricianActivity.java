package com.example.microjobbd.worker.workerscategory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.microjobbd.R;
import com.example.microjobbd.adapter.ViewPagerAdapter;
import com.example.microjobbd.fragment.ListFragment;
import com.example.microjobbd.fragment.MapFragment;
import com.google.android.material.tabs.TabLayout;

public class ElectricianActivity extends AppCompatActivity {

    TabLayout tabLayout;
    Toolbar toolbar;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrician);

        toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("Electrician");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        tabLayout= (TabLayout) findViewById(R.id.tablayout);
        viewPager= (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new MapFragment(),"Map View");
        adapter.AddFragment(new ListFragment(),"List View");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        SharedPreferences.Editor editor = this.getSharedPreferences("OMAR", MODE_PRIVATE).edit();
        editor.putString("cleaner", "Electrician");
        editor.apply();
    }
}
