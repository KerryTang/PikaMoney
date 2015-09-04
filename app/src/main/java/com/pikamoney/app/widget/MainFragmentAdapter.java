package com.pikamoney.app.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.Display;
import android.view.WindowManager;
import com.pikamoney.app.FragmentId;
import com.pikamoney.app.R;
import com.pikamoney.app.fragment.*;

/**
 * Created by KerryTang on 2014/12/28.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private final static int[] imageResId = {
            R.drawable.ic_tab_record,
            R.drawable.ic_tab_check,
            R.drawable.ic_tab_analysis,
            R.drawable.ic_tab_shopping
    };
    private final static int[] imageSelectedResId = {
            R.drawable.ic_tab_record_selected,
            R.drawable.ic_tab_check_selected,
            R.drawable.ic_tab_analysis_selected,
            R.drawable.ic_tab_shopping_selected
    };

    private Activity        activity;
    private FragmentManager manager;

    private int tabWidth;

    public MainFragmentAdapter(Activity activty, FragmentManager manager) {
        super(manager);
        this.activity = activty;
        this.manager  = manager;
    }

    @Override
    public Fragment getItem(int fid) {

        /* Find fragment if exist */
        Fragment fragment = manager.findFragmentByTag(String.valueOf(fid));
        if(fragment == null) {
            switch (fid) {
                case FragmentId.RECORD_FRAGMENT:
                    fragment = new RecordFragment();
                    break;
                case FragmentId.CHECK_FRAGMENT:
                    fragment = new CheckFragment();
                    break;
                case FragmentId.ANALYSIS_FRAGMENT:
                    fragment = new AnalysisFragment();
                    break;
                case FragmentId.SHOPPING_FRAGMENT:
                    fragment = new ShoppingFragment();
                    break;

            }
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return FragmentId.MAIN_FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {


        Drawable image = activity.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, 88, 110);
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
