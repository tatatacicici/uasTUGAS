package org.tubesUAS;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Graph stadt = new Graph();

        Antrian bus = new Antrian();
        Antrian kereta = new Antrian();
        Antrian pesawat = new Antrian();

        Antrian busTerjual = new Antrian();
        Antrian keretaTerjual = new Antrian();
        Antrian pesawatTerjual = new Antrian();
        //Menambah 5 Antrian Bus
        bus.enQueue("Arkan");
        bus.enQueue("Bagas");
        bus.enQueue("Cika");
        bus.enQueue("Dika");
        bus.enQueue("Ella");
        //Menambah 5 Antrian Kereta
        kereta.enQueue("Alma");
        kereta.enQueue("Budi");
        kereta.enQueue("Coki");
        kereta.enQueue("Della");
        kereta.enQueue("Evan");
        //Menambah 5 Antrian Pesawat
        pesawat.enQueue("Arya");
        pesawat.enQueue("Bayu");
        pesawat.enQueue("Carla");
        pesawat.enQueue("Doni");
        pesawat.enQueue("Hussain");
        //Menambahkan 5 Kota Awal
        stadt.tambahKota("Hamburg");
        stadt.tambahKota("Frankfurt");
        stadt.tambahKota("Stuttgart");
        stadt.tambahKota("Munchen");
        stadt.tambahKota("Berlin");
        //Menambahkan Jalur Antar Kota
        addEdges(stadt, "Hamburg", "Frankfurt", 493);
        addEdges(stadt, "Hamburg", "Stuttgart", 656);
        addEdges(stadt, "Hamburg", "Munchen", 791);
        addEdges(stadt, "Hamburg", "Berlin", 289);
        addEdges(stadt, "Frankfurt", "Stuttgart", 205);
        addEdges(stadt, "Frankfurt", "Munchen", 393);
        addEdges(stadt, "Frankfurt", "Berlin", 556);
        addEdges(stadt, "Frankfurt", "Hamburg",493);
        addEdges(stadt, "Stuttgart", "Munchen", 232);
        addEdges(stadt, "Stuttgart", "Berlin", 638);
        addEdges(stadt, "Stuttgart", "Hamburg", 656);
        addEdges(stadt, "Stuttgart", "Frankfurt", 205);
        addEdges(stadt, "Munchen", "Berlin", 590);
        addEdges(stadt, "Munchen", "Hamburg", 791);
        addEdges(stadt, "Munchen", "Frankfurt", 393);
        addEdges(stadt, "Munchen", "Stuttgart", 232);
        addEdges(stadt, "Berlin", "Hamburg", 289);
        addEdges(stadt, "Berlin", "Frankfurt", 556);
        addEdges(stadt, "Berlin", "Stuttgart", 638);
        addEdges(stadt, "Berlin", "Munchen", 590);

        Scanner input = new Scanner(System.in);
        Scanner masukkan = new Scanner(System.in);
        int pilihan = 1;
        int layanan;
        do {
            try {
                System.out.println("===============================");
                System.out.println("    Antrian Pembelian Tiket    ");
                System.out.println("===============================");
                System.out.println("1. Tambah Antrian ");
                System.out.println("2. Lihat Antrian ");
                System.out.println("3. Kelola Kota ");
                System.out.println("4. Cari Kota ");
                System.out.println("5. Kelola Jalur ");
                System.out.println("6. Cari Jalur ");
                System.out.println("7. Beli Tiket ");
                System.out.println("8. Lihat Tiket Terjual ");
                System.out.println("0. Keluar ");
                System.out.print("Masukkan Pilihan : ");
                pilihan = Integer.parseInt(input.nextLine());
                switch (pilihan) {
                    case 0:
                        System.out.println("Keluar Dari Program");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("TAMBAH ANTRIAN");
                        System.out.println("1) BUS");
                        System.out.println("2) KERETA");
                        System.out.println("3) PESAWAT");
                        System.out.print("Pilih jenis antrian: ");
                        layanan = Integer.parseInt(input.nextLine());
                        String nama_pnp;
                        switch (layanan) {
                            case 1:
                                System.out.print("Masukkan Nama Anda: ");
                                nama_pnp = input.nextLine();
                                bus.enQueue(nama_pnp);
                                break;
                            case 2:
                                System.out.print("Masukkan Nama Anda: ");
                                nama_pnp = input.nextLine();
                                kereta.enQueue(nama_pnp);
                                break;
                            case 3:
                                System.out.print("Masukkan Nama Anda: ");
                                nama_pnp = input.nextLine();
                                pesawat.enQueue(nama_pnp);
                                break;
                            default:
                                throw new IllegalArgumentException("Jenis Antrian Tidak VALID!!!!");
                        }
                        break;
                    case 2:
                        System.out.println("\tLihat Antrian");
                        if (bus.isEmpty() && kereta.isEmpty() && pesawat.isEmpty()) {
                            System.out.println("Antrian Kosong");
                        } else {
                            System.out.println("\tAntrian Bus");
                            bus.print();
                            System.out.println("===================");
                            System.out.println("\tAntrian Kereta");
                            kereta.print();
                            System.out.println("===================");
                            System.out.println("\tAntrian Pesawat");
                            pesawat.print();
                            System.out.println("===================");
                        }
                        break;
                    case 3:
                        System.out.println("KELOLA KOTA");
                        System.out.println("1) TAMBAH KOTA");
                        System.out.println("2) HAPUS KOTA");
                        System.out.println("3) LIHAT KOTA");
                        System.out.print("Pilih tindakan: ");
                        int kelola = Integer.parseInt(input.nextLine());
                        String asal;
                        switch (kelola) {
                            case 1:
                                System.out.print("Masukkan Nama Kota: ");
                                asal = input.nextLine();
                                addNode(stadt, asal);
                                break;
                            case 2:
                                System.out.print("Masukkan Nama Kota: ");
                                asal = input.nextLine();
                                stadt.hapusKota(asal);
                                break;
                            case 3:
                                stadt.cetakGraph();
                                break;
                            default:
                                throw new IllegalArgumentException("Input SALAH!!!");
                        }
                        break;
                    case 4:
                        System.out.print("Masukkan Nama Kota yang ingin dicari: ");
                        String cari = input.nextLine();
                        searchStadt(stadt, cari);
                        break;
                    case 5:
                        System.out.println("KELOLA JALUR");
                        System.out.println("1) TAMBAH JALUR");
                        System.out.println("2) HAPUS JALUR");
                        System.out.println("3) LIHAT JALUR");
                        System.out.print("Pilih tindakan: ");
                        int lajur = masukkan.nextInt();
                        String awal, tujuan;
                        int jarak;
                        switch (lajur) {
                            case 1:
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan: ");
                                tujuan = input.nextLine();
                                System.out.print("Masukkan Jarak (Km): ");
                                jarak = masukkan.nextInt();
                                addEdge(stadt, awal, tujuan, jarak);
                                break;
                            case 2:
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                stadt.hapusJalur(awal);
                                break;
                            case 3:
                                stadt.cetakGraph();
                                break;
                            default:
                                throw new IllegalArgumentException("Input SALAH!!!");
                                
                        }
                        break;
                    case 6:
                        System.out.print("Masukkan Nama Kota Asal: ");
                        awal = input.nextLine();
                        System.out.print("Masukkan Nama Kota Tujuan: ");
                        tujuan = input.nextLine();
                        stadt.cariJalur(stadt, awal, tujuan);
                        break;
                    case 7:
                        if((bus.isEmpty() && kereta.isEmpty() && pesawat.isEmpty()) == false){
                            System.out.println("BELI TIKET");
                            System.out.println("1. Tiket BUS");
                            System.out.println("2. Tiket KERETA");
                            System.out.println("3. Tiket PESAWAT");
                            System.out.print("Silahkan pilih menu beli tiket: ");
                            Integer tiket = masukkan.nextInt();
                            int harga;
                            switch (tiket) {
                                case 1:
                                    String moda = "BUS";
                                    System.out.println("Beli tiket bus");
                                    System.out.print("Masukkan Kota Asal Anda: ");
                                    asal = input.nextLine();
                                    System.out.print("Masukkan Kota Tujuan Anda: ");
                                    tujuan = input.nextLine();
                                    if(checkJalur(stadt, asal, tujuan) == true){
                                        stadt.cariJalur(stadt, asal, tujuan);
                                        harga = (stadt.getNilaiJalur(asal, tujuan) * 1000);
                                        System.out.print("Tiket " + moda + " Atas Nama: " + bus.first.nama + " Berhasil Dibeli");
                                        bus.beliTiket(busTerjual, moda, asal, tujuan, harga);
                                    }else{
                                        System.out.println("Kota tidak ditemukan");
                                    }
                                    break;
                                case 2:
                                    moda = "KERETA";
                                    System.out.println("Beli tiket KERETA");
                                    System.out.print("Masukkan Kota Asal Anda: ");
                                    asal = input.nextLine();
                                    System.out.print("Masukkan Kota Tujuan Anda: ");
                                    tujuan = input.nextLine();
                                    if(checkJalur(stadt, asal, tujuan) == true){
                                        harga = (stadt.getNilaiJalur(asal, tujuan) * 750);
                                        System.out.println("Tiket " + moda + " Atas Nama: " + kereta.first.nama + " Berhasil Dibeli");
                                        kereta.beliTiket(keretaTerjual, moda, asal, tujuan, harga);
                                    }else{
                                        System.out.println("Kota tidak ditemukan");
                                    }
                                    break;
                                case 3:
                                    moda = "PESAWAT";
                                    System.out.println("Beli tiket PESAWAT");
                                    System.out.print("Masukkan Kota Asal Anda: ");
                                    asal = input.nextLine();
                                    System.out.print("Masukkan Kota Tujuan Anda: ");
                                    tujuan = input.nextLine();
                                    if(checkJalur(stadt, asal, tujuan) == true){
                                        harga = (stadt.getNilaiJalur(asal, tujuan) * 2000);
                                        System.out.println("Tiket " + moda + " Atas Nama: " + pesawat.first.nama + " Berhasil Dibeli");
                                        pesawat.beliTiket(pesawatTerjual, moda, asal, tujuan, harga);
                                    }else{
                                        System.out.println("Kota tidak ditemukan");
                                    }
                                    break;
                                default:
                                    throw new IllegalArgumentException("Input SALAH!!!");
                                    
                            }
                        }else{
                            System.out.println("Antrian Kosong");
                        }
                        break;
                    case 8:
                        System.out.println("Menu Lihat Tiket Terjual");
                        System.out.println("Tiket Terjual Pada Moda Transportasi BUS");
                        busTerjual.tiketTerjual();
                        System.out.println("=================================================================================================================");
                        System.out.println("=================================================================================================================");
                        System.out.println("Tiket Terjual Pada Moda Transportasi KERETA");
                        keretaTerjual.tiketTerjual();
                        System.out.println("=================================================================================================================");
                        System.out.println("=================================================================================================================");
                        System.out.println("Tiket Terjual Pada Moda Transportasi PESAWAT");
                        pesawatTerjual.tiketTerjual();
                        System.out.println("=================================================================================================================");
                        System.out.println("=================================================================================================================");
                        int hargatotal = busTerjual.hargatotal + keretaTerjual.hargatotal + pesawat.hargatotal;
                        System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");
                        System.out.printf("| Total Belanja                                                                          : Rp.%-18s|\n", hargatotal);
                        System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");
                        break;
                        default:
                        throw new IllegalArgumentException("Inputan tidak Valid");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                input.nextLine();
            }
        } while (pilihan != 0);
        input.close();
        masukkan.close();

    }
    public static void addNode(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if (node == null){
            stadt.tambahKota(name);;
            System.out.printf ("Kota    %-13s Ditambah  |\n",name);
        }else {
            System.out.println("Kota " + name + " Sudah Ada ");
        }

    }
    public static void addEdge(Graph stadt, String ori, String dest, int jarak){
        Kota end = stadt.cariKota(dest);
        Kota begin = stadt.cariKota(ori);
        if((begin != null) && (end != null)){
            if(!stadt.cekJalur(begin, end)){
                stadt.tambahJalur(end, jarak, begin);
                System.out.println("Jalur "+begin.infoKota+"-"+end.infoKota+": "+ jarak+"Km DITAMBAH !");
            }else {
                System.out.println("Jalur "+begin.infoKota+"-"+end.infoKota+"SUDAH ADA!!!!");
                System.out.println("----------------------------------------------");
            }
        }
    }
    public static void addEdges(Graph stadt, String ori, String dest, int jarak){
        Kota end = stadt.cariKota(dest);
        Kota begin = stadt.cariKota(ori);
        if((begin != null) && (end != null)){
            if(!stadt.cekJalur(begin, end)){
                stadt.tambahJalur(end, jarak, begin);
                
            }else {
                System.out.println("+--------------------------------------------+");
                System.out.println("|   " + begin.infoKota + "   |   " + end.infoKota + "   |     Sudah Ada    |");
                System.out.println("+--------------------------------------------+");
            }
        }
    }
    public static boolean checkJalur(Graph stadt, String asal, String tujuan){
        Kota depart = stadt.cariKota(asal);
        Kota arriv = stadt.cariKota(tujuan);
        boolean ketemu = false;
        if(stadt.cekJalur(depart, arriv) == true){
            ketemu = true;
            return ketemu;
        }else{
            return ketemu;
        }
    }
    public static void searchStadt(Graph stadt, String name) {
        Kota node = stadt.cariKota(name);
        if (node != null) {
            System.out.println("Kota " + name + "Ditemukan");
        } else {
            System.out.println("Kota" + name + "Tidak ditemukan");
        }
    }
}