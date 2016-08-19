package com.example.jh.douban;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends BaseActivity {

    private ViewPager mPager;
    private PagerSlidingTabStrip mPagetTab;
    private Toolbar mToolb;
    private ActionBarDrawerToggle mDrawerT;
    private NavigationView mNaviga;
    private DrawerLayout mDlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager = (ViewPager) findViewById(R.id.Page);
        mPagetTab = (PagerSlidingTabStrip) findViewById(R.id.pager_tab);
        mToolb = (Toolbar) findViewById(R.id.toolbar);
        mNaviga = (NavigationView) findViewById(R.id.navigation);
        mDlayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        setSupportActionBar(mToolb); //supprot 意为支持。
        mDrawerT =new ActionBarDrawerToggle(this,mDlayout,mToolb,R.string.drawer_open,R.string.drawer_close);
        mDrawerT.syncState();
        mDlayout.addDrawerListener(mDrawerT);
        mPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        mPager.setOffscreenPageLimit(3);
        mPagetTab.setViewPager(mPager);
        NavigationListener();
    }

    public void NavigationListener(){
        mNaviga.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                selectionItem(item);
                item.setChecked(true);
                mDlayout.closeDrawers();
                return true;
            }
        });
    }

    private void selectionItem(MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_list_1:
                    mPager.setCurrentItem(0);
                    break;
                case R.id.nav_list_2:
                    mPager.setCurrentItem(1);
                    break;
                case R.id.nav_list_3:
                    mPager.setCurrentItem(2);
                    break;
                case R.id.nav_list_4:
                    mPager.setCurrentItem(3);
                    break;
                    default:
                        Toast.makeText(MainActivity.this, "执行失败，没有选中", Toast.LENGTH_SHORT).show();
            }
    }

    private class PagerAdapter extends FragmentPagerAdapter{

        private final String[] TITLE_NUMBLE = getResources().getStringArray(R.array.tile_value);

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLE_NUMBLE[position];
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            Fragment fragment= null;
            if(position == 0){
                 fragment = new ListFragment();
            }else {
                fragment = new TextFragment();
            }
            bundle.putInt("position_value",position);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return TITLE_NUMBLE.length;
        }
    }
}
