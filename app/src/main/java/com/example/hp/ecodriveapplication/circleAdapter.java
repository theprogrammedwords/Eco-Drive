package com.example.hp.ecodriveapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class circleAdapter extends RecyclerView.Adapter<circleAdapter.ViewHolder> {


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView, circleBioTextView, circleIDTextView, circleCityTextView, circleMemberCount;
        public Button viewCircle;
        ImageView ImageId;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.circle_name);
            circleMemberCount = (TextView) itemView.findViewById(R.id.circle_memberCount);
            ImageId = (ImageView) itemView.findViewById(R.id.circleImage);
            /*  circleBioTextView= (TextView) itemView.findViewById(R.id.circle_bio);
           circleIDTextView = (TextView) itemView.findViewById(R.id.circle_ID);
           circleCityTextView = (TextView) itemView.findViewById(R.id.circle_city);
            viewCircle = (Button) itemView.findViewById(R.id.view_circle);
         */


        }

    }
       private List<circleData> mItems;
       public circleAdapter(List<circleData> circleItem) {
           mItems = circleItem;
       }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_circle, parent, false);


        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        // Get the data model based on position
        circleData circleData = mItems.get(position);
        TextView CName, CBio,CId, CCity, CNum;
        ImageView ImageId;// Set item views based on your views and data model


            if(position>9)
            {
                CName = viewHolder.nameTextView;
                CName.setText(circleData.getCircleName());
                CNum = viewHolder.circleMemberCount;
                CNum.setText("");
                ImageId = viewHolder.ImageId;
                ImageId.setImageResource(circleData.getImage());
            }
            else {
                CName = viewHolder.nameTextView;
                CName.setText("Circle Name : " +circleData.getCircleName());
                CNum = viewHolder.circleMemberCount;
                CNum.setText("Member Count : " + circleData.getMemberCount());
                ImageId = viewHolder.ImageId;
                ImageId.setImageResource(circleData.getImage());

            }
       /*   CBio = viewHolder.circleBioTextView;
            CBio.setText(circleData.getBioText());

            CId = viewHolder.circleIDTextView;
            CId.setText(circleData.getCircleId());

            CCity = viewHolder.circleCityTextView;
            CCity.setText(circleData.getCity());
        */
    /*  Button button = viewHolder.viewCircle;
        button.setText("View Circle");
        button.setEnabled(true);*/
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mItems.size();
    }

}