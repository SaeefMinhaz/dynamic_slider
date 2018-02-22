package com.example.shovon.dynamicslider;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    private ArrayList<ImageItem> Image_list;
    private RelativeLayout leftNavigate;
    private RelativeLayout rightNavigate;
    private TextView view_image, short_image, phone_image, star;
    private LinearLayout lm;
    // private TextView image1,image2,image3,image4,image5;
    //  Typeface tfAndroidFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        leftNavigate = (RelativeLayout) findViewById(R.id.imageview_left_image);
        rightNavigate = (RelativeLayout) findViewById(R.id.imageview_right_image);
//        view_image = (TextView) findViewById(R.id.view_image);
//        short_image = (TextView) findViewById(R.id.short_image);
//        phone_image = (TextView) findViewById(R.id.phone_image);


        // view_image.setTypeface(tfAndroidFont);
        // phone_image.setTypeface(tfAndroidFont);
        // short_image.setTypeface(tfAndroidFont);

        Image_list = new ArrayList<ImageItem>();
        for (int i = 0; i < 5; i++) {
            ImageItem img = new ImageItem();
            if (i == 0) img.img_url = R.drawable.me;
            if (i == 1) img.img_url = R.drawable.me2;
            if (i == 2) img.img_url = R.drawable.me;
            if (i == 3) img.img_url = R.drawable.me2;
            if (i == 4) img.img_url = R.drawable.me;
            img.title = "Android";
            img.id = "Easy";
            Image_list.add(img);
        }
        //Create four
        lm = (LinearLayout) findViewById(R.id.bottom_layer);
        dynamicView(0);

        if (Image_list.size() == 1) {
            rightNavigate.setVisibility(View.GONE);
            leftNavigate.setVisibility(View.GONE);

        } else {
            leftNavigate.setVisibility(View.GONE);
            rightNavigate.setVisibility(View.VISIBLE);
        }
        PageListener pageListener = new PageListener();
        viewPager.setOnPageChangeListener(pageListener);

        ImageAdapter adapter = new ImageAdapter(MainActivity.this, Image_list);
        viewPager.setAdapter(adapter);

        leftNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

        rightNavigate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });


    }


    private class PageListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            try {
                // Log.i("View Pager", "page selected " + position);

                int currentPage = position + 1;
                lm.removeAllViews();
                dynamicView(position);
                if (currentPage == 1) {
                    leftNavigate.setVisibility(View.GONE);
                    rightNavigate.setVisibility(View.VISIBLE);
                } else if (currentPage == Image_list.size()) {

                    leftNavigate.setVisibility(View.VISIBLE);
                    rightNavigate.setVisibility(View.GONE);
                } else {
                    leftNavigate.setVisibility(View.VISIBLE);
                    rightNavigate.setVisibility(View.VISIBLE);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void dynamicView(int pos) {
        for (int j = 0; j < Image_list.size(); j++) {
            LinearLayout ll = new LinearLayout(MainActivity.this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            // Create TextView
            star = new TextView(MainActivity.this);
            star.setText("o");
            //  star.setTypeface(tfAndroidFont);
            if (pos == j) {
                star.setTextColor(Color.BLUE);
            } else {
                star.setTextColor(Color.RED);
            }

            star.setTextSize(25);
            star.setPadding(10, 0, 0, 0);
            star.setId(j);
            ll.addView(star);
            lm.addView(ll);
            star.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG).show();
                    viewPager.setCurrentItem(v.getId());
                }
            });
        }
    }
}
