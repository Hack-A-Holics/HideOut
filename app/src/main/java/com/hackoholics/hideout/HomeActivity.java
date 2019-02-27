package com.hackoholics.hideout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static java.sql.Types.NULL;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ArrayList<Property> locations = new ArrayList<>();

        locations.add(new Property(R.drawable.home, "name", "address", 350, "3 km away"));
        locations.add(new Property(R.drawable.home, "name", "address", 3500, "3 km away"));
        locations.add(new Property(R.drawable.home, "name", "address", 4500, "3 km away"));
        locations.add(new Property(R.drawable.home, "name", "address", 350, "3 km away"));
        locations.add(new Property(R.drawable.home, "name", "address", 350, "3 km away"));
        locations.add(new Property(NULL, "name", "address", 350, "3 km away"));

        PropertyAdapter adapter = new PropertyAdapter(getApplicationContext(), locations);
        ListView listView = findViewById(R.id.list_view);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i = new Intent(getApplicationContext(), DetailsActivity.class);
                startActivity(i);
            }

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        moveTaskToBack(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.logout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_logout) {
            return true;
        } else if (id == R.id.action_addProperty) {
            Intent i = new Intent(getApplicationContext(), AddNewPropertyActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.myProperty) {
            Intent i = new Intent(getApplicationContext(), MyPropertiesActivity.class);
            startActivity(i);
        } else if (id == R.id.myWishList) {
            Intent i = new Intent(getApplicationContext(), BookmarksActivity.class);
            startActivity(i);
        } else if (id == R.id.myProfile) {

        } else if (id == R.id.action_logout) {

//            AuthUI.getInstance()
//                    .signOut(this)
//                    .addOnCompleteListener(new OnCompleteListener<Void>() {
//                        public void onComplete(@NonNull Task<Void> task) {
//                            Intent i = new Intent(getApplicationContext(),SplashScreen.class);
//                            startActivity(i);
//                            //finish();
//                        }
//                    });
            finish();

        } else if (id == R.id.settings) {

        } else if (id == R.id.feedback) {
            Intent i = new Intent(getApplicationContext(), FeedbackActivity.class);
            startActivity(i);
        } else if (id == R.id.rateUs) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://DetailsActivity?id=" + this.getPackageName())));
            } catch (android.content.ActivityNotFoundException ex) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/DetailsActivity?id=" + this.getPackageName())));
            }

        } else if (id == R.id.share) {

            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Hey, check out this new app called \"HideOut - Easily find rooms, flats, houses, etc. for rent\"  : http://play.google.com/store/apps/DetailsActivity?id=" + this.getPackageName());
            sharingIntent.setType("text/plain");
            startActivity(sharingIntent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
