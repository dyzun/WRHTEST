package com.example.android.slidingtabsbasic;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.EditText;

public class InviteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setType("text/plain");
                EditText edt1 = (EditText)findViewById(R.id.editText);
                String abc = edt1.getText().toString();
                intent.putExtra(Intent.EXTRA_SUBJECT, "Invitation to We Are Henry");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello there, " +abc +" , I'd like to invite you to try the We Are Henry app!" +
                        "\n\nlink to GooglePlayStore");
                EditText edt = (EditText)findViewById(R.id.editText2);
                String xyz = edt.getText().toString();
                intent.setData(Uri.parse("mailto:"+xyz));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        assert fab2 != null;
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt3 = (EditText)findViewById(R.id.editText3);
                String phoneNumber = edt3.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phoneNumber));
                intent.putExtra("sms_body", "Hello there, I'd like to invite you to try the We Are Henry app!" +
                        "\n\nlink to GooglePlayStore");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
