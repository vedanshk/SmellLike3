package com.example.smelllike;

import static com.example.smelllike.MainActivity.KEY_RECIPE_INDEX;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.Objects;

public class ViewPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager , container , false);
         Bundle bundle = getArguments();
         if(bundle != null){
             int position = bundle.getInt(KEY_RECIPE_INDEX);
             if (position != -1){
                getActivity().setTitle(Recipes.names[position]);
             }
         }

        ViewPager viewPager = view.findViewById(R.id.viewPager);
         viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
             @NonNull
             @Override
             public Fragment getItem(int position) {
                 return null;
             }

             @Override
             public int getCount() {
                 return 2;
             }
         });
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
