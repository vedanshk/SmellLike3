package com.example.smelllike;

public class DirectionsFragment extends CheckBoxesFragment{
    @Override
    public String[] getContents(int position) {
        return Recipes.directions[position].split("`");
    }
}
