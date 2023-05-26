package com.example.smelllike;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridFragment extends Fragment {
    public interface  onRecipeSelectedInterface{
        void onRecipeSelected(int position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_grid , container , false);
        ListFragment.onRecipeSelectedInterface listener = (ListFragment.onRecipeSelectedInterface) getActivity();
        RecyclerView itemRecyclerView = view.findViewById(R.id.itemrRecyclerView);
        ListAdapter adapter = new ListAdapter(getContext() , listener);

        itemRecyclerView.setAdapter(adapter);

        itemRecyclerView.setLayoutManager(new GridLayoutManager(getActivity() , 2));

        return view;
    }
}
