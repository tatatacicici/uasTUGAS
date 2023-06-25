package org.tubesUAS;

public class Antrian {
    Quwewe first;
    Quwewe last;

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

    public Quwewe pindah() {
        if (first == null) {
            return null;
        } else {
            Quwewe temp = first;
            first = first.next;
            if (first != null) {
                first.prev = null;
            } else {
                last = null;
            }
            return temp;
        }
    }

    public void beliTiket(Antrian antrian, Antrian antrianTerjual, String nama, String jenis) {
        if (antrian.isEmpty()) {
            System.out.println("Antrian kosong");
        } else {
            antrian.deQueue();
            // String tiket = "Tiket berhasil dibeli: " + jenis + ", Nama: " + nama;
            antrianTerjual.enQueue(antrian.pindah());
            // return tiket;
        }
    }

    void lihatTiketTerjual() {
        if (tiketTerjual.isEmpty()) {
            System.out.println("Belum ada tiket terjual");
        } else {
            System.out.println("Daftar Tiket Terjual:");
            for (String tiket : tiketTerjual) {
                System.out.println(tiket);
            }
        }
    }
}
