package com.example.smelllike;

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int position) {
        return Recipes.ingredients[position].split("`");
    }
}
