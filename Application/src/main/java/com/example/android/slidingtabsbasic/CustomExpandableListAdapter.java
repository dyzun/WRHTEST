package com.example.android.slidingtabsbasic;

import java.text.DateFormat;
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
            //Date date=(Date) getChild(groupPos, childPos);
            //String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


            //SET CHILD NAME
            TextView nameTv=(TextView) convertView.findViewById(R.id.textView1);
            //ImageView img=(ImageView) convertView.findViewById(R.id.imageView1);
            //TextView dateTv=(TextView) convertView.findViewById(R.id.textView2);
            nameTv.setText(child);
            //dateTv.setText(currentDateTimeString);

            //GET coupons NAME
            String couponsName= getGroup(groupPos).toString();

            //ASSIGN IMAGES TO deals ACCORDING TO THEIR NAMES AN couponsS
            /*if(couponsName=="Man Utd")
            {
                if(child=="Wayne Rooney")
                {
                    img.setImageResource(R.drawable.rooney)  ;
                }else if(child=="Ander Herera")
                {
                    img.setImageResource(R.drawable.herera)  ;
                }else if(child=="Van Persie")
                {
                    img.setImageResource(R.drawable.vanpersie)  ;
                }else if(child=="Juan Mata")
                {
                    img.setImageResource(R.drawable.mata)  ;
                }
            }else if(couponsName=="Chelsea")
            {
                if(child=="John Terry")
                {
                    img.setImageResource(R.drawable.terry)  ;
                }else if(child=="Eden Hazard")
                {
                    img.setImageResource(R.drawable.hazard)  ;
                }else if(child=="Oscar")
                {
                    img.setImageResource(R.drawable.oscar)  ;
                }else if(child=="Diego Costa")
                {
                    img.setImageResource(R.drawable.costa)  ;
                }
            }else if(couponsName=="Arsenal")
            {
                if(child=="Jack Wilshere")
                {
                    img.setImageResource(R.drawable.wilshere)  ;
                }else if(child=="Alexis Sanchez")
                {
                    img.setImageResource(R.drawable.sanchez)  ;
                }else if(child=="Aaron Ramsey")
                {
                    img.setImageResource(R.drawable.ramsey)  ;
                }else if(child=="Mesut Ozil")
                {
                    img.setImageResource(R.drawable.ozil)  ;
                }
            }*/

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

            String name=t.name;
            nameTv.setText(name);

            //ASSIGN coupons IMAGES ACCORDING TO coupons NAME

            if(name=="Coupon 1")
            {
                img.setImageResource(R.drawable.cop1);
            }else if(name=="Coupon 2")
            {
                img.setImageResource(R.drawable.cop2);
            }else if(name=="Coupon 3")
            {
                img.setImageResource(R.drawable.cop3);
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
