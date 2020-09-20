package com.example.onlinefreelaceapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.onlinefreelaceapp.Common.LoginSignup.RetailerStartUpScreen;
import com.example.onlinefreelaceapp.Common.PostRequest;
import com.example.onlinefreelaceapp.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.onlinefreelaceapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.onlinefreelaceapp.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.onlinefreelaceapp.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.onlinefreelaceapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featuredRecycler;
    RecyclerView featuredRecyclerTwo;
    RecyclerView featuredRecyclerThree;
    RecyclerView.Adapter adapter;
    ImageView menuIcon;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //Hooks
        featuredRecycler = findViewById(R.id.featured_recycler);
        featuredRecyclerTwo = findViewById(R.id.featured_recycler_two);
        featuredRecyclerThree = findViewById(R.id.featured_recycler_three);
        menuIcon = findViewById(R.id.menu_icon);

        //Hooks Navigation
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);


        navigationDrawer();
        featuredRecycler();
        featuredRecyclerTwo();
        featuredRecyclerThree();

    }

    public void callLoginSignupScreen(View view){

        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));

    }


    //Navigation Drawer

    private void navigationDrawer() {

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(drawerLayout.isDrawerVisible(GravityCompat.START)){
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });


    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_home:
            break;
            case R.id.nav_post_request:
                Intent intent = new Intent(getApplicationContext(),PostRequest.class);
                startActivity(intent);
                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    //Recycler View

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredGigs = new ArrayList<>();

        featuredGigs.add(new FeaturedHelperClass(R.drawable.flyer_design,"Flyer Design","I will do creative business flyer poster design.I\'ll give you Unlimited Modification for your Design."));
        featuredGigs.add(new FeaturedHelperClass(R.drawable.digital_marketing_img,"Facebook Marketing","I will create, design and optimize facebook business page."));
        featuredGigs.add(new FeaturedHelperClass(R.drawable.logo_design_img,"Logo Design","I will create professional business logo designs."));

        adapter = new FeaturedAdapter(featuredGigs);
        featuredRecycler.setAdapter(adapter);

    }

    private void featuredRecyclerTwo() {

        featuredRecyclerTwo.setHasFixedSize(true);
        featuredRecyclerTwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredGigs = new ArrayList<>();

        featuredGigs.add(new FeaturedHelperClass(R.drawable.flyer_design,"Flyer Design","I will do creative business flyer poster design.I\'ll give you Unlimited Modification for your Design."));
        featuredGigs.add(new FeaturedHelperClass(R.drawable.digital_marketing_img,"Facebook Marketing","I will create, design and optimize facebook business page."));
        featuredGigs.add(new FeaturedHelperClass(R.drawable.logo_design_img,"Logo Design","I will create professional business logo designs."));

        adapter = new FeaturedAdapter(featuredGigs);
        featuredRecyclerTwo.setAdapter(adapter);

    }


    private void featuredRecyclerThree() {

        featuredRecyclerThree.setHasFixedSize(true);
        featuredRecyclerThree.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredGigs = new ArrayList<>();

        featuredGigs.add(new FeaturedHelperClass(R.drawable.flyer_design,"Flyer Design","I will do creative business flyer poster design.I\'ll give you Unlimited Modification for your Design."));
        featuredGigs.add(new FeaturedHelperClass(R.drawable.digital_marketing_img,"Facebook Marketing","I will create, design and optimize facebook business page."));
        featuredGigs.add(new FeaturedHelperClass(R.drawable.logo_design_img,"Logo Design","I will create professional business logo designs."));

        adapter = new FeaturedAdapter(featuredGigs);
        featuredRecyclerThree.setAdapter(adapter);

    }






}