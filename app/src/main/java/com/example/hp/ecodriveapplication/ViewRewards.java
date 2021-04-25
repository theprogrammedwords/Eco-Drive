package com.example.hp.ecodriveapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ViewRewards extends Activity {

    TextView tv;
    Random random = new Random();
    private static final String _CHAR = "ED1234567890";
    private static final int RANDOM_STR_LENGTH = 6;

    private ClipboardManager myClipboard;
    private ClipData myClip;

        String[] values = new String[] {
                "Samsung Coupon",
                "Flipkart Coupon",
                "Mc Donald's",
                "Dominos Coupon",
                "Capello Coupon",
                "First Choice Coupon"};


 protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.view_rewards);

     final ListView listView = (ListView) findViewById(R.id.list_view_rewards);
     tv =(TextView)findViewById(R.id.tv_random_coupon);

     myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

     ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.my_view_rewards_list,values);
     listView.setAdapter(adapter);

     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         public void onItemClick(AdapterView<?> parent, View view,
                                 int position, long id) {



             final LinearLayout layout = new LinearLayout(ViewRewards.this);
             LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
             layout.setOrientation(LinearLayout.VERTICAL);
             layout.setLayoutParams(parms);

             final AlertDialog.Builder builder = new AlertDialog.Builder(ViewRewards.this);

             listView.getChildAt(1).setEnabled(false);
             listView.getChildAt(2).setEnabled(false);
             listView.getChildAt(3).setEnabled(false);
             listView.getChildAt(4).setEnabled(false);
             listView.getChildAt(5).setEnabled(false);

             if (position == 0 ) {
                 builder.setPositiveButton("Copy Code", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         String text="EDC25";

                         myClip = ClipData.newPlainText("text", text);
                         myClipboard.setPrimaryClip(myClip);

                         Toast.makeText(getApplicationContext(), "Code copied", Toast.LENGTH_LONG).show();
                         Log.i("Rewards ", "Code copied");
                         dialog.dismiss();
                     }
                 });

                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i("Rewards ", "canclled");
                         dialog.dismiss();
                     }
                 });
                 LayoutInflater inflater = getLayoutInflater();
                 View dialoglayout = inflater.inflate(R.layout.coupon_dialog, null);
                 builder.setView(dialoglayout);
                 builder.show();

             }

             if (position == 1) {
                 builder.setPositiveButton("Copy Code", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         String text="ED187";

                         myClip = ClipData.newPlainText("text", text);
                         myClipboard.setPrimaryClip(myClip);

                         Toast.makeText(getApplicationContext(), "Code copied", Toast.LENGTH_LONG).show();
                         Log.i("Rewards ", "Code copied");
                         dialog.dismiss();
                     }
                 });

                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i("Rewards ", "canclled");
                         dialog.dismiss();
                     }
                 });
                 LayoutInflater inflater = getLayoutInflater();
                 View dialoglayout = inflater.inflate(R.layout.coupon_dialog, null);
                 builder.setView(dialoglayout);
                 builder.show();
             }

             if (position == 2) {
                 builder.setPositiveButton("Copy Code", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         String text="ED179";

                         myClip = ClipData.newPlainText("text", text);
                         myClipboard.setPrimaryClip(myClip);

                         Toast.makeText(getApplicationContext(), "Code copied", Toast.LENGTH_LONG).show();
                         Log.i("Rewards ", "Code copied");
                         dialog.dismiss();
                     }
                 });

                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i("Rewards ", "canclled");
                         dialog.dismiss();
                     }
                 });
                 LayoutInflater inflater = getLayoutInflater();
                 View dialoglayout = inflater.inflate(R.layout.coupon_dialog, null);
                 builder.setView(dialoglayout);
                 builder.show();
             }

             if (position == 3) {
                 builder.setPositiveButton("Copy Code", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         String text="ED199";

                         myClip = ClipData.newPlainText("text", text);
                         myClipboard.setPrimaryClip(myClip);

                         Toast.makeText(getApplicationContext(), "Code copied", Toast.LENGTH_LONG).show();
                         Log.i("Rewards ", "Code copied");
                         dialog.dismiss();
                     }
                 });

                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i("Rewards ", "canclled");
                         dialog.dismiss();
                     }
                 });
                 LayoutInflater inflater = getLayoutInflater();
                 View dialoglayout = inflater.inflate(R.layout.coupon_dialog, null);
                 builder.setView(dialoglayout);
                 builder.show();
             }

             if (position == 4) {
                 builder.setPositiveButton("Copy Code", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         String text="ED200";

                         myClip = ClipData.newPlainText("text", text);
                         myClipboard.setPrimaryClip(myClip);

                         Toast.makeText(getApplicationContext(), "Code copied", Toast.LENGTH_LONG).show();
                         Log.i("Rewards ", "Code copied");
                         dialog.dismiss();
                     }
                 });

                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i("Rewards ", "canclled");
                         dialog.dismiss();
                     }
                 });
                 LayoutInflater inflater = getLayoutInflater();
                 View dialoglayout = inflater.inflate(R.layout.coupon_dialog, null);
                 builder.setView(dialoglayout);
                 builder.show();
             }

             if (position == 5) {
                 builder.setPositiveButton("Copy Code", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         String text="ED537";

                         myClip = ClipData.newPlainText("text", text);
                         myClipboard.setPrimaryClip(myClip);

                         Toast.makeText(getApplicationContext(), "Code copied", Toast.LENGTH_LONG).show();
                         Log.i("Rewards ", "Code copied");
                         dialog.dismiss();
                     }
                 });

                 builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Log.i("Rewards ", "canclled");
                         dialog.dismiss();
                     }
                 });
                 LayoutInflater inflater = getLayoutInflater();
                 View dialoglayout = inflater.inflate(R.layout.coupon_dialog, null);
                 builder.setView(dialoglayout);
                 builder.show();
             }
         }

     });
 }
    public String getRandomString(){
        StringBuffer randStr = new StringBuffer();
        for (int i = 0; i < RANDOM_STR_LENGTH; i++) {
            int number = getRandomNumber();
            char ch = _CHAR.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    private int getRandomNumber() {
        int randomInt = 0;
        randomInt = random.nextInt(_CHAR.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }

}