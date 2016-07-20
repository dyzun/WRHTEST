package com.example.android.slidingtabsbasic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView t1 = (TextView)findViewById(R.id.textView);
        assert t1 != null;
        t1.setText("Wecome to the We Are Henry app. \n\nThis app is dedcated to helping you discover local resources and helping you save money" +
                " \n\nTo discover more, please visit our website");
        Button b = (Button) findViewById(R.id.button2);
        assert b!=null;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://wearehenry.com/"));

                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
