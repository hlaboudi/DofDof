package com.example.dofdof.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dofdof.Controller.My_Adapter;
import com.example.dofdof.Model.Pets;
import com.example.dofdof.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class PetsFragment extends Fragment {
    private ArrayList<Pets> pets;
    private RecyclerView recyclerView;
    private My_Adapter my_adapter;
    private MainActivity mainActivity;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__pets, container, false);
        this.recyclerView = view.findViewById(R.id.my_recycler_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), RecyclerView.VERTICAL, false));
        this.my_adapter = new My_Adapter(pets,mainActivity);
        this.recyclerView.setAdapter(this.my_adapter);
        return view;
    }
    public void setPets(ArrayList<Pets> pets,MainActivity mainActivity){
        this.pets = pets;
        this.mainActivity = mainActivity;
    }
    public void setFilter(String text){
        this.my_adapter.getFilter().filter(text);
    }
}
