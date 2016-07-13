package com.example.android.slidingtabsbasic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        //GET PLAYER ROW
        @Override
        public View getChildView(int groupPos, int childPos, boolean isLastChild, View convertView,
                                 ViewGroup parent) {
            //ONLY INFLATER XML ROW LAYOUT IF ITS NOT PRESENT,OTHERWISE REUSE IT
            if(convertView==null)
            {
                convertView=inflater.inflate(R.layout.deal, null);
            }

            //GET CHILD/PLAYER NAME
            String  child=(String) getChild(groupPos, childPos);

            //SET CHILD NAME
            TextView nameTv=(TextView) convertView.findViewById(R.id.textView1);

            nameTv.setText(child);

            //GET coupons NAME
            String couponsName= getGroup(groupPos).toString();

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

            if(name.equals("Coupon 1"))
            {
                img.setImageResource(R.drawable.cop1);
            }else if(name.equals("Coupon 2"))
            {
                img.setImageResource(R.drawable.cop2);
            }else if(name.equals("Coupon 3"))
            {
                img.setImageResource(R.drawable.cop3);
            }else if(name.equals("Coupon 4"))
            {
                img.setImageResource(R.drawable.cop4);
            }else if(name.equals("Coupon 5"))
            {
                img.setImageResource(R.drawable.cop5);
            }else if(name.equals("Coupon 6"))
            {
                img.setImageResource(R.drawable.cop6);
            }else if(name.equals("Coupon 7"))
            {
                img.setImageResource(R.drawable.cop7);
            }else if(name.equals("Coupon 8"))
            {
                img.setImageResource(R.drawable.cop8);
            }else if(name.equals("Coupon 9"))
            {
                img.setImageResource(R.drawable.cop9);
            }else if(name.equals("Coupon 10"))
            {
                img.setImageResource(R.drawable.cop10);
            }else if(name.equals("Coupon 11"))
            {
                img.setImageResource(R.drawable.cop11);
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
