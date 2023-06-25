package org.tubesUAS;

import java.util.Scanner;

public class Main {
    public static void addNode(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if (node == null){
            stadt.tambahKota(name);;
            System.out.printf("|   %-13s| Ditambah  |\n",name);
            System.out.println("------------------------------");
        }else {
            System.out.println("|   " + name + "   |   Sudah Ada |");
            System.out.println("---------------------------------");
        }
    }
    public static void addEdge(Graph stadt, String ori, String dest, int jarak){
        Kota end = stadt.cariKota(dest);
        Kota begin = stadt.cariKota(ori);
        if((begin != null) && (end != null)){
            if(!stadt.cekJalur(begin, end)){
                stadt.tambahJalur(end, jarak, begin);
                System.out.printf("|   %-13s|  %-15s| %-10d|\n", begin.infoKota,end.infoKota, jarak);
                System.out.println("------------------------------------------------");
            }else {
                System.out.println("|   " + begin.infoKota + "   |   " + end.infoKota + "   |     Sudah Ada    |");
                System.out.println("----------------------------------------------");
            }
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
    public static void cariJalur(Graph stadt, String asal, String tujuan) {
        Kota nodeAsal = stadt.cariKota(asal);
        Kota nodeTujuan = stadt.cariKota(tujuan);

        if (nodeAsal == null || nodeTujuan == null) {
            System.out.println("Kota asal atau tujuan tidak ditemukan");
            return;
        }

        Jalur jalur = stadt.cariJalur(nodeAsal, nodeTujuan);
        if (jalur != null) {
            System.out.println("Jalur ditemukan");
            System.out.println("Kota Asal: " + asal);
            System.out.println("Kota Tujuan: " + tujuan);
            System.out.println("Jarak: " + jalur.jarakKota + " km");
        } else {
            System.out.println("Jalur tidak ditemukan");
        }
    }

    public static void main(String[] args) {
<<<<<<< HEAD
        Graph stadt = new Graph();

=======
        //Deklarasi Objek
        Graph train = new Graph();
        Graph autobus = new Graph();
        Graph plane = new Graph();
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e
        Antrian bus = new Antrian();
        Antrian kereta = new Antrian();
        Antrian pesawat = new Antrian();

        Antrian busTerjual = new Antrian();
        Antrian keretaTerjual = new Antrian();
        Antrian pesawatTerjual = new Antrian();

        Scanner input = new Scanner(System.in);
<<<<<<< HEAD
        Scanner masukkan = new Scanner(System.in);
=======

        //Menambahkan 5 Kota Awal untuk Bus
        addNode(autobus, "Hamburg");
        addNode(autobus, "Frankfurt");
        addNode(autobus, "Stuttgart");
        addNode(autobus,"Munchen");
        addNode(autobus, "Berlin");
        //Menambhkan 5 Kota Awal untuk Kereta
        addNode(train, "Hamburg");
        addNode(train, "Frankfurt");
        addNode(train, "Stuttgart");
        addNode(train,"Munchen");
        addNode(train, "Berlin");
        //Menambahkan 5 Kota Awal untuk Pesawat
        addNode(plane, "Hamburg");
        addNode(plane, "Frankfurt");
        addNode(plane, "Stuttgart");
        addNode(plane,"Munchen");
        addNode(plane, "Berlin");
        //Menambahkan Jalur Untuk Bus
        //Menambahkan Jalur Untuk Kereta
        //Menambahkan Jalur Untuk Pesawat

        //
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e
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
                System.out.println("9. Kembali");
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
<<<<<<< HEAD
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
=======

                        if (layanan == 1) {
                            System.out.print("Masukkan Nama Anda: ");
                            nama_pnp = input.nextLine();
                            bus.enQueue(nama_pnp);
                        } else if (layanan == 2) {
                            System.out.print("Masukkan Nama Anda: ");
                            nama_pnp = input.nextLine();
                            kereta.enQueue(nama_pnp);
                        } else if (layanan == 3) {
                            System.out.print("Masukkan Nama Anda: ");
                            nama_pnp = input.nextLine();
                            pesawat.enQueue(nama_pnp);
                        } else {
                            throw new IllegalArgumentException("Jenis Antrian Tidak VALID!!!!");
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e
                        }
                        break;
                    case 2:
                        System.out.println("Lihat Antrian");
                        if (bus.isEmpty() && kereta.isEmpty() && pesawat.isEmpty()) {
                            System.out.println("Antrian Kosong");
                        } else {
                            System.out.println("Antrian Bus");
                            bus.print();
                            System.out.println("===================");
                            System.out.println("Antrian Kereta");
                            kereta.print();
                            System.out.println("===================");
                            System.out.println("Antrian Pesawat");
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
<<<<<<< HEAD
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
=======

                        if (kelola == 1) {
                            System.out.print("Masukkan Nama Kota: ");
                            asal = input.nextLine();
                            addNode(autobus, asal);
                            addNode(train, asal);
                            addNode(plane, asal);
                        } else if (kelola == 2) {
                            System.out.print("Masukkan Nama Kota: ");
                            asal = input.nextLine();
                            autobus.hapusKota(asal);
                            plane.hapusKota(asal);
                            train.hapusKota(asal);
                        } else if (kelola == 3) {
                            System.out.println("Jalur Bus");
                            autobus.cetakKota();
                            System.out.println("=============");
                            System.out.println("Jalur Kereta");
                            train.cetakKota();
                            System.out.println("=============");
                            System.out.println("Jalur Pesawat");
                            plane.cetakKota();
                            System.out.println("=============");

                        } else {
                            throw new IllegalArgumentException("Input SALAH!!!");
                        }
                    break;
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e
                    case 4:
                        System.out.print("Masukkan Nama Kota yang ingin dicari: ");
                        String cari = input.nextLine();
                        searchStadt(autobus, cari);
                        break;
                    case 5:
                        System.out.println("PILIH MODA:");
                        System.out.println("1) BUS");
                        System.out.println("2) KERETA");
                        System.out.println("3) PESAWAT");
                        System.out.print("Pilih tindakan: ");
<<<<<<< HEAD
                        int lajur = masukkan.nextInt();
                        String awal, tujuan;
                        int jarak;
                        switch (lajur) {
                            case 1:
=======
                        int moda = Integer.parseInt(input.nextLine());
                        if(moda == 1){
                            System.out.println("KELOLA JALUR");
                            System.out.println("1) TAMBAH JALUR");
                            System.out.println("2) HAPUS JALUR");
                            System.out.println("3) LIHAT JALUR");
                            System.out.print("Pilih tindakan: ");
                            int lajur = Integer.parseInt(input.nextLine());
                            String awal, tujuan;
                            int jarak;
                            if (lajur == 1) {
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan: ");
                                tujuan = input.nextLine();
                                System.out.print("Masukkan Jarak (Km): ");
<<<<<<< HEAD
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
                        System.out.println("BELI TIKET");
                        System.out.println("1. Tiket BUS");
                        System.out.println("2. Tiket KERETA");
                        System.out.println("3. Tiket PESAWAT");
                        System.out.println("Silahkan pilih menu beli tiket: ");
                        Integer tiket = masukkan.nextInt();
                        String nama;
                        switch (tiket) {
                            case 1:
                                System.out.println("Beli tiket bus");
                                // System.out.print("Masukkan nama anda: ");
                                // nama = input.nextLine();
                                bus.beliTiket(bus, busTerjual, nama, "BUS");
                                System.out.println("");
                                break;
                            case 2:
                                System.out.println("Beli tiket kereta");
                                System.out.println("Masukkan nama anda: ");
                                // metode
                                System.out.println("");
                                break;
                            case 3:
                                System.out.println("Beli tiket pesawat");
                                System.out.println("Masukkan nama anda: ");
                                // metode
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Input salah");
                                break;
                        }
                        break;
                    case 8:
                        System.out.println("Menu Lihat Tiket Terjual");
=======
                                jarak = input.nextInt();
                                addEdge(autobus, awal, tujuan, jarak);
                            } else if (lajur == 2) {
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                autobus.hapusJalur(awal);
                            } else if (lajur == 3) {
                                autobus.cetakJalur();
                            } else {
                                throw new IllegalArgumentException("Input SALAH!!!");
                            }
                        }else if(moda == 2){
                            System.out.println("KELOLA JALUR");
                            System.out.println("1) TAMBAH JALUR");
                            System.out.println("2) HAPUS JALUR");
                            System.out.println("3) LIHAT JALUR");
                            System.out.print("Pilih tindakan: ");
                            int lajur = Integer.parseInt(input.nextLine());
                            String awal, tujuan;
                            int jarak;
                            if (lajur == 1) {
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan: ");
                                tujuan = input.nextLine();
                                System.out.print("Masukkan Jarak (Km): ");
                                jarak = input.nextInt();
                                addEdge(train, awal, tujuan, jarak);
                            } else if (lajur == 2) {
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                train.hapusJalur(awal);
                            } else if (lajur == 3) {
                                train.cetakJalur();
                            } else {
                                throw new IllegalArgumentException("Input SALAH!!!");
                            }
                        }else if(moda == 3){
                            System.out.println("KELOLA JALUR");
                            System.out.println("1) TAMBAH JALUR");
                            System.out.println("2) HAPUS JALUR");
                            System.out.println("3) LIHAT JALUR");
                            System.out.print("Pilih tindakan: ");
                            int lajur = Integer.parseInt(input.nextLine());
                            String awal, tujuan;
                            int jarak;
                            if (lajur == 1) {
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan: ");
                                tujuan = input.nextLine();
                                System.out.print("Masukkan Jarak (Km): ");
                                jarak = input.nextInt();
                                addEdge(plane, awal, tujuan, jarak);
                            } else if (lajur == 2) {
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                plane.hapusJalur(awal);
                            } else if (lajur == 3) {
                                plane.cetakJalur();
                            } else {
                                throw new IllegalArgumentException("Input SALAH!!!");
                            }
                        }else{
                            throw new IllegalArgumentException("INPUT SALAH!!!");
                        }
                        break;
                    case 6:
                        System.out.println("PILIH MODA:");
                        System.out.println("1) BUS");
                        System.out.println("2) KERETA");
                        System.out.println("3) PESAWAT");
                        System.out.print("Pilih tindakan: ");
                        int look = Integer.parseInt(input.nextLine());
                        if(look == 1){
                            System.out.println("Masukkan Nama Kota Asal: ");
                            String board = input.nextLine();
                            System.out.println("Masukkan Nama Kota Tujuan: ");
                            String arriv = input.nextLine();
                            cariJalur(autobus, board, arriv);
                        }else if(look == 2){
                            System.out.println("Masukkan Nama Kota Asal: ");
                            String board = input.nextLine();
                            System.out.println("Masukkan Nama Kota Tujuan: ");
                            String arriv = input.nextLine();
                            cariJalur(train, board, arriv);
                        }else if(look == 3){
                            System.out.println("Masukkan Nama Kota Asal: ");
                            String board = input.nextLine();
                            System.out.println("Masukkan Nama Kota Tujuan: ");
                            String arriv = input.nextLine();
                            cariJalur(plane, board, arriv);
                        }else{
                            throw  new IllegalArgumentException("Input Salah");
                        }

                        break;
>>>>>>> 6960db9de8066698ba0356a706615d3c9260e15e

                    default:
                        throw new IllegalArgumentException("Inputan tidak Valid");
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                input.nextLine();
            }
        } while (pilihan != 0);

    }
}