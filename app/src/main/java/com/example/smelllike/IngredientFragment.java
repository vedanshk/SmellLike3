package com.example.smelllike;

import static com.example.smelllike.MainActivity.KEY_RECIPE_INDEX;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class IngredientFragment extends Fragment {

    private static final String KEY_CHECKED_BOXES =  "key_checked_boxes";
    private CheckBox[] checkBoxes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_ingredient , container , false);
        Bundle bundle = getArguments();
        String[] ingredients ;
        LinearLayout linearLayout = view.findViewById(R.id.ingredientLayout);
        assert bundle != null;
        int position = bundle.getInt(KEY_RECIPE_INDEX);
        ingredients =  Recipes.ingredients[position].split("`");
        checkBoxes =  new CheckBox[ingredients.length];
        if(savedInstanceState != null){
            boolean[] stateOfCheckedBox =  savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
            setUpCheckBoxes(ingredients , linearLayout , stateOfCheckedBox);
        }else{
            setUpCheckBoxes(ingredients , linearLayout , null);
        }



        return view;
    }


    private void setUpCheckBoxes(String[] ingredients , LinearLayout container, boolean[] stateOfCheckedBox){
        int i = 0;
        for (String ingredient:
                ingredients) {

            CheckBox checkBox = new CheckBox(getActivity());

            checkBox.setPadding(8 , 16 , 8 , 16);
            checkBox.setText(ingredient);
            checkBox.setTextSize(20f);
            if(stateOfCheckedBox != null){
                checkBox.setChecked(stateOfCheckedBox[i]);
            }
            checkBoxes[i] = checkBox;
            container.addView(checkBox);
            i++;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        boolean[] stateOfCheckBoxes = new boolean[checkBoxes.length];
        int i = 0;
        for(i = 0; i < checkBoxes.length; ++i){
            stateOfCheckBoxes[i] = checkBoxes[i].isChecked();
        }
        outState.putBooleanArray(KEY_CHECKED_BOXES , stateOfCheckBoxes);
        super.onSaveInstanceState(outState);
    }
}
