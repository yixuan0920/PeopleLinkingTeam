package com.example.fragmentnavigationbottom;

import static com.example.fragmentnavigationbottom.LoginActivity.Active;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.MenuCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import com.example.fragmentnavigationbottom.databinding.ActivityDashboardBinding;

public class DashboardActivity extends AppCompatActivity {

    private ActivityDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_history, R.id.navigation_scan, R.id.navigation_statistics, R.id.navigation_profile, R.id.navigation_statistics_global, R.id.navigation_statistics_local, R.id.navigation_report)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    //Option menu creation
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //Option menu set up
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        // If option menu item selected is Settings, return true.
        if (id == R.id.settings) {
            Intent intent = new Intent(this,
                    SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        NavController navController = Navigation.findNavController(DashboardActivity.this,
                R.id.nav_host_fragment_activity_dashboard);

        switch (item.getItemId()) {
            case R.id.navigation_home:
                navController.navigate(R.id.navigation_home);
                return true;
            case R.id.navigation_history:
                navController.navigate(R.id.navigation_history);
                return true;
            case R.id.navigation_scan:
                navController.navigate(R.id.navigation_scan);
                return true;
            case R.id.navigation_statistics:
                navController.navigate(R.id.navigation_statistics);
                return true;
            case R.id.navigation_profile:
                navController.navigate(R.id.navigation_profile);
                return true;
            case R.id.navigation_logout:

                String mypreference = "regpref";

                SharedPreferences sharedpreferences = getSharedPreferences(mypreference,
                        Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt(Active, 0);
                editor.commit();
                startActivity(new Intent(this,LoginActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_dashboard);
//        return NavigationUI.navigateUp(navController, appBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
}