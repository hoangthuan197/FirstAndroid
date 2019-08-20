package winds.com.androidtutorial.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import winds.com.androidtutorial.R;

public class MainActivity extends AppCompatActivity {

    ViewPager vpMain;
    ArrayList<Fragment> data = new ArrayList<>();
    TabLayout tabHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        prepareData();
        configVP();
    }

    void init(){
        vpMain = findViewById(R.id.vp_main);
        tabHeader = findViewById(R.id.tab_header);
    }

    void prepareData(){
        PlaceFragment placeFragment = new PlaceFragment();
        ContactFragment contactFragment = new ContactFragment();
        CategoryFragment categoryFragment = new CategoryFragment();
        data.add(categoryFragment);
        data.add(placeFragment);
        data.add(contactFragment);

    }

    void configVP(){
    MainViewpagerAdapter mainViewpagerAdapter = new MainViewpagerAdapter(getSupportFragmentManager(), data, this);
    vpMain.setOffscreenPageLimit(4);
    vpMain.setAdapter(mainViewpagerAdapter);

    tabHeader.setupWithViewPager(vpMain);
    }


}
