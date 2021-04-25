package com.example.hp.ecodriveapplication;


import android.app.Activity;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class myListView extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;
    private final Integer[] imgid;
    private final Integer[] bdgid;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    public myListView(Activity context, String[] maintitle,String[] subtitle, Integer[] imgid, Integer[] bdgid) {
        super(context, R.layout.mylist, maintitle);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.maintitle=maintitle;
        this.subtitle=subtitle;
        this.imgid=imgid;
        this.bdgid = bdgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        ImageView bdgview = (ImageView) rowView.findViewById(R.id.badge);

        titleText.setText(maintitle[position]);
        imageView.setImageResource(imgid[position]);
        subtitleText.setText(subtitle[position]);
        bdgview.setImageResource(bdgid[position]);

        return rowView;

    };
}