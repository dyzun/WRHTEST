package com.example.android.slidingtabsbasic;

import com.example.android.common.view.SlidingTabLayout;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SlidingTabsBasicFragment extends Fragment {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;
    String title;
    Boolean saved = false;

    public void setSavedList(Boolean saved) {
        this.saved = saved;
    }

    public Boolean getSavedList() {
        return saved;
    }

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

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.pager_item, container, false);

            container.addView(view);

            // Retrieve a TextView from the inflated View, and update it's text
            ExpandableListView elv=(ExpandableListView) view.findViewById(R.id.expandableListView1);
            final ArrayList<Coupons> Coupons=getData(position);
            //final ArrayList<Coupons> savedCoupons=saving(Coupons);

            //CREATE AND BIND TO ADAPTER
            CustomExpandableListAdapter adapter = new CustomExpandableListAdapter(getActivity(), Coupons);//, savedCoupons, getSavedList());
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

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        private ArrayList<Coupons> getData(int position)
        {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SharedPreferences.Editor editor = preferences.edit();


            Coupons t1=new Coupons("Coupon 1");
            t1.deals.add("Description of coupon 1\n");
            t1.setCategory("Food");
            t1.setFeatured(true);
            t1.setSaved(true);
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, 2017);
            cal.set(Calendar.MONTH, Calendar.JANUARY);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            Date date = cal.getTime();
            t1.setExpire(date);
            if(!preferences.getBoolean(t1.getName(), false)) {
                editor.putBoolean(t1.getName(), t1.isSaved());
                editor.apply();
            }
            Boolean saved = preferences.getBoolean(t1.getName(), false);
            t1.setSaved(saved);


            Coupons t2=new Coupons("Coupon 2");
            t2.deals.add("Description of coupon 2\n");
            t2.setCategory("Retail");
            t2.setFeatured(false);
            Calendar cal2 = Calendar.getInstance();
            cal2.set(Calendar.YEAR, 2017);
            cal2.set(Calendar.MONTH, Calendar.JANUARY);
            cal2.set(Calendar.DAY_OF_MONTH, 1);
            Date date2 = cal2.getTime();
            t2.setExpire(date2);
            if(!preferences.getBoolean(t2.getName(), false)) {
                editor.putBoolean(t2.getName(), t2.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t2.getName(), false);
            t2.setSaved(saved);

            Coupons t3=new Coupons("Coupon 3");
            t3.deals.add("Description of coupon 3\n");
            t3.setCategory("Fun");
            t3.setFeatured(true);
            Calendar cal3 = Calendar.getInstance();
            cal3.set(Calendar.YEAR, 2017);
            cal3.set(Calendar.MONTH, Calendar.JANUARY);
            cal3.set(Calendar.DAY_OF_MONTH, 1);
            Date date3 = cal3.getTime();
            t3.setExpire(date3);
            if(!preferences.getBoolean(t3.getName(), false)) {
                editor.putBoolean(t3.getName(), t3.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t3.getName(), false);
            t3.setSaved(saved);

            Coupons t4=new Coupons("Coupon 4");
            t4.deals.add("Description of coupon 4\n");
            t4.setCategory("Travel");
            t4.setFeatured(false);
            Calendar cal4 = Calendar.getInstance();
            cal4.set(Calendar.YEAR, 2017);
            cal4.set(Calendar.MONTH, Calendar.JANUARY);
            cal4.set(Calendar.DAY_OF_MONTH, 1);
            Date date4 = cal4.getTime();
            t4.setExpire(date4);
            if(!preferences.getBoolean(t4.getName(), false)) {
                editor.putBoolean(t4.getName(), t4.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t4.getName(), false);
            t4.setSaved(saved);

            Coupons t5=new Coupons("Coupon 5");
            t5.deals.add("Description of coupon 5\n");
            t5.setCategory("Wellness");
            t5.setFeatured(true);
            Calendar cal5 = Calendar.getInstance();
            cal5.set(Calendar.YEAR, 2017);
            cal5.set(Calendar.MONTH, Calendar.JANUARY);
            cal5.set(Calendar.DAY_OF_MONTH, 1);
            Date date5 = cal5.getTime();
            t5.setExpire(date5);
            if(!preferences.getBoolean(t5.getName(), false)) {
                editor.putBoolean(t5.getName(), t5.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t5.getName(), false);
            t5.setSaved(saved);

            Coupons t6=new Coupons("Coupon 6");
            t6.deals.add("Description of coupon 6\n");
            t6.setCategory("Travel");
            t6.setFeatured(true);
            Calendar cal6 = Calendar.getInstance();
            cal6.set(Calendar.YEAR, 2017);
            cal6.set(Calendar.MONTH, Calendar.JANUARY);
            cal6.set(Calendar.DAY_OF_MONTH, 1);
            Date date6 = cal6.getTime();
            t6.setExpire(date6);
            if(!preferences.getBoolean(t6.getName(), false)) {
                editor.putBoolean(t6.getName(), t6.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t6.getName(), false);
            t6.setSaved(saved);

            Coupons t7=new Coupons("Coupon 7");
            t7.deals.add("Description of coupon 7\n");
            t7.setCategory("Wellness");
            t7.setFeatured(false);
            Calendar cal7 = Calendar.getInstance();
            cal7.set(Calendar.YEAR, 2017);
            cal7.set(Calendar.MONTH, Calendar.JANUARY);
            cal7.set(Calendar.DAY_OF_MONTH, 1);
            Date date7 = cal7.getTime();
            t7.setExpire(date7);
            if(!preferences.getBoolean(t7.getName(), false)) {
                editor.putBoolean(t7.getName(), t7.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t7.getName(), false);
            t7.setSaved(saved);

            Coupons t8=new Coupons("Coupon 8");
            t8.deals.add("Description of coupon 8\n");
            t8.setCategory("Food");
            t8.setFeatured(false);
            Calendar cal8 = Calendar.getInstance();
            cal8.set(Calendar.YEAR, 2017);
            cal8.set(Calendar.MONTH, Calendar.JANUARY);
            cal8.set(Calendar.DAY_OF_MONTH, 1);
            Date date8 = cal8.getTime();
            t8.setExpire(date8);
            if(!preferences.getBoolean(t8.getName(), false)) {
                editor.putBoolean(t8.getName(), t8.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t8.getName(), false);
            t8.setSaved(saved);

            Coupons t9=new Coupons("Coupon 9");
            t9.deals.add("Description of coupon 9\n");
            t9.setCategory("Retail");
            t9.setFeatured(true);
            Calendar cal9 = Calendar.getInstance();
            cal9.set(Calendar.YEAR, 2017);
            cal9.set(Calendar.MONTH, Calendar.JANUARY);
            cal9.set(Calendar.DAY_OF_MONTH, 1);
            Date date9 = cal9.getTime();
            t9.setExpire(date9);
            if(!preferences.getBoolean(t9.getName(), false)) {
                editor.putBoolean(t9.getName(), t9.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t9.getName(), false);
            t9.setSaved(saved);

            Coupons t10=new Coupons("Coupon 10");
            t10.deals.add("Description of coupon 10\n");
            t10.setCategory("Food");
            t10.setFeatured(false);
            Calendar cal10 = Calendar.getInstance();
            cal10.set(Calendar.YEAR, 2017);
            cal10.set(Calendar.MONTH, Calendar.JANUARY);
            cal10.set(Calendar.DAY_OF_MONTH, 1);
            Date date10 = cal10.getTime();
            t10.setExpire(date10);
            if(!preferences.getBoolean(t10.getName(), false)) {
                editor.putBoolean(t10.getName(), t10.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t10.getName(), false);
            t10.setSaved(saved);

            Coupons t11=new Coupons("Coupon 11");
            t11.deals.add("Description of coupon 11\n");
            t11.setCategory("Fun");
            t11.setFeatured(false);
            Calendar cal11 = Calendar.getInstance();
            cal11.set(Calendar.YEAR, 2017);
            cal11.set(Calendar.MONTH, Calendar.JANUARY);
            cal11.set(Calendar.DAY_OF_MONTH, 1);
            Date date11 = cal11.getTime();
            t11.setExpire(date11);
            if(!preferences.getBoolean(t11.getName(), false)) {
                editor.putBoolean(t11.getName(), t11.isSaved());
                editor.apply();
            }
            saved = preferences.getBoolean(t11.getName(), false);
            t11.setSaved(saved);

            ArrayList<Coupons> allCoupons=new ArrayList<Coupons>();
            allCoupons.add(t1);
            allCoupons.add(t2);
            allCoupons.add(t3);
            allCoupons.add(t4);
            allCoupons.add(t5);
            allCoupons.add(t6);
            allCoupons.add(t7);
            allCoupons.add(t8);
            allCoupons.add(t9);
            allCoupons.add(t10);
            allCoupons.add(t11);

            if(getSavedList()){//TODO use new array list of saved coupons
                for(int i =allCoupons.size()-1; i>=0; i--){
                    saved = preferences.getBoolean(allCoupons.get(i).getName(), false);
                    if(!saved)
                        allCoupons.remove(i);
                }
            }

            switch(position){
                case 0:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                        if(!allCoupons.get(i).isFeatured())
                            allCoupons.remove(i);
                    }
                    break;
                case 1:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                        if(!allCoupons.get(i).getCategory().equals("Fun"))
                            allCoupons.remove(i);
                    }
                    break;
                case 2:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                        if(!allCoupons.get(i).getCategory().equals("Food"))
                            allCoupons.remove(i);
                    }
                    break;
                case 3:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                        if(!allCoupons.get(i).getCategory().equals("Retail"))
                            allCoupons.remove(i);
                    }
                    break;
                case 4:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                    if(!allCoupons.get(i).getCategory().equals("Travel"))
                        allCoupons.remove(i);
                    }
                    break;
                case 5:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                        if(!allCoupons.get(i).getCategory().equals("Wellness"))
                        allCoupons.remove(i);
                    }
                    break;
                default:
                    for(int i =allCoupons.size()-1; i>=0; i--){
                        if(!allCoupons.get(i).isFeatured())
                            allCoupons.remove(i);
                    }
                    break;
            }
            return allCoupons;
        }

        private ArrayList<Coupons> saving(ArrayList<Coupons> coupons)
        {
            ArrayList<Coupons> savedCoupons=new ArrayList<Coupons>();
            for(int i =coupons.size()-1; i>=0; i--){
                if(coupons.get(i).isSaved())
                    savedCoupons.add(coupons.get(i));
            }
            return savedCoupons;
        }

    }
}