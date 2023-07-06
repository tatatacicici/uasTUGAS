/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tubesUAS;

/**
 *
 * @author Acer
 */
public class Graph {
    int jumlahKota;
    Kota firstKota;
    Jalur firstJalur;

    public Graph() {
        jumlahKota = 0;
        firstKota = null;
        firstJalur = null;
    }

    public boolean isEmpty() {
        return firstKota == null;
    }

    public void tambahKota(String infoKota) {
        Kota node = new Kota(infoKota, null, null);
        if (firstKota == null) {
            firstKota = node;
        } else {
            Kota last = firstKota;
            while (last.nextKota != null) {
                last = last.nextKota;
            }
            last.nextKota = node;
        }
    }

    public void tambahJalur(Kota tujuan, int jarakKota, Kota asal) {
        Jalur edge = new Jalur(jarakKota, null, tujuan);
        if (asal.jalur == null) {
            asal.jalur = edge;
        } else {
            Jalur last = asal.jalur;
            while (last.nextJalur != null) {
                last = last.nextJalur;
            }
            last.nextJalur = edge;
        }
    }

    public void hapusKota(String namaKotaDelete) {
        Kota node = firstKota;
        Kota prevKota = null;

        // Cari Kota yang akan dihapus
        while (node != null && !node.infoKota.equals(namaKotaDelete)) {
            prevKota = node;
            node = node.nextKota;
        }

        if (node == null) {
            System.out.println("Kota " + namaKotaDelete + " tidak ditemukan");
            return;
        }

        // Hapus semua jalur terhubung dengan Kota yang dihapus
        Kota currKota = firstKota;
        while (currKota != null) {
            Jalur currJalur = currKota.jalur;
            Jalur prevJalur = null;

            while (currJalur != null) {
                if (currJalur.kota == node) {
                    // Hapus jalur terhubung dengan Kota yang dihapus
                    if (prevJalur == null) {
                        currKota.jalur = currJalur.nextJalur;
                    } else {
                        prevJalur.nextJalur = currJalur.nextJalur;
                    }
                } else {
                    prevJalur = currJalur;
                }

                currJalur = currJalur.nextJalur;
            }

            currKota = currKota.nextKota;
        }

        // Hapus Kota
        if (prevKota == null) {
            firstKota = node.nextKota;
        } else {
            prevKota.nextKota = node.nextKota;
        }

        System.out.println("Kota " + namaKotaDelete + " berhasil dihapus");
    }

    public Kota cariKota(String namaKotaSearch) {
        Kota hasil = null;
        Kota node = firstKota;
        boolean ketemu = false;
        while (node != null && !ketemu) {
            if (node.infoKota.equals(namaKotaSearch)) {
                hasil = node;
                ketemu = true;
            } else {
                node = node.nextKota;
            }
        }
        return hasil;
    }

//    public void cariJalur(Graph stadt, String awal, String tujuan) {
//        System.out.println("Jalur dari " + awal + " ke " + tujuan + " : " + stadt.cekJalur(stadt.cariKota(awal), stadt.cariKota(tujuan)));
//    }
    public void cariJalur(Graph stadt, String awal, String tujuan) {
        Kota awalKota = stadt.cariKota(awal);
        Kota tujuanKota = stadt.cariKota(tujuan);

        if (stadt.cekJalur(awalKota, tujuanKota)) {
            System.out.println("Jalur dari " + awal + " ke " + tujuan + " : ada");
        }
    }

    public void hapusJalur(String namaJalurDelete) {
        Kota node = firstKota;
        boolean jalurDihapus = false;

        while (node != null) {
            Jalur jalur = node.jalur;
            Jalur prevJalur = null;

            while (jalur != null) {
                if (jalur.kota.infoKota.equals(namaJalurDelete)) {
                    if (prevJalur == null) {
                        node.jalur = jalur.nextJalur;
                    } else {
                        prevJalur.nextJalur = jalur.nextJalur;
                    }

                    jalurDihapus = true;
                    break;
                }

                prevJalur = jalur;
                jalur = jalur.nextJalur;
            }

            node = node.nextKota;
        }

        if (jalurDihapus) {
            System.out.println("Jalur " + namaJalurDelete + " berhasil dihapus.");
        } else {
            System.out.println("Jalur " + namaJalurDelete + " tidak ditemukan.");
        }
    }

    public int hitungKota() {
        Kota node = firstKota;
        jumlahKota = 0;
        if (node != null) {
            while (node != null) {
                jumlahKota = jumlahKota + 1;
                node = node.nextKota;
            }
        }
        return jumlahKota;
    }

    public void cetakStadt() {
        Kota node = firstKota;
        if (node != null) {
            System.out.println("+-------------------------------+");
            System.out.printf("| %-12s | %-14s |\n", "Kota", "Jalur");
            System.out.println("+-------------------------------+");
            while (node != null) {
                String infoKota = node.infoKota;
                String jalurKota = "";

                Jalur jlr = node.jalur;
                while (jlr != null) {
                    jalurKota += jlr.kota.infoKota + "\n";
                    jlr = jlr.nextJalur;
                }

                if (!jalurKota.isEmpty()) {
                    jalurKota = jalurKota.substring(0, jalurKota.length() - 1); // Remove trailing newline
                }

                System.out.printf("| %-12s | %-14s |\n", infoKota, ""); // Cetak kosong untuk kolom Kota

                String[] jalurArray = jalurKota.split("\n"); // Pisahkan jalur-jalur berdasarkan newline
                for (String jalur : jalurArray) {
                    System.out.printf("| %-12s | %-14s |\n", "", jalur); // Cetak jalur per baris
                }

                node = node.nextKota;
            }
            System.out.println("+-------------------------------+");
        } else {
            System.out.println("Graph kosong");
        }
    }
    public void cetakRute() {
        Kota node = firstKota;
        if (node != null) {
            System.out.println("+--------------------------------------------+");
            System.out.printf("| %-12s | %-14s | %-10s |\n", "Kota", "Jalur", "Jarak");
            System.out.println("+--------------------------------------------+");
            while (node != null) {
                String infoKota = node.infoKota;
                String jalurKota = "";
                String jarakKota = "";

                Jalur jlr = node.jalur;
                while (jlr != null) {
                    jalurKota += jlr.kota.infoKota + "\n";
                    jarakKota += jlr.jarakKota + "\n";
                    jlr = jlr.nextJalur;
                }

                if (!jalurKota.isEmpty()) {
                    jalurKota = jalurKota.substring(0, jalurKota.length() - 1); // Remove trailing newline
                    jarakKota = jarakKota.substring(0, jarakKota.length() - 1); // Remove trailing newline
                }

                System.out.printf("| %-12s | %-14s | %-10s |\n", infoKota, "", ""); // Print empty values for Kota and Jalur

                String[] jalurArray = jalurKota.split("\n"); // Separate jalur-jalur based on newline
                String[] jarakArray = jarakKota.split("\n"); // Separate jarak-jarak based on newline
                int maxLength = Math.max(jalurArray.length, jarakArray.length);

                for (int i = 0; i < maxLength; i++) {
                    String jalur = (i < jalurArray.length) ? jalurArray[i] : "";
                    String jarak = (i < jarakArray.length) ? jarakArray[i] : "";
                    System.out.printf("| %-12s | %-14s | %-10s |\n", "", jalur, jarak); // Print each jalur and jarak per row
                }

                node = node.nextKota;
            }
            System.out.println("+--------------------------------------------+");
        } else {
            System.out.println("Graph kosong");
        }
    }

    public boolean cekJalur(Kota asal, Kota tujuan) {
        Jalur jlr = asal.jalur;
        boolean ada = false;
        while (jlr != null) {
            if (jlr.kota.infoKota.equals(tujuan.infoKota)) {
                ada = true;
                break; // Keluar dari loop saat jalur ditemukan
            }
            jlr = jlr.nextJalur;
        }
        return ada;
    }

    public int getNilaiJalur(String ori, String dest) {
        int nilai = 0;
        Kota end = cariKota(dest);
        Kota begin = cariKota(ori);
        Jalur jlr = begin.jalur;
        while (jlr != null) {
            if (jlr.kota.infoKota.equals(end.infoKota)) {
                nilai = jlr.jarakKota;
            }
            jlr = jlr.nextJalur;
        }
        return nilai;
    }
}

