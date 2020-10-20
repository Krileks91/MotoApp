package com.example.motoapp;

public class Motor {
    private int id, kubikaza, godiste;
    private String naziv, opis, kategorija, slikaUrl;
    private double cena;


    public Motor() {
        id=0;
        kubikaza=0;
        naziv="";
        opis= "";
        kategorija="";
        slikaUrl = "";
        cena = 0.0;
    }

    public Motor(int id, int kubikaza, int godiste, String naziv, String opis, String kategorija, String slikaUrl, double cena) {
        this.id = id;
        this.kubikaza = kubikaza;
        this.godiste = godiste;
        this.naziv = naziv;
        this.opis = opis;
        this.kategorija = kategorija;
        this.slikaUrl = slikaUrl;
        this.cena = cena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKubikaza() {
        return kubikaza;
    }

    public void setKubikaza(int kubikaza) {
        this.kubikaza = kubikaza;
    }

    public int getGodiste() {
        return godiste;
    }

    public void setGodiste(int godiste) {
        this.godiste = godiste;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getSlikaUrl() {
        return slikaUrl;
    }

    public void setSlikaUrl(String slikaUrl) {
        this.slikaUrl = slikaUrl;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", kubikaza=" + kubikaza +
                ", godiste=" + godiste +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", kategorija='" + kategorija + '\'' +
                ", slikaUrl='" + slikaUrl + '\'' +
                ", cena=" + cena +
                '}';
    }
}
