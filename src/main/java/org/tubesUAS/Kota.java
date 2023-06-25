package org.tubesUAS;
public class Kota {
    String infoKota;
    Kota nextKota;
    Jalur jalur;
    public Kota(){
        infoKota = null;
        nextKota = null;
        jalur = null;
    }
    public  Kota(String kota){
        this.infoKota = kota;
        nextKota = null;
        jalur = null;
    }
    public Kota(String kota, Kota next){
        this.infoKota = kota;
        this.nextKota = next;
        jalur = null;
    }
    public Kota(String infoKota, Kota nextKota, Jalur jalur){
        this.infoKota = infoKota;
        this.nextKota = nextKota;
        this.jalur = jalur;
    }
}
