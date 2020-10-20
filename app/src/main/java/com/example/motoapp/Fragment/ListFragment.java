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
import android.widget.ListView;
import android.widget.Toast;

import com.example.motoapp.Motor;
import com.example.motoapp.Adapter.MotorAdapter;
import com.example.motoapp.Provider.MotorProvider;
import com.example.motoapp.R;

import java.util.ArrayList;
import java.util.List;


public class ListFragment extends Fragment {

    private ListView listView_Motor;
    private List<Motor> motori = new ArrayList<>();
    private String kategorija;
    private onMotorClickListener listener;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }
    //Implementiramo metodu onViewCreated

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView_Motor = view.findViewById(R.id.lvPodaci);

        if (kategorija == null) {
            setupList();
        } else {
            setupListByKategorija();
        }
    }

    private void setupList() {
        motori = MotorProvider.getAllMotori();

        MotorAdapter adapter = new MotorAdapter(motori, getActivity());
        listView_Motor.setAdapter(adapter);

        listView_Motor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.onMotorClicked(motori.get(position));
                }
            }
        });
    }

    private void setupListByKategorija() {
        motori = MotorProvider.getAllMotoriByKategorija(kategorija);

        MotorAdapter adapter = new MotorAdapter(motori, getActivity());
        listView_Motor.setAdapter(adapter);

        listView_Motor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.onMotorClicked(motori.get(position));
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onMotorClickListener) {
            listener = (onMotorClickListener) context;
        } else {
            Toast.makeText(getContext(), "Morate implementirati intefrace", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public interface onMotorClickListener {
        void onMotorClicked(Motor motor);
    }
}