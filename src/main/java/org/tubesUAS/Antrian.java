package org.tubesUAS;

public class Antrian {
    Quwewe first;

    Antrian() {
        first = null;
    }

    void enQueue(String nama) {
        Quwewe antrian_baru = new Quwewe(nama);
        if (first == null) {
            first = antrian_baru;
        } else {
            Quwewe elemenSementara = first;
            while (elemenSementara.next != null) {
                elemenSementara = elemenSementara.next;
            }
            elemenSementara.next = antrian_baru;

        }
    }

    void enQueue(String nama, String moda, String asal, String tujuan, int harga) {
        Quwewe antrian_baru = new Quwewe(nama, moda, asal, tujuan, harga);
        if (first == null) {
            first = antrian_baru;
        } else {
            Quwewe elemenSementara = first;
            while (elemenSementara.next != null) {
                elemenSementara = elemenSementara.next;
            }
            elemenSementara.next = antrian_baru;

        }
    }

    void deQueue() {
        if (first == null) {
            System.out.println("Antrian Kosong");
        } else {
            first = first.next;
        }
    }

    boolean isEmpty() {
        return first == null;
    }

    void print() {
        Quwewe elemenSementara = first;
        int count = 0;
        if (elemenSementara == null) {
            System.out.println("Antrian Kosong");
        } else {
            while (elemenSementara != null) {
                count++;
                System.out.println("++++++++++++++++++++++");
                System.out.println("Nama: " + (elemenSementara.nama));
                System.out.println("No.antrian: " + count);
                System.out.println("+++++++++++++++++++++++");
                elemenSementara = elemenSementara.next;
            }
        }

    }

    public void beliTiket(Antrian antrian, String moda, String asal, String tujuan, int harga) {
        if (first == null) {
            System.out.println("Antrian kosong");
        } else {
            String nama = first.nama;
            antrian.enQueue(nama, moda, asal, tujuan, harga);
            deQueue();
        }
    }

    void tiketTerjual() {
        Quwewe elemenSementara = first;
        if (elemenSementara == null) {
            System.out.println("Antrian Kosong");
        } else {
            while (elemenSementara != null) {
                System.out.println("++++++++++++++++++++++");
                System.out.println("Nama: " + (elemenSementara.nama));
                System.out.println("Moda: " + (elemenSementara.moda));
                System.out.println("Kota Asal: " + (elemenSementara.asal));
                System.out.println("Kota Tujuan: " + (elemenSementara.tujuan));
                System.out.println("Harga: " + (elemenSementara.harga));
                System.out.println("+++++++++++++++++++++++");
                elemenSementara = elemenSementara.next;
            }
        }

    }
}
