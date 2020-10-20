package com.example.motoapp.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.motoapp.Motor;
import com.example.motoapp.R;

import java.io.InputStream;

public class DetailsFragment extends Fragment {

    private TextView tvNaziv, tvOpis, tvKategorija, tvKubikaza, tvCena;
    private ImageView ivSlika;
    private Motor motor;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvNaziv = view.findViewById(R.id.tvNaziv);
        tvOpis = view.findViewById(R.id.tvOpis);
        tvKategorija = view.findViewById(R.id.tvKategorija);
        tvKubikaza = view.findViewById(R.id.tvKubikaza);
        tvCena = view.findViewById(R.id.tvCena);
        ivSlika = view.findViewById(R.id.imageViewSlika);

        //Moramo implementirati setupView metodu radi prikaza
        setupViews();

    }
    public void setMotor(Motor motor){
        this.motor = motor;
    }
        //Setujemo preko ove metode da bi povukli podatke iz Motor klase
        //jer nam se tamo nalaze geteri
    public void setupViews() {
        tvNaziv.setText(motor.getNaziv());
        tvOpis.setText(motor.getOpis());
        tvKategorija.setText(motor.getKategorija());
        tvKubikaza.setText(motor.getKubikaza() + " cc");
        tvCena.setText(motor.getCena() + " eura");

        //Uradicemo setovanje slike preko try/catch bloka da nam baci exception
        //u slucaju da nije ok

        try {
            InputStream is = getContext().getAssets().open(motor.getSlikaUrl());
            Drawable dr = Drawable.createFromStream(is, null);
            ivSlika.setImageDrawable(dr);
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}