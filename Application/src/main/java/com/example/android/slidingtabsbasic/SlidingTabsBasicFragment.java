package com.example.android.slidingtabsbasic;

import com.example.android.slidingtabsbasic.CustomListAdapter;
import com.example.android.common.view.SlidingTabLayout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SlidingTabsBasicFragment extends Fragment {

    static final String LOG_TAG = "SlidingTabsBasicFragment";

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    String title;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());

        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            switch(position){
                case 0: title = "Featured";
                    break;
                case 1: title = "Fun";
                    break;
                case 2: title = "Food";
                    break;
                case 3: title = "Retail";
                    break;
                case 4: title = "Travel";
                    break;
                case 5: title = "Wellness";
                    break;
                default:title = "Featured";
                    break;
            }
            return title;
        }
        ListView list;
        String[] itemname ={
                "Safari",
                "Camera",
                "Global",
                "FireFox",
                "UC Browser",
                "Android Folder",
                "VLC Player",
                "Cold War"
        };

        Integer[] imgid={
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4,
                R.drawable.pic5,
                R.drawable.pic6,
                R.drawable.pic7,
                R.drawable.pic8,
        };
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item, container, false);

            container.addView(view);

            // Retrieve a TextView from the inflated View, and update it's text
            ExpandableListView elv=(ExpandableListView) getActivity().findViewById(R.id.expandableListView1);
            final ArrayList<Coupons> Coupons=getData();

            //CREATE AND BIND TO ADAPTER
            CustomExpandableListAdapter adapter=new CustomExpandableListAdapter(getActivity(), Coupons);
            elv.setAdapter(adapter);

            //SET ONCLICK LISTENER
            elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                @Override
                public boolean onChildClick(ExpandableListView parent, View v, int groupPos,
                                            int childPos, long id) {

                    Toast.makeText(getContext(), Coupons.get(groupPos).deals.get(childPos), Toast.LENGTH_SHORT).show();

                    return false;
                }
            });

            TextView title = (TextView) view.findViewById(R.id.item_title);
            title.setText(String.valueOf(position + 1));

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
        private ArrayList<Coupons> getData()
        {

            Coupons t1=new Coupons("Coupon 1");
            t1.deals.add("Description of coupon 1\n");

            Coupons t2=new Coupons("Coupon 2");
            t2.deals.add("Description of coupon 2\n");


            Coupons t3=new Coupons("Coupon 3");
            t3.deals.add("Description of coupon 3\n");


            ArrayList<Coupons> allCoupons=new ArrayList<Coupons>();
            allCoupons.add(t1);
            allCoupons.add(t2);
            allCoupons.add(t3);

            return allCoupons;
        }
    }
}
