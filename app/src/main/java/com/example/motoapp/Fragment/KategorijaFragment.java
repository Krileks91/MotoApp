package com.example.motoapp.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.motoapp.Provider.MotorProvider;
import com.example.motoapp.R;

import java.util.ArrayList;
import java.util.List;

public class KategorijaFragment extends Fragment {

    private ListView listView_Motori;
    public static List<String> kategorija = new ArrayList<>();
    private onKategorijaClickListener listener;

    public KategorijaFragment() {
        // Required empty public constructor
    }
    //Inflate funkcija postavlja fragment_kategorije layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kategorija, container, false);
    }
    //Implementiramo onViewCreated metodu

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView_Motori = view.findViewById(R.id.listView_Kategorija);


        setupList();
    }
    //Moracemo da napravimo metodu setupListKategorije, u kojem cemo definisati adapter
    //koji prosledjuje preuzete podatke pa da pozovemo u onViewCreated

    private void setupList() {

        kategorija = MotorProvider.getKategorije();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, kategorija);
        listView_Motori.setAdapter(adapter);

        listView_Motori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onKategorijaClicked(kategorija.get(position));
            }
        });
    }
    //5
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ListFragment.onMotorClickListener) {
            listener = (onKategorijaClickListener) context;
        } else {
            Toast.makeText(getContext(), "Morate implementirati intefrace", Toast.LENGTH_SHORT).show();

        }
    }
    //6
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    //4
    public interface onKategorijaClickListener {
        void onKategorijaClicked(String kategorija);
    }
}