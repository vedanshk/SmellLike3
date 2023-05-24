package com.example.smelllike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.RecyclerView;
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    Context context;
     ListFragment.onRecipeSelectedInterface listener;

    public ListAdapter(Context context, ListFragment.onRecipeSelectedInterface listener) {
        this.context = context;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item , parent , false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.itemText.setText(Recipes.names[position]);
        holder.itemImage.setImageDrawable(AppCompatResources.getDrawable(context , Recipes.resourceIds[position]));

    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    protected  class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView itemText;
        private final ImageView itemImage;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            itemText =  itemView.findViewById(R.id.itemText);
            itemImage = itemView.findViewById(R.id.itemImage);
            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            listener.onRecipeSelected(getAdapterPosition());


        }
    }
}
