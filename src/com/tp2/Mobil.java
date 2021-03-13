package com.tp2;

public class Mobil {

    private String merk;
    private String plat;
    private String warna;
    private String jenis;

    public Mobil(String merk, String plat, String warna, String jenis){
        this.merk = merk;
        this.plat = plat;
        this.warna = warna;
        this.jenis = jenis;
    }

    public String getMerk(){
        return this.merk;
    }

    public String getPlat(){
        return this.plat;
    }

    public String getWarna(){
        return this.warna;
    }

    public String getJenis() {
        return this.jenis;
    }
}