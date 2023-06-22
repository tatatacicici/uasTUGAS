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
        if (asal == null) {
            System.out.println("Kota Tidak Valid");
            return;
        }
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

        while (node != null && node.infoKota.equals(namaKotaDelete)) {
            prevKota = node;
            node = node.nextKota;
        }
        if (node == null) {
            System.out.println("Kota " + namaKotaDelete + " tidak ditemukan");
        }

        Kota kotaSementara = firstKota;
        while (kotaSementara != null) {
            Jalur jalurSementara = kotaSementara.jalur;
            Jalur prevJalur = null;

            while (jalurSementara != null) {
                if (jalurSementara.simpul == node) {
                    if (prevJalur == null) {
                        kotaSementara.jalur = jalurSementara.nextJalur;
                    } else {
                        prevJalur.nextJalur = jalurSementara.nextJalur;
                    }
                } else {
                    prevJalur = jalurSementara;
                }
                jalurSementara = jalurSementara.nextJalur;
            }
            kotaSementara = kotaSementara.nextKota;
        }
        if (prevKota == null) {
            firstKota = node.nextKota;
        } else {
            prevKota.nextKota = node.nextKota;
        }
        System.out.println("Kota " + namaKotaDelete + " berhasil dihapus");
    }

    public Kota cariKota(String namaKotadicari) {
        Kota hasil = null;
        Kota node = firstKota;
        boolean ketemu = false;
        while ((node != null) && (ketemu == false)) {
            if (node.infoKota.equals(namaKotadicari)) {
                hasil = node;
                ketemu = true;
            } else {
                node = node.nextKota;
            }

        }
        return hasil;
    }

    public void hapusJalur(String namaJalurDelete) {
        Kota node = firstKota;
        boolean jalurDihapus = false;
        while (node != null) {
            Jalur jalur = node.jalur;
            Jalur prevJalur = null;

            while (jalur != null) {
                if (jalur.simpul.infoKota.equals(namaJalurDelete)) {
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
    public int hitungKota(){
        Kota node = firstKota;
        jumlahKota = 0;
        if(node != null){
            while(node != null){
                jumlahKota =  jumlahKota + 1;
                node = node.nextKota;
            }
        }
        return jumlahKota;
    }
    public void cetakJalur() {
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
                    jalurKota += jlr.simpul.infoKota + ", ";
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
    public void cetakKota() {
        Kota node = firstKota;
        if (node != null) {
            System.out.println("+----------------------------------------------------+");
            System.out.printf("| %-20s|\n", "Kota");
            System.out.println("+----------------------------------------------------+");
            while (node != null) {
                jumlahKota++;
                String infoKota = node.infoKota;
                String jalurKota = "";

                Jalur jlr = node.jalur;
                while (jlr != null) {
                    jalurKota += jlr.simpul.infoKota + ", ";
                    jlr = jlr.nextJalur;
                }

                System.out.printf("| %-20s|\n", infoKota);

                node = node.nextKota;
            }
            System.out.println("+----------------------------------------------------+");
        } else {
            System.out.println("Graph kosong");
        }
    }
    public Jalur cariJalur(Kota asal, Kota tujuan) {
        Kota node = asal;
        while (node != null) {
            Jalur jlr = node.jalur;
            while (jlr != null) {
                if (jlr.simpul.equals(tujuan)) {
                    return jlr;
                }
                jlr = jlr.nextJalur;
            }
            node = node.nextKota;
        }
        return null; // Jalur tidak ditemukan
    }

    public boolean cekJalur(Kota asal, Kota tujuan){
        Jalur jlr = asal.jalur;
        boolean ada = false;

        while(jlr != null){
            if(jlr.simpul.infoKota.equals(tujuan.infoKota)) {
                ada = true;
            }
            if(tujuan.infoKota == null){
                return false;
            }
            jlr = jlr.nextJalur;
        }
        return ada;
    }
//    public void tampilJalur(Kota asal, Kota tujuan){
//
//        Jalur jlr = asal.jalur;
//        String ada = "";
//        String infokota = node.InfoKo
//        if(tujuan.infoKota == null){
//            System.out.println("Jalur Tidak Ada");
//        }
//        while(jlr != null){
//            if(jlr.simpul.infoKota.equals(tujuan.infoKota))
//            {
//                System.out.println("+----------------------------------------------------+");
//                System.out.printf("| %-20s | %-27s |\n", "Kota", "Jalur");
//                System.out.println("+----------------------------------------------------+");
//                System.out.printf("| %-20s | %-27s |\n", infoKota, jalurKota);
//
//            }
//
//            jlr = jlr.nextJalur;
//        }
//    }
//    public Jalur cariJalur(Jalur asal, Jalur tujuan){
//        return;
//    }
    public void tampilJalur(Kota asal, Kota tujuan){
        Kota node = asal;
        if (node != null) {
            System.out.println("+----------------------------------------------------+");
            System.out.printf("| %-20s | %-27s |\n", "Kota", "Jalur");
            System.out.println("+----------------------------------------------------+");
            while (node != null) {
                String infoKota = node.infoKota;
                String jalurKota = "";

                Jalur jlr = node.jalur;
                while (jlr != null) {
                    jalurKota += jlr.simpul.infoKota + ", ";
                    jlr = jlr.nextJalur;
                }

                if (!jalurKota.isEmpty()) {
                    jalurKota = jalurKota.substring(0, jalurKota.length() - 2); // Remove trailing comma and space
                }

                if (node.infoKota.equals(tujuan.infoKota)) {
                    System.out.printf("| %-20s | %-27s |\n", infoKota, jalurKota);
                }

                node = node.nextKota;
            }
            System.out.println("+----------------------------------------------------+");
        } else {
            System.out.println("Graph kosong");
        }
    }

    public int getNilaiJalur(String ori, String dest){
        int nilai = 0;
        Kota end = cariKota(dest);
        Kota begin = cariKota(ori);
        Jalur jlr = begin.jalur;
        if(jlr == null){
            return 0;
        }
        while(jlr != null){
            if(jlr.simpul.infoKota.equals(end.infoKota)){
                nilai = jlr.jarakKota;
            }
            jlr = jlr.nextJalur;
        }
        return nilai;
    }


}
