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


/**
 * A simple {@link Fragment} subclass.
 */
public class TuristicosFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;


    public TuristicosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_turisticos, container, false);
        tabLayout = (TabLayout)view.findViewById(R.id.tabs3);
        viewPager = (ViewPager)view.findViewById(R.id.pager3);
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
                case 0: return new Tur1Fragment();
                case 1: return new Tur2Fragment();
                case 2: return new Tur3Fragment();
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
                case 0: return "La cruz";
                case 1: return "Iglesia San Juan";
                case 2: return "Las ballenas";
            }
            return null;
        }
    }



}
