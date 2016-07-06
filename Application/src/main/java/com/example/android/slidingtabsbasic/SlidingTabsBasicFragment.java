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

    Context c;


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
            String item;
            switch(position){
                case 0: item = "Featured";
                    break;
                case 1: item = "Fun";
                    break;
                case 2: item = "Food";
                    break;
                case 3: item = "Retail";
                    break;
                case 4: item = "Travel";
                    break;
                case 5: item = "Wellness";
                    break;
                default:item = "Featured";
                    break;
            }
            return item;
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
            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item,
                    container, false);

            container.addView(view);

            // Retrieve a TextView from the inflated View, and update it's text
            //TODO insert expandable list here
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

            //working list here, have to chase it?
            /*
            CustomListAdapter adapter=new CustomListAdapter(getActivity(), itemname, imgid);
            list=(ListView)getActivity().findViewById(R.id.list);
            list.setAdapter(adapter);

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub
                    //TODO change to item page.
                }
            });
            */
           // view.setTag(list);

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

            Coupons t1=new Coupons("Man Utd");
            t1.deals.add("Wayne Rooney");
            t1.deals.add("Van Persie");
            t1.deals.add("Ander Herera");
            t1.deals.add("Juan Mata");

            Coupons t2=new Coupons("Arsenal");
            t2.deals.add("Aaron Ramsey");
            t2.deals.add("Mesut Ozil");
            t2.deals.add("Jack Wilshere");
            t2.deals.add("Alexis Sanchez");

            Coupons t3=new Coupons("Chelsea");
            t3.deals.add("John Terry");
            t3.deals.add("Eden Hazard");
            t3.deals.add("Diego Costa");
            t3.deals.add("Oscar");

            ArrayList<Coupons> allCoupons=new ArrayList<Coupons>();
            allCoupons.add(t1);
            allCoupons.add(t2);
            allCoupons.add(t3);

            return allCoupons;
        }
    }
}
