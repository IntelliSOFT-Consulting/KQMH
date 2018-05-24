package com.kqmh.app.kqmh.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;


public class BottomBarAdapter extends FragmentStatePagerAdapter {
    public BottomBarAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    private final List<Fragment> fragments = new ArrayList<>();

    // Our custom method that populates this Adapter with Fragments
    public void addFragments(Fragment fragment) {
        fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
