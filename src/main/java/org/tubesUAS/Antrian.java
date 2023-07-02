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
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("| No. Antrian |       Nama       |");
        System.out.println("++++++++++++++++++++++++++++++++++");
        while (elemenSementara != null) {
            count++;
            System.out.printf("| %-11d | %-16s |\n", count, elemenSementara.nama);
            elemenSementara = elemenSementara.next;
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
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
            int hargatotal = 0;
            System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");
            System.out.println("|       Nama           |       Moda        |      Kota Asal       |     Kota Tujuan      |       Harga          |");
            System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");

            while (elemenSementara != null) {
                System.out.printf("| %-20s | %-17s | %-20s | %-20s | Rp.%-18s|\n", elemenSementara.nama, elemenSementara.moda, elemenSementara.asal, elemenSementara.tujuan, elemenSementara.harga);
                hargatotal += elemenSementara.harga;
                elemenSementara = elemenSementara.next;
            }

            System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");
            System.out.printf("| Total Belanja                                                                            : Rp.%-16s|\n", hargatotal);
            System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");

            }
        }
    }

