package com.example.smelllike;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.onRecipeSelectedInterface {


    public static final String KEY_RECIPE_INDEX = "KEY_RECIPE_INDEX";
    public static final String  LIST_FRAGMENT = "list_fragment";
    public static final String  VIEW_PAGER_FRAGMENT = "view_pager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);

        if(savedFragment == null){
            ListFragment listFragment = new ListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder , listFragment , LIST_FRAGMENT);

            fragmentTransaction.commit();

        }



    }

    @Override
    public void onRecipeSelected(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, position);
        ViewPageFragment viewPageFragment = new ViewPageFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        viewPageFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.placeholder , viewPageFragment , VIEW_PAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


}