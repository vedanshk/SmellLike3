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
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

public class ViewPageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager , container , false);
         Bundle bundle = getArguments();
         Bundle bundle1 = new Bundle();
         if(bundle != null){
             int position = bundle.getInt(KEY_RECIPE_INDEX);

                getActivity().setTitle(Recipes.names[position]);
                bundle1.putInt(KEY_RECIPE_INDEX , position );
         }

         IngredientFragment ingredientFragment = new IngredientFragment();
         DirectionFragment directionFragment  =  new DirectionFragment();

         ingredientFragment.setArguments(bundle1);
         directionFragment.setArguments(bundle1);

        ViewPager2 viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(new FragmentStateAdapter(requireActivity()) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                return position == 0 ? ingredientFragment : directionFragment;
            }

            @Override
            public int getItemCount() {
                return 2;
            }
        });

        String[] tabNames = {"Ingredient" , "Direction"};

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout , viewPager , (tab, position) -> tab.setText(tabNames[position])
        ).attach();
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
