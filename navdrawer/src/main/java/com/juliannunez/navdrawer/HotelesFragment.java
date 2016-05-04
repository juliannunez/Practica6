package com.juliannunez.navdrawer;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.TabLayout;



public class HotelesFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    public HotelesFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        tabLayout = (TabLayout)view.findViewById(R.id.tabs2);
        viewPager = (ViewPager)view.findViewById(R.id.pager2);
        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        return view;
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new Hotel1Fragment();
                case 1: return new Hotel2Fragment();
                case 2: return new Hotel3Fragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "Hotel brazil";
                case 1: return "Vista hermosa";
                case 2: return "Villa Raquel";
            }
            return null;
        }
    }



}


