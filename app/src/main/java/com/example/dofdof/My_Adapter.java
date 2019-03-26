package com.example.dofdof;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hlaboudi on 25/03/2019.
 */

public class My_Adapter extends RecyclerView.Adapter<My_Adapter.ViewHolder> {
    private List<Pets> values;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;
        public RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            layout = itemView;
            txtHeader = (TextView) itemView.findViewById(R.id.firstLine);
            txtFooter = (TextView) itemView.findViewById(R.id.secondLine);


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

    public My_Adapter(List<Pets> myDataset)
    {
        values = myDataset;
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
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                values.remove(i); //ajout de values
            }
        });

        holder.txtFooter.setText("numero : " + id);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {// à changer
            @Override
            public void onClick(View v) {
                Toast.makeText(context,pet.getDescription(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return values.size();
    }


}