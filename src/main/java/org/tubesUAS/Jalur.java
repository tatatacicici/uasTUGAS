package org.tubesUAS;

public class Jalur {
    int jarakKota;
    Jalur nextJalur;
    Kota kota;

    public Jalur() {
        jarakKota = 0;
        nextJalur = null;
        kota = null;
    }

    public Jalur(int beban) {
        this.jarakKota = beban;
        nextJalur = null;
        kota = null;
    }

    public Jalur(int beban, Jalur next) {
        this.jarakKota = beban;
        this.nextJalur = next;
        kota = null;
    }

    public Jalur(int beban, Jalur next, Kota kota) {
        this.jarakKota = beban;
        this.nextJalur = next;
        this.kota = kota;
    }
}