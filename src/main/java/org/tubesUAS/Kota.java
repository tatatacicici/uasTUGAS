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
    
    public Kota(String info){
        this.infoKota= info;
        nextKota = null;
        jalur = null;
    }
    
    public Kota(String info, Kota next){
        this.infoKota = info;
        this.nextKota = next;
        jalur = null;
    }
    
    public Kota(String infoKota, Kota nextKota, Jalur jalur){
        this.infoKota = infoKota;
        this.nextKota= nextKota;
        this.jalur = jalur;
    }
}
