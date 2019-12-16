package com.example.dofdof.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.example.dofdof.Controller.MainController;
import com.example.dofdof.Model.Pets;
import com.example.dofdof.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MainController mainController;
    private PetsFragment fragmentEveryPets,fragmentLevel1Pets,fragmentLevel60Pets;
    private Integer activeFragment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        this.mainController = new MainController(this);
        this.mainController.onStart();
    }

    public void initFragments(ArrayList<Pets> pets) {
        this.fragmentEveryPets = new PetsFragment();
        this.fragmentLevel1Pets = new PetsFragment();
        this.fragmentLevel60Pets = new PetsFragment();

        this.fragmentEveryPets.setPets(new ArrayList<>(pets),this);
        ArrayList<Pets> petsArrayList1 = new ArrayList<>();
        ArrayList<Pets> petsArrayList60 = new ArrayList<>();
        for(Pets petsFor:pets){
            if(petsFor.getLevel() == 1)
                petsArrayList1.add(petsFor);
            else
                petsArrayList60.add(petsFor);
        }
        this.fragmentLevel1Pets.setPets(petsArrayList1,this);
        this.fragmentLevel60Pets.setPets(petsArrayList60,this);

        activeFragmentChange(0);
    }

    private void activeFragmentChange(Integer activeFragment) {
        this.activeFragment = activeFragment;
        switch(activeFragment){
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, this.fragmentEveryPets).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, this.fragmentLevel1Pets).commit();
                break;
            case 2:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, this.fragmentLevel60Pets).commit();
                break;
        }
    }
    private PetsFragment getActiveFragmentChange(Integer activeFragment){
        switch (activeFragment){
            case 0: return fragmentEveryPets;
            case 1: return fragmentLevel1Pets;
            case 2: return fragmentLevel60Pets;
            default: return null;
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.nav_pets:
                    activeFragmentChange(0);
                    break;
                case R.id.nav_pets1:
                    activeFragmentChange(1);
                    break;
                case R.id.nav_pets60:
                    activeFragmentChange(2);
                    break;
            }
            return true;
        }
    };

    public void goDetail(Pets pets) {
        Intent intent = new Intent(this,PetActivity.class);
        intent.putExtra("name",pets.getName());
        intent.putExtra("description",pets.getDescription());
        intent.putExtra("max_stat",pets.getMaxStats());
        intent.putExtra("image",pets.getImgUrl());
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.example_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                getActiveFragmentChange(activeFragment).setFilter(newText);
                return false;
            }
        });
        return true;
    }
}
