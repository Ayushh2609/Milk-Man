package com.example.milkman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TextView txtAmount;
    private int totalAmount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAmount = findViewById(R.id.txtAmount);

        //TabLayout And View Pager
        TabLayout tabMain = findViewById(R.id.tabMain);
        ViewPager viewPagerMain = findViewById(R.id.viewPagerMain);

        ViewPagerMainAdapter vp = new ViewPagerMainAdapter(getSupportFragmentManager());
        viewPagerMain.setAdapter(vp);

        tabMain.setupWithViewPager(viewPagerMain);


    }

    public void updateAmount(int amount) {
        totalAmount += amount;
        txtAmount.setText("Amount to be collected: " + totalAmount);

        Toast.makeText(this, "Amount Updated:" +totalAmount, Toast.LENGTH_SHORT).show();
    }


    public void updateAmountOff(int amount) {
        totalAmount -= amount;
        txtAmount.setText("Amount to be collected: " + totalAmount);

        Toast.makeText(this, "Amount Updated:" +totalAmount, Toast.LENGTH_SHORT).show();

    }
}