package winds.com.androidtutorial.fragment;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewpagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> data;
    Context context;

    public MainViewpagerAdapter(FragmentManager fm, ArrayList<Fragment> data, Context context) {
        super(fm);
        this.data = data;
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        return data.get(i);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Category";
            case 1:
                return "Place";
            default:
                return "Contact";
        }
    }
}
