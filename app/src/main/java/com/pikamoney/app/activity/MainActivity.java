package com.pikamoney.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.*;
import android.widget.Toast;
import com.pikamoney.app.FragmentId;
import com.pikamoney.app.R;
import com.pikamoney.app.fragment.RecordFragment;
import com.pikamoney.app.widget.MainFragmentAdapter;
import com.pikamoney.app.widget.SlidingTabLayout;


public class MainActivity extends FragmentActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager           mViewPager;
    private Toolbar             mToolbar;
    private SlidingTabLayout    mSlidingTab;
    private MainFragmentAdapter mMainFragmentAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar    = (Toolbar) findViewById(R.id.toolbar_main);

        mViewPager  = (ViewPager) findViewById(R.id.viewPager_main);
        mSlidingTab = (SlidingTabLayout) findViewById(R.id.tab_main);

        mMainFragmentAdapter = new MainFragmentAdapter(this, mFragmentManager);
        mViewPager.setAdapter(mMainFragmentAdapter);
        mSlidingTab.setCustomTabView(R.layout.custom_tab, 0);
        mSlidingTab.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return R.color.green;
            }

            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });
        mSlidingTab.setViewPager(mViewPager, getResources().getDisplayMetrics().widthPixels);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public Fragment getFragment(int fid) {
        return mMainFragmentAdapter.getItem(fid);
    }



}
