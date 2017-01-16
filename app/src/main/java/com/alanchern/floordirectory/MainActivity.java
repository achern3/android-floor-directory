package com.alanchern.floordirectory;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alanchern.floordirectory.fragment.DirectoryFragment;
import com.alanchern.floordirectory.fragment.EventsFragment;
import com.alanchern.floordirectory.model.Unit;
import com.alanchern.floordirectory.fragment.UnitDetailFragment;
import com.alanchern.floordirectory.utils.NonSwipeableViewPager;

public class MainActivity extends AppCompatActivity {
    private ActionBar mActionBar;
    private MainPageAdapter mAdapter;
    private boolean detailClicked = false;
    private Unit mUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.layout_container);
        mainLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        mAdapter = new MainPageAdapter(getSupportFragmentManager());
        NonSwipeableViewPager viewPager = (NonSwipeableViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(mAdapter);

        // tablayout reference:
        // https://guides.codepath.com/android/google-play-style-tabs-using-tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));
            // todo font awesome back arrow: fa_arrow-left
        }
    }

    private class MainPageAdapter extends FragmentStatePagerAdapter {
        MainPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new DirectoryFragment();
                    if (detailClicked) {
                        detailClicked = false;
                        if (mUnit != null) {
                            fragment = UnitDetailFragment.newInstance(mUnit);
                            showBackButton();
                            mUnit = null;
                        } else {
                            Toast.makeText(getApplicationContext(), getString(R.string.error_occurred), Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;
                case 1:
                    fragment = new EventsFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position) {
                case 0:
                    title = getString(R.string.directory);
                    break;
                case 1:
                    title = getString(R.string.events);
                    break;
            }
            return title;
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }

    public void showUnitDetail(Unit unit) {
        detailClicked = true;
        mUnit = unit;
        mAdapter.notifyDataSetChanged();
    }

    public void showBackButton() {
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void hideBackButton() {
        if (mActionBar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
