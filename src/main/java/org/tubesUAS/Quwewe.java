package org.tubesUAS;

public class Quwewe {
    String nama;
    String moda;
    String asal;
    String tujuan;
    int harga;

    Quwewe next;
    Quwewe prev;

    Quwewe(String nama) {
        this.nama = nama;
        this.next = null;
        this.prev = null;
    }

    Quwewe(String nama, String moda, String asal, String tujuan, int harga) {
        this.nama = nama;
        this.moda = moda;
        this.asal = asal;
        this.tujuan = tujuan;
        this.harga = harga;
    }
}
