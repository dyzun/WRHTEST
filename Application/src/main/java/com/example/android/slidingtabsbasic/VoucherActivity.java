package com.example.android.slidingtabsbasic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class VoucherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView img=(ImageView) findViewById(R.id.imageView1);
        assert img !=null;
        TextView nameTv=(TextView) findViewById(R.id.textView1);
        assert nameTv !=null;
        TextView dateTv=(TextView) findViewById(R.id.textView2);
        assert dateTv !=null;
        TextView dets=(TextView)findViewById(R.id.details);
        assert dets !=null;
        TextView voucher = (TextView)findViewById(R.id.textView3);
        assert voucher !=null;

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            nameTv.setText(bundle.getString("name"));
            dateTv.setText("Expires: " +bundle.getString("date"));
            dets.setText(bundle.getString("dets"));
            voucher.append(bundle.getString("Voc"));
            switch (bundle.getString("name")) {
                case "Coupon 1":
                    img.setImageResource(R.drawable.cop1);
                    break;
                case "Coupon 2":
                    img.setImageResource(R.drawable.cop2);
                    break;
                case "Coupon 3":
                    img.setImageResource(R.drawable.cop3);
                    break;
                case "Coupon 4":
                    img.setImageResource(R.drawable.cop4);
                    break;
                case "Coupon 5":
                    img.setImageResource(R.drawable.cop5);
                    break;
                case "Coupon 6":
                    img.setImageResource(R.drawable.cop6);
                    break;
                case "Coupon 7":
                    img.setImageResource(R.drawable.cop7);
                    break;
                case "Coupon 8":
                    img.setImageResource(R.drawable.cop8);
                    break;
                case "Coupon 9":
                    img.setImageResource(R.drawable.cop9);
                    break;
                case "Coupon 10":
                    img.setImageResource(R.drawable.cop10);
                    break;
                case "Coupon 11":
                    img.setImageResource(R.drawable.cop11);
                    break;
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab !=null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*String fromEmail = "wrhalert@gmail.com";//TODO SEND MICHIE EMAIL & PASSWORD
                String fromPassword = "WRHcountyGeorgia";
                String toEmails = "wrhalert@gmail.com";
                String adminEmail = "admin@gmail.com";
                String emailSubject = "Voucher redeemed";
                String adminSubject = "Voucher redeemed";
                TextView nameTv = (TextView) findViewById(R.id.textView1);
                assert nameTv !=null;
                String voucher1=nameTv.getText().toString();
                String emailBody = "1 Vocuher for " + voucher1 + " has been redeemed";
                String adminBody = "1 Vocuher for " + voucher1 + " has been redeemed";
                try{
                    new SendMailTask(VoucherActivity.this).execute(fromEmail,
                            fromPassword, toEmails, emailSubject, emailBody);
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
                //TODO GET BACKGROUND EMAIL WORKING
            */
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());//todo fix this
                SharedPreferences.Editor editor = preferences.edit();
                TextView nameTv=(TextView) findViewById(R.id.textView1);
                assert nameTv !=null;
                Intent intent = getIntent();
                Bundle bundle = intent.getExtras();
                if(bundle !=null){
                nameTv.setText(bundle.getString("name"));
                String t1 = nameTv.getText().toString();//todo Check if this works
                if(!preferences.getBoolean(t1, false)) {//adds save value to shared pref if not already there
                    editor.putBoolean(t1, false);
                    editor.apply();
                }
                    editor.putBoolean(t1, false);
                    editor.apply();
                }
            Intent return1 = new Intent(VoucherActivity.this,MainActivity.class);
                return1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(return1);
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);//leave out to make user click redeem
    }

}
