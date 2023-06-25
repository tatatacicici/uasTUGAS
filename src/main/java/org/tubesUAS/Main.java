package org.tubesUAS;
import  java.util.Scanner;

public class Main {
    public static void addNode(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if (node == null){
            stadt.tambahKota(name);
            System.out.printf("|   %-13s| Ditambah  |\n",name);
            System.out.println("------'.------------------------");
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
    public static  void searchStadt(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if(node != null){
            System.out.println("Kota "+name+"Ditemukan");
        }else{
            System.out.println("Kota"+name+"Tidak ditemukan");
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
        //Deklarasi Objek
        Graph train = new Graph();
        Graph autobus = new Graph();
        Graph plane = new Graph();
        Antrian bus = new Antrian();
        Antrian kereta = new Antrian();
        Antrian pesawat = new Antrian();
        Scanner input = new Scanner(System.in);

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
                        }
                        break;
                    case 2:
                        System.out.println("Lihat Antrian");
                        if(bus.isEmpty() && kereta.isEmpty() && pesawat.isEmpty()){
                            System.out.println("Antrian Kosong");
                        }else{
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
                                System.out.print("Masukkan Kota Asal: ");
                                awal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan: ");
                                tujuan = input.nextLine();
                                System.out.print("Masukkan Jarak (Km): ");
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

                    default:
                        throw new IllegalArgumentException("Inputan tidak Valid");
                }

            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                input.nextLine();
            }
        }while(pilihan != 0);

    }
}