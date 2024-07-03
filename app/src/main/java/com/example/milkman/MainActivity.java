package com.example.milkman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabMain = findViewById(R.id.tabMain);
        ViewPager viewPagerMain = findViewById(R.id.viewPagerMain);


        ViewPagerMainAdapter vp = new ViewPagerMainAdapter(getSupportFragmentManager());
        viewPagerMain.setAdapter(vp);

        tabMain.setupWithViewPager(viewPagerMain);

    }
}