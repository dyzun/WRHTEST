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
            dateTv.setText(bundle.getString("date"));
            dets.setText(bundle.getString("dets"));
            voucher.append(bundle.getString("Voc"));
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
