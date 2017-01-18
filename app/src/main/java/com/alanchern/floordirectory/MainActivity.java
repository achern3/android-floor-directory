package com.alanchern.floordirectory;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alanchern.floordirectory.fragments.DirectoryFragment;
import com.alanchern.floordirectory.fragments.EventsFragment;
import com.alanchern.floordirectory.models.Unit;
import com.alanchern.floordirectory.fragments.UnitDetailFragment;
import com.alanchern.floordirectory.utils.NonSwipeableViewPager;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.FontAwesomeIcons;

public class MainActivity extends AppCompatActivity {
    private ActionBar mActionBar;
    private MainPageAdapter mAdapter;
    private boolean mDetailClicked = false;
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
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        if (!mDetailClicked) {
                            hideBackButton();
                        } else {
                            showBackButton();
                        }
                        break;
                    case 1:
                        hideBackButton();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {}
        });
        viewPager.setAdapter(mAdapter);

        // tablayout reference:
        // https://guides.codepath.com/android/google-play-style-tabs-using-tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(new IconDrawable(this, FontAwesomeIcons.fa_arrow_left)
                    .actionBarSize().colorRes(R.color.white));
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
                    if (mDetailClicked) {
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
        mDetailClicked = true;
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

    private void onCustomBackPressed() {
        mDetailClicked = false;
        hideBackButton();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onCustomBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
