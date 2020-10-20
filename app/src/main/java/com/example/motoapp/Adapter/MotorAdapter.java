package com.example.motoapp.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.motoapp.Motor;
import com.example.motoapp.R;

import java.util.List;

public class MotorAdapter extends BaseAdapter {

    private List<Motor> motori;
    private Activity activity;

    public MotorAdapter(List<Motor> motori, Activity activity) {
        this.motori = motori;
        this.activity = activity;
    }
    //Posle implementiranja metoda menjamo u motori.size()
    @Override
    public int getCount() {
        return motori.size();
    }
    //Posle implementiranja motode menjamo Object u Motor i return u motori.get(position)
    @Override
    public Motor getItem(int position) {
        return motori.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    //brisemo return=null; i dodajemo sledece
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
       if(view == null){
           //dodajemo u xml novi layout(listview_motori_naziv_kategorija)
           //koji ce imati recimo 2 textview-a radi prikaza naziva i kategorije
           view = activity.getLayoutInflater().inflate(R.layout.listview_motori_naziv_kategorija, null);
       }
        TextView tv = view.findViewById(R.id.tvNazivMotora);
        TextView tv1 = view.findViewById(R.id.tvKategorijaMotora);

        tv.setText(motori.get(position).getNaziv());
        tv1.setText(motori.get(position).getKategorija());

        return view;
    }
}
