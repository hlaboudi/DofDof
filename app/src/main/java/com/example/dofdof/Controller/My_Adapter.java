package com.example.dofdof.Controller;

import android.content.Context;
import android.content.Intent;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
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
import com.example.dofdof.View.Main3Activity;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hlaboudi on 25/03/2019.
 */

public class My_Adapter extends RecyclerView.Adapter<My_Adapter.ViewHolder> implements Filterable {
    private List<Pets> values;
    private List<Pets> Valuescomplet;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            layout = itemView;
            txtHeader = (TextView) itemView.findViewById(R.id.firstLine);
            txtFooter = (TextView) itemView.findViewById(R.id.secondLine);
            image = itemView.findViewById(R.id.imageView);


        }

    }
    //  public void add(int position, String item) {
    //      values.add(position, item);
    //      notifyItemInserted(position);
    //   }

    //   public void remove(int position) {
    //     values.remove(position);
    //     notifyItemRemoved(position);
    //  }
    public My_Adapter(List<Pets> myDataset, Context c)
    {
        context = c;
        this.values = myDataset;
        Valuescomplet = new ArrayList<Pets>(myDataset);
    }


    @NonNull
    @Override

    public My_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {

        final Pets pet = values.get(i);

        final String name = pet.getName();

        final int id = pet.get_id();

        final String desc = pet.getDescription();

        final String maxstat = pet.getMaxStats();

        final String image = pet.getImgUrl();
        Glide.with(context).asBitmap().load(image).into(holder.image);

        holder.txtHeader.setText(name);

        holder.txtHeader.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(context, Main3Activity.class);
                intent.putExtra("pet_name",name);
                intent.putExtra("pet_desc",desc);
                intent.putExtra("pet_maxstat",maxstat);
                intent.putExtra("pet_image",image);
                context.startActivity(intent);
            }
        });

        holder.txtFooter.setText("numero : " + id);

    }

    @Override
    public int getItemCount() {

        return values.size();
    }

    @Override
    public Filter getFilter() {
        return Values;

    }
    private Filter Values = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Pets> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(Valuescomplet);           //erreur
                            }
                            else {
                                String filterPattern = constraint.toString().toLowerCase().trim();
                                for (Pets item : Valuescomplet){                //rerreur

                                    if (item.getName().toLowerCase().contains(filterPattern))           // verification
                                    {filteredList.add(item); // erreur
                                    }
                                }
            }
            FilterResults results = new FilterResults();
                            results.values = filteredList ; // pas notmral values la meme que lui

                            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
        values.clear();                       // pas reconnu
        values.addAll((List) results.values) ;    // pas reconnu et pas normal meme values*
            notifyDataSetChanged();
        }
    };
}