package com.example.shovon.dynamicslider;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by SHOVON on 2/22/2018.
 */

public class ImageAdapter extends PagerAdapter{
    Activity context;
    private ArrayList<ImageItem> ImageList;
    private LayoutInflater layoutInflater;

    ImageAdapter(Activity context,ArrayList<ImageItem> ImageList){
        this.context=context;
        this.ImageList = ImageList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return ImageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //  return view == ((RelativeLayout) object);
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View itemView = layoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        TextView txt1 = (TextView) itemView.findViewById(R.id.sr_vp_builder);
        TextView txt2 = (TextView) itemView.findViewById(R.id.sr_vp_builder_name);

            /*ImageView imageView = new ImageView(context);
            int padding = context.getResources().getDimensionPixelSize(R.dimen.padding_medium);
            imageView.setPadding(padding, padding, padding, padding);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);*/
        //    Toast.makeText(getApplicationContext(), "size:"+ImageList.size()+"\nPosition:"+position, Toast.LENGTH_LONG).show();
        try
        {
            txt1.setText(""+ImageList.get(position).title);
            txt2.setText(""+ImageList.get(position).id);
            Picasso.with(context).load(ImageList.get(position).img_url)
                    .fit().error(R.drawable.ic_launcher_background).into(imageView);

        }
        catch (OutOfMemoryError e)
        {   System.out.println(e.toString()); }

        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //((ViewPager) container).removeView((RelativeLayout) object);
        ((ViewPager) container).removeView((RelativeLayout) object);
    }
}
