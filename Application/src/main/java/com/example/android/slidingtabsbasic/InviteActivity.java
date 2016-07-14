package com.example.android.slidingtabsbasic;

import android.content.Intent;
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
        //getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>InviteNeighbors </font>"));


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
                intent.setData(Uri.parse("mailto:"+xyz)); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
