package com.hyun.allergy.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.hyun.allergy.Fragments.Category;
import com.hyun.allergy.Fragments.Favorite;
import com.hyun.allergy.Fragments.Home;
import com.hyun.allergy.Fragments.Mypage;
import com.hyun.allergy.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Menu menu;

    Home homeFragment;
    Category categoryFragment;
    Favorite favoriteFragment;
    Mypage mypageFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ExpandableListView elv = (ExpandableListView) findViewById(R.id.elv);

        final ArrayList<Position> position = getData();

        //create and bind to adatper
        myAdapter adapter = new myAdapter(this, position);
        elv.setAdapter(adapter);

        //set onclick listener
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(), position.get(groupPosition).players.get(childPosition), Toast.LENGTH_LONG).show();
                return false;
            }
        });

        homeFragment = new Home();
        categoryFragment = new Category();
        favoriteFragment = new Favorite();
        mypageFragment = new Mypage();

        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();

        NavigationBarView navigationBarView = findViewById(R.id.bottom_navigationview);
        navigationBarView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                        return true;
                    case R.id.category:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, categoryFragment).commit();
                        return true;
                    case R.id.favorite:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, favoriteFragment).commit();
                        return true;
                    case R.id.mypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, mypageFragment).commit();
                        return true;
                }
                return false;
            }

        });
    }

    private ArrayList<Position> getData() {

        Position p1 = new Position("pitcher");
        p1.players.add("고원준");
        p1.players.add("Brook Raley");
        p1.players.add("박세웅");

        Position p2 = new Position("catcher");
        p2.players.add("강민호");
        p2.players.add("안중열");

        Position p3 = new Position("infield");
        p3.players.add("문규현");
        p3.players.add("박종윤");

        Position p4 = new Position("outfield");
        p4.players.add("Jim Adduci");
        p4.players.add("손아섭");

        ArrayList<Position> allposition = new ArrayList<>();
        allposition.add(p1);
        allposition.add(p2);
        allposition.add(p3);
        allposition.add(p4);

        return allposition;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.bottom_navigationview) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }








}