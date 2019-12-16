package com.example.dofdof.Controller;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dofdof.Model.Pets;
import com.example.dofdof.R;
import com.example.dofdof.View.MainActivity;
import com.example.dofdof.View.PetActivity;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hlaboudi on 25/03/2019.
 */
public class My_Adapter extends RecyclerView.Adapter<My_Adapter.ViewHolder> implements Filterable{
    private ArrayList<Pets> pets,petsRecherche;
    private MainActivity mainActivity;
    private Filter filter;
    public My_Adapter(final ArrayList<Pets> pets, MainActivity mainActivity) {
        this.pets = pets;
        this.petsRecherche = new ArrayList<>(pets);
        this.mainActivity = mainActivity;
        this.filter = new Filter() {
            protected FilterResults performFiltering(CharSequence constraint) {
                ArrayList<Pets> filtred = new ArrayList<>();
                if(constraint == null || constraint.length() == 0)
                    filtred.addAll(pets);
                else {
                    String filterPattern = constraint.toString().toLowerCase().trim();
                    for(Pets petsFor:pets){
                        if(petsFor.getName().toLowerCase().contains(filterPattern))
                            filtred.add(petsFor);
                    }
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filtred;
                return filterResults;
            }
            protected void publishResults(CharSequence constraint, FilterResults results) {
                petsRecherche.clear();
                petsRecherche.addAll((ArrayList)results.values);
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public Filter getFilter() {
        return this.filter;
    }
    // Class and methods for element's
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,description;
        private ImageView logo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.description = itemView.findViewById(R.id.secondLine);
            this.name = itemView.findViewById(R.id.firstLine);
            this.logo = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    mainActivity.goDetail(pets.get(getAdapterPosition()));
                }
            });
        }
        private void display(Pets pets){
            this.name.setText(pets.getName());
            this.description.setText("ID:"+pets.get_id());
            Glide.with(mainActivity).asBitmap().load(pets.getImgUrl()).into(this.logo);
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false));
    }
    public void onBindViewHolder(ViewHolder holder,int position) {
        holder.display(this.petsRecherche.get(position));
    }
    public int getItemCount() {
        return this.petsRecherche.size();
    }
}