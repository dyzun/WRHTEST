package com.example.android.slidingtabsbasic;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
        private Context c;
        private ArrayList<Coupons> coupons;
        private LayoutInflater inflater;

        public CustomExpandableListAdapter(Context c,ArrayList<Coupons> coupons)
        {
            this.c=c;
            this.coupons=coupons;
            inflater=(LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        //GET A SINGLE PLAYER
        @Override
        public Object getChild(int groupPos, int childPos) {
            // TODO Auto-generated method stub
            return coupons.get(groupPos).deals.get(childPos);
        }
        //GET PLAYER ID
        @Override
        public long getChildId(int arg0, int arg1) {
            // TODO Auto-generated method stub
            return 0;
        }
        class ChildHolder {
            CheckBox checkBox1;
            TextView name;
            Button button;
        }
        public Object getRedeemed(int groupPos) {
        // TODO Auto-generated method stub
            return coupons.get(groupPos).redeemed;
        }
        public Object getSaved(int groupPos) {
        //TODO Auto-generated method stub
          return coupons.get(groupPos).saved;
        }

        //GET PLAYER ROW
        @Override
        public View getChildView(final int groupPos, int childPos, boolean isLastChild, View convertView,
                                 ViewGroup parent) {
            //ONLY INFLATER XML ROW LAYOUT IF ITS NOT PRESENT,OTHERWISE REUSE IT
            /*if(convertView==null)
            {
                convertView=inflater.inflate(R.layout.deal, null);
            }*/
            final ChildHolder childHolder;
            if( convertView == null ){
                convertView = inflater.inflate(R.layout.deal, null);
                childHolder = new ChildHolder();
                childHolder.checkBox1 = (CheckBox) convertView.findViewById(R.id.checkBox);
                childHolder.name=(TextView)convertView.findViewById(R.id.textView1);
                childHolder.button = (Button) convertView.findViewById(R.id.button); //TODO redeem button
                convertView.setTag(childHolder);
            }else{
                childHolder = (ChildHolder) convertView.getTag();
            }
            String  child=(String) getChild(groupPos, childPos);
            childHolder.name.setText(child);
            boolean saved=(boolean) getSaved(groupPos);
            childHolder.checkBox1.setChecked(saved);
            assert childHolder.button != null;
            childHolder.checkBox1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c);
                            SharedPreferences.Editor editor = preferences.edit();
                            if(((CheckBox)v).isChecked()) {
                                childHolder.checkBox1.setChecked(true);
                                editor.putBoolean(coupons.get(groupPos).getName(), true);// edits preferences to hold data of saved coupon
                                editor.apply();
                                Toast.makeText(c,
                                        "this is saved",Toast.LENGTH_LONG).show();// TODO remove when debugging is over
                            }
                            else{
                                editor.putBoolean(coupons.get(groupPos).getName(), false);// edits preferences to hold data of saved coupon
                                editor.apply();
                            }
                        }
                    }
            );

            childHolder.button.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(c);
                            Intent intent = new Intent(c, VoucherActivity.class);
                            intent.putExtra("name", coupons.get(groupPos).getName());
                            String stringDate = DateFormat.getDateInstance().format(coupons.get(groupPos).getExpire());
                            intent.putExtra("date",stringDate );
                            intent.putExtra("dets", childHolder.name.getText().toString());
                            intent.putExtra("saved", preferences.getBoolean(coupons.get(groupPos).getName(), false));
                            intent.putExtra("Voc",coupons.get(groupPos).getVoc() );
                            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            c.startActivity(intent);
                        }
                    }
            );



            //TODO implement redeem button MAKE INTENT TO CARRY TO VOUCHER PAGE&MAKE VOUCHER PAGE

            return convertView;
        }
        //GET NUMBER OF deals
        @Override
        public int getChildrenCount(int groupPosw) {
            // TODO Auto-generated method stub
            return coupons.get(groupPosw).deals.size();
        }
        //GET coupons
        @Override
        public Object getGroup(int groupPos) {
            // TODO Auto-generated method stub
            return coupons.get(groupPos);
        }
        //GET NUMBER OF couponsS
        @Override
        public int getGroupCount() {
            // TODO Auto-generated method stub
            return coupons.size();
        }
        //GET coupons ID
        @Override
        public long getGroupId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
        //GET coupons ROW
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            //ONLY INFLATE XML coupons ROW MODEL IF ITS NOT PRESENT,OTHERWISE REUSE IT
            if(convertView == null)
            {
                convertView=inflater.inflate(R.layout.coupon, null);
            }
            //GET GROUP/coupons ITEM
            Coupons t=(Coupons) getGroup(groupPosition);
            //SET GROUP NAME
            TextView nameTv=(TextView) convertView.findViewById(R.id.textView1);
            ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);
            TextView dateTv=(TextView) convertView.findViewById(R.id.textView2);
            Date date = t.getExpire();
            String stringDate = DateFormat.getDateInstance().format(date);

            String name=t.name;
            nameTv.setText(name);
            dateTv.setText("Expires: " +stringDate);
            //ASSIGN coupons IMAGES ACCORDING TO coupons NAME
            //TODO find way to connect to online database
            switch (name) {
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

            //SET coupons ROW BACKGROUND COLOR
            convertView.setBackgroundColor(Color.LTGRAY);
            return convertView;
        }
        @Override
        public boolean hasStableIds() {
            // TODO Auto-generated method stub
            return false;
        }
        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            // TODO Auto-generated method stub
            return true;
        }

}