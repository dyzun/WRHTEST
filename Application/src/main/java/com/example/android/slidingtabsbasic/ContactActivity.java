package com.example.android.slidingtabsbasic;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;


public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                EditText edt = (EditText) findViewById(R.id.editText4);
                assert edt != null;
                String abc = edt.getText().toString();
                EditText edt1 = (EditText) findViewById(R.id.editText5);
                assert edt1 != null;
                String xyz = edt1.getText().toString();
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contact From to We Are Henry App");
                intent.putExtra(Intent.EXTRA_TEXT, abc + ", is contacting you because of " + xyz);
                intent.setData(Uri.parse("mailto:wrhalert@gmail.com"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
