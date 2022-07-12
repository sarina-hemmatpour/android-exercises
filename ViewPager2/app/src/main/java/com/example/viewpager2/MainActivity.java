package com.example.viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //viewPager2
        SlideAdaptor slideAdaptor=new SlideAdaptor(this);
        ViewPager2 viewPager2=findViewById(R.id.viewPager2);
        viewPager2.setAdapter(slideAdaptor);
        viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setCurrentItem(4,true);

        //TabLayout
        /* hatman bayad library material design ezafe she
           chon tab layout zir majmooeye material design ee
            => implementation 'com.google.android.material:material:<version>'*/
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        TabLayoutMediator tlMediator=new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position)
                {
                    case 0:
                        tab.setText("A");
                        break;
                    case 1:
                        tab.setText("B");
                        break;
                    case 2:
                        tab.setText("C");
                        break;
                    case 3:
                        tab.setText("D");
                        break;
                    case 4:
                        tab.setText("E");
                        break;
                }
            }
        });
        tlMediator.attach();

    }
}