package com.sliit.hyko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    FragmentManager fragmentManager = getSupportFragmentManager();

    Fragment fragment = null;
    FragmentTransaction fragmentTransaction;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    return true;
                case R.id.nav_search:
                    fragment = new SearchFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.nav_post:
                    fragment = new AddPostFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.nav_like:
                    fragment = new FavouritesFragment();
                    switchFragment(fragment);
                    return true;
                case R.id.nav_profile:
                    fragment = new ProfileFragment();
                    switchFragment(fragment);
                    return true;
            }

            return false;
        }
    };


    private void switchFragment(Fragment fragment) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.body_container, fragment);
        fragmentTransaction.commit();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        navigationView = findViewById(R.id.bottomNavigationBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new HomeFragment()).commit();
        navigationView.setSelectedItemId(R.id.nav_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottomNavigationBar);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}

