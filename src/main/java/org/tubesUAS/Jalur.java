package org.tubesUAS;

public class Jalur {
    int jarakKota;
    Jalur nextJalur;
    Kota simpul;

    public Jalur() {
        jarakKota = 0;
        nextJalur = null;
        simpul = null;
    }
    public Jalur(int beban){
        this.jarakKota = beban;
        nextJalur = null;
        simpul = null;
    }

    public Jalur (int beban, Jalur next) {
        this.jarakKota = beban;
        this.nextJalur = next;
        simpul =  null;
    }
    public Jalur(int beban, Jalur next, Kota simpul){
        this.jarakKota = beban;
        this.nextJalur = next;
        this.simpul = simpul;
    }
}
