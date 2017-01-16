package com.alanchern.floordirectory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.alanchern.floordirectory.model.Unit;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        /*RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.layout_container);
        mainLayout.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);*/

        init();
    }

    private void init() {

        // this number might be specified by user later on

    }

    public class MainPageAdapter extends FragmentStatePagerAdapter {
        public MainPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new DirectoryFragment();
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
            return ("Page " + position);
        }
    }

    private int mCurrentFloor = -1;
    public void showFloorUnit(int floor) {
        if (floor != mCurrentFloor) {
            mCurrentFloor = floor;
            // todo call some sort of database to retrieve the unit info associated with the floor
            ArrayList<Unit> unitList = new ArrayList<>(1);

            // start test code
            /*switch (floor) {
                case 1:
                    Unit unit1 = new Unit(1, "102A", "Google");
                    unitList.add(unit1);
                    break;
                case 2:
                    Unit unit2a = new Unit(2, "218C", "Microsoft");
                    unitList.add(unit2a);
                    Unit unit2b = new Unit(2, "999Z", "A company with a really long name");
                    unitList.add(unit2b);
                    break;
                case 3:
                    Unit unit3 = new Unit(3, "301E", "Apple");
                    unitList.add(unit3);
                    break;
                case 4:
                    Unit unit4 = new Unit(4, "411B", "Tesla");
                    unitList.add(unit4);
                    break;
                case 5:
                    Unit unit5 = new Unit(5, "530D", "Facebook");
                    unitList.add(unit5);
                    break;
            }*/
            // end test code
        }
    }

    public void showUnitDetail(Unit unit) {
        /*FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        UnitDetailFragment unitDetailFragment = UnitDetailFragment.newInstance(unit);
        transaction.replace(R.id.unit_detail_frame, unitDetailFragment).commit();*/
    }
}
