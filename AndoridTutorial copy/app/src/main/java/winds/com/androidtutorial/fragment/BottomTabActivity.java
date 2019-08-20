package winds.com.androidtutorial.fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import winds.com.androidtutorial.R;
import winds.com.androidtutorial.recyclerview.model.Place;

public class BottomTabActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView navBottom;
    PlaceFragment placeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);
        init();
        configNav();
    }

    void init() {
        navBottom = findViewById(R.id.nav_bottom);
        placeFragment = new PlaceFragment();

    }

    void configNav(){
        navBottom.setOnNavigationItemSelectedListener(this);
        displayFragment(new PlaceFragment());
        navBottom.setSelectedItemId(R.id.nav_place);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_category:{
               displayFragment(new CategoryFragment());
                break;
            }
            case R.id.nav_place:{
               displayFragment(placeFragment);
                break;
            }
            default:{
                displayFragment(new ContactFragment());
                break;
            }
        }
        return true;
    }

    void displayFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
