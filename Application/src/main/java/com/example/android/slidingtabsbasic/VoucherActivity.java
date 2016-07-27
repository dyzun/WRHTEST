package com.example.android.slidingtabsbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
