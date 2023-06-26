package org.tubesUAS;

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

    public void cariJalur(Graph stadt, String awal, String tujuan) {
        System.out.println("Jalur dari " + awal + " ke " + tujuan + " : " + stadt.cekJalur(stadt.cariKota(awal), stadt.cariKota(tujuan)));
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

    public void cetakGraph() {
        Kota node = firstKota;
        if (node != null) {
            System.out.println("+----------------------------------------------------+");
            System.out.printf("| %-20s | %-27s |\n", "Kota", "Jalur");
            System.out.println("+----------------------------------------------------+");
            while (node != null) {
                jumlahKota++;
                String infoKota = node.infoKota;
                String jalurKota = "";

                Jalur jlr = node.jalur;
                while (jlr != null) {
                    jalurKota += jlr.kota.infoKota + ", ";
                    jlr = jlr.nextJalur;
                }

                if (!jalurKota.isEmpty()) {
                    jalurKota = jalurKota.substring(0, jalurKota.length() - 2); // Remove trailing comma and space
                }

                System.out.printf("| %-20s | %-27s |\n", infoKota, jalurKota);

                node = node.nextKota;
            }
            System.out.println("+----------------------------------------------------+");
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
