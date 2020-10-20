package com.example.motoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.motoapp.Fragment.DetailsFragment;
import com.example.motoapp.Fragment.KategorijaFragment;
import com.example.motoapp.Fragment.ListFragment;
import com.example.motoapp.Fragment.PreferenceFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.onMotorClickListener, KategorijaFragment.onKategorijaClickListener{

    private List<String> drawerItems;
    private ListView drawerList;
    private DrawerLayout drawerLayout;

    private ActionBarDrawerToggle drawerToggle;

    private Toolbar toolbar;
    private AlertDialog dialog_about;
    private AlertDialog dialog_choose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fillData();
        setupToolbar();
        setupDrawer();
    }

    private void fillData() {
        drawerItems = new ArrayList<String>();
        drawerItems.add("Kategorije");
        drawerItems.add("Motori");
        drawerItems.add("Podesavanja");
        drawerItems.add("O aplikaciji");
    }

        private void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_toc_24);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();

        }
    }

    private void showSnackbar() {
        Snackbar snackbar;

        snackbar = Snackbar.make(findViewById(R.id.root), "Unos|Izmena|Brisanje", Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add) {
            showSnackbar();
            showDialogChoose(0);
        } else if (item.getItemId() == R.id.edit) {
            showSnackbar();
            showDialogChoose(1);
        } else if (item.getItemId() == R.id.delete) {
            showSnackbar();
            showDialogChoose(2);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setupDrawer() {
        drawerList = findViewById(R.id.leftDrawer);
        drawerLayout = findViewById(R.id.drawer_layout);

        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drawerItems));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String title = "";
                if (position == 0) {
                    title = "Kategorije";
                    showKategorijaFragment();
                } else if (position == 1) {
                    title = "Motori";
                    showMotorFragment();
                } else if (position == 2) {
                    title = "Podesavanja";
                    showPreferences();
                } else if (position == 3) {
                    title = "O aplikaciji";
                    showDialog();
                }
                setTitle(title);
                drawerLayout.closeDrawer(drawerList);
            }
        });
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerClosed(View drawerView) {
                getSupportActionBar().setTitle("");
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle("");
                super.onDrawerOpened(drawerView);
            }
        };

    }

    private void showKategorijaFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        KategorijaFragment fragment = new KategorijaFragment();
        transaction.replace(R.id.root, fragment);
        transaction.commit();
    }

    public void showMotorFragment() {
        ListFragment listfragment = new ListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.root, listfragment).commit();
    }

    public void showMotorByKategorijaFragment(String kategorija) {
        ListFragment listfragment = new ListFragment();
        listfragment.setKategorija(kategorija);
        getSupportFragmentManager().beginTransaction().replace(R.id.root, listfragment).commit();
    }
    private void showDetails(Motor motor) {
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setMotor(motor);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.root, detailsFragment)
                .addToBackStack(null)
                .commit();
    }

    private void showPreferences() {
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        PreferenceFragment preferenceFragment = new PreferenceFragment();
        fragment.replace(R.id.root, preferenceFragment);
        fragment.commit();
    }

    private void showDialog() {
        if (dialog_about == null)
            dialog_about = new DialogAbout(this).prepareDialog();
        else if (dialog_about.isShowing())
            dialog_about.dismiss();
        dialog_about.show();
    }

    private void showDialogChoose(int id) {
        if (dialog_choose == null) {
            dialog_choose = new DialogChoose(this).prepareDialog(id);
        } else if
            (dialog_choose.isShowing()){
            dialog_choose.dismiss();
            dialog_choose.show();
        }
    }

    @Override
    public void onMotorClicked(Motor motor) {
        showDetails(motor);
    }
    @Override
    public void onKategorijaClicked(String kategorija) {
        showMotorByKategorijaFragment(kategorija);
    }
}
