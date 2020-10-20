package com.example.motoapp.Provider;

import com.example.motoapp.Motor;

import java.util.ArrayList;
import java.util.List;

public class MotorProvider {
    private static List<Motor> motori = null;
    private static List<Motor> motoriByKategorija = null;
    private static List<String> kategorija = null;

    private static void init(){
        if(motori == null) {
            motori = new ArrayList<>();
            motori.add(new Motor(
                    0, 600, 2015, "Suzuki GSR 600", "98hp with 4 stroke and full akrapovic exaust", "Naked", "suzuki.jpg", 7500.00));
            motori.add(new Motor(
                    1, 1000, 2018, "Kawasaki Z1000", "120hp with 4 stroke and full leovince exaust", "Naked", "kawasaki.jpg", 12000.00));
            motori.add(new Motor(
                    2, 950, 2016, "Yamaha MT-09", "102hp with 2 stroke and full akrapoivic exaust", "Naked", "yamahamt09.jpg", 7800.00));
            motori.add(new Motor(
                    3, 1000, 2020, "BMW S1000RR", "132hp with 4 stroke and full akrapovic exaust", "SuperSport", "bmw.jpg", 20000.00));
        }
    }

    public static List<Motor> getAllMotori(){
        init();
        return motori;
    }

    public static List<String> getKategorije(){
        init();
        kategorija= new ArrayList<>();

        for (int i = 0; i < motori.size(); i++){
            if (!kategorija.contains(motori.get(i).getKategorija())){
                kategorija.add(motori.get(i).getKategorija());
            }
        }
        return kategorija;
    }

    public static List<Motor> getAllMotoriByKategorija(String kategorija) {
        init();

        motoriByKategorija = new ArrayList<>();

        for (int i = 0; i < motori.size(); i++) {
            if (getMotorById(i).getKategorija().equals(kategorija))
                motoriByKategorija.add(motori.get(i));
        }

        return motoriByKategorija;
    }

    public static Motor getMotorById(int id) {
        init();

        if (id >= 0 && id < motori.size()) {
            return motori.get(id);
        }
        return null;
    }
}

