/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tubesUAS;

import java.util.Scanner;
import java.util.NoSuchElementException;
public class Main {
    public static void main(String[] args) {
        Graph stadt = new Graph();
        //objek antrian awal
        Antrian bus = new Antrian();
        Antrian kereta = new Antrian();
        Antrian pesawat = new Antrian();
        //objek antrian beli/terjual
        Antrian busTerjual = new Antrian();
        Antrian keretaTerjual = new Antrian();
        Antrian pesawatTerjual = new Antrian();
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

        Scanner input = new Scanner(System.in);
        Scanner masukkan = new Scanner(System.in);
        int pilihan = 1;
        int layanan;
        do {
            try {
                System.out.println("");
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
                        System.out.println("");
                        System.out.println("━━━━━━━━━━");
                        System.out.println(" Tambah Antrian ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Bus");
                        System.out.println("2) Kereta");
                        System.out.println("3) Pesawat");
                        System.out.print("Pilih jenis antrian: ");
                        layanan = Integer.parseInt(input.nextLine());
                        String nama_pnp;
                        switch (layanan) {
                            case 1:
                                System.out.print("Masukkan Nama Anda: ");
                                nama_pnp = input.nextLine();

                                if (!nama_pnp.isEmpty()) {
                                    bus.enQueue(nama_pnp);
                                    System.out.println("Antrian Bus dengan nama " + nama_pnp + " ditambahkan");
                                } else {
                                    System.out.println("Nama tidak boleh kosong. Antrian tidak ditambahkan.");
                                }

                            case 2:
                                System.out.print("Masukkan Nama Anda: ");
                                nama_pnp = input.nextLine();

                                if (!nama_pnp.isEmpty()) {
                                    kereta.enQueue(nama_pnp);
                                    System.out.println("Antrian Kereta dengan nama " + nama_pnp + " ditambahkan");
                                } else {
                                    System.out.println("Nama tidak boleh kosong. Antrian tidak ditambahkan.");
                                }

                                break;
                            case 3:
                                System.out.print("Masukkan Nama Anda: ");
                                nama_pnp = input.nextLine();

                                if (!nama_pnp.isEmpty()) {
                                    pesawat.enQueue(nama_pnp);
                                    System.out.println("Antrian Pesawat dengan nama " + nama_pnp + " ditambahkan");
                                } else {
                                    System.out.println("Nama tidak boleh kosong. Antrian tidak ditambahkan.");
                                }
                                pesawat.enQueue(nama_pnp);
                                System.out.println("Antrian Pesawat dengan nama " +nama_pnp + " ditambahkan");

                                break;

                            default:
                        System.out.println("\t  ━━━━━━━━━━");
                        System.out.println("\t    Lihat Antrian ");
                        System.out.println("\t  ━━━━━━━━━━");
                        if (bus.isEmpty() && kereta.isEmpty() && pesawat.isEmpty()) {
                            System.out.println("Antrian Kosong");
                        } else {
                            System.out.println("\n============= ANTRIAN BUS =============");
                            bus.print();
                            System.out.println("\n=========== ANTRIAN KERETA ============");
                            kereta.print();
                            System.out.println("\n=========== ANTRIAN PESAWAT ===========");
                            pesawat.print();
                        }
                        break;
                    case 3:
                        System.out.println("━━━━━━━━━━");
                        System.out.println("   Kelola Kota  ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Tambah Kota");
                        System.out.println("2) Hapus Kota");
                        System.out.println("3) Lihat Kota");
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
                                stadt.cetakStadt();
                                break;
                            default:
                                throw new IllegalArgumentException("Inputan Salah!!!");
                        }
                        break;
                    case 4:
                        System.out.print("Masukkan Nama Kota yang ingin dicari: ");
                        String cari = input.nextLine();
                        searchStadt(stadt, cari);
                        break;
                    case 5:
                        System.out.println("━━━━━━━━━━");
                        System.out.println("  Kelola Jalur  ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Tambah Jalur");
                        System.out.println("2) Hapus Jalur");
                        System.out.println("3) Lihat Jalur");
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
                                stadt.cetakRute();
                                break;
                            default :
                                throw new IllegalArgumentException("Inputan Salah!!!");
                        }
                        break;
                    case 6:
                        System.out.print("Masukkan Nama Kota Asal: ");
                        awal = input.nextLine();
                        System.out.print("Masukkan Nama Kota Tujuan: ");
                        tujuan = input.nextLine();
                        if(!awal.equalsIgnoreCase(tujuan)) {
                            stadt.cariJalur(stadt, awal, tujuan);
                            System.out.println("Harga Bus");
                            int hargabus = (stadt.getNilaiJalur(awal, tujuan) * 1000);
                            System.out.println(awal + "-" + tujuan + "= Rp." + hargabus);
                            System.out.println("Harga Kereta");
                            int hargakereta = (stadt.getNilaiJalur(awal, tujuan) * 750);
                            System.out.println(awal + "-" + tujuan + "= Rp." + hargakereta);
                            System.out.println("Harga Pesawat");
                            int hargapesawat = (stadt.getNilaiJalur(awal, tujuan) * 2000);
                            System.out.println(awal + "-" + tujuan + "= Rp." + hargapesawat);

                        }else{
                            System.out.println("Kota asal dan Tujuan tidak Boleh SAMA");
                        }

                        break;
                    case 7:
                        System.out.println("━━━━━━━━━━");
                        System.out.println("   Beli Tiket   ");
                        System.out.println("━━━━━━━━━━");
                        System.out.println("1) Tiket Bus");
                        System.out.println("2) Tiket Kereta");
                        System.out.println("3) Tiket Pesawat");
                        System.out.print("Silahkan pilih menu beli tiket: ");
                        int tiket = masukkan.nextInt();
                        switch (tiket){
                            case 1:
                                String moda = "Bus";
                                System.out.println("");
                                System.out.println("    ==== Beli tiket Bus ====    ");
                                System.out.print("Masukkan Kota Asal Anda: ");
                                asal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan Anda: ");
                                tujuan = input.nextLine();
                                int harga = (stadt.getNilaiJalur(asal, tujuan) * 1000);

                                System.out.println("Tiket " + moda + " Atas Nama " + bus.first.nama + " Berhasil Dibeli");
                                System.out.println("Harga tiket "+asal+"-"+tujuan+": Rp."+harga);
                                bus.beliTiket(busTerjual, moda, asal, tujuan, harga);
                                if(!asal.equalsIgnoreCase(tujuan)){
                                    System.out.println("Tiket " + moda + " Atas Nama " + bus.first.nama + " Berhasil Dibeli");
                                    System.out.println("Harga tiket "+asal+"-"+tujuan+": Rp."+harga);
                                    bus.deQueue();
                                }
                                break;
                            case 2:
                                moda = "Kereta";
                                System.out.println("");
                                System.out.println("    ==== Beli tiket Kereta ====     ");
                                System.out.print("Masukkan Kota Asal Anda: ");
                                asal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan Anda: ");
                                tujuan = input.nextLine();
                                harga = (stadt.getNilaiJalur(asal, tujuan) * 750);

                                System.out.println("Tiket " + moda + " Atas Nama " + kereta.first.nama + " Berhasil Dibeli");
                                System.out.println("Harga tiket "+asal+"-"+tujuan+": Rp."+harga);
                                kereta.beliTiket(keretaTerjual, moda, asal, tujuan, harga);
                                if(!asal.equalsIgnoreCase(tujuan)) {
                                    System.out.println("Tiket " + moda + " Atas Nama " + kereta.first.nama + " Berhasil Dibeli");
                                    System.out.println("Harga tiket " + asal + "-" + tujuan + ": Rp." + harga);
                                    kereta.deQueue();
                                }
                                break;
                            case 3:
                                moda = "Pesawat";
                                System.out.println("");
                                System.out.println("    ==== Beli tiket Pesawat ====    ");
                                System.out.print("Masukkan Kota Asal Anda: ");
                                asal = input.nextLine();
                                System.out.print("Masukkan Kota Tujuan Anda: ");
                                tujuan = input.nextLine();
                                harga = (stadt.getNilaiJalur(asal, tujuan) * 2000);

                                System.out.println("Tiket " + moda + " Atas Nama " + pesawat.first.nama + " Berhasil Dibeli");
                                System.out.println("Harga tiket "+asal+"-"+tujuan+": Rp."+harga);

                                pesawat.beliTiket(pesawatTerjual, moda, asal, tujuan, harga);
                                if(!asal.equalsIgnoreCase(tujuan)){
                                    System.out.println("Tiket " + moda + " Atas Nama " + pesawat.first.nama + " Berhasil Dibeli");
                                    System.out.println("Harga tiket "+asal+"-"+tujuan+": Rp."+harga);
                                    pesawat.deQueue();
                                }
                                break;
                            default:
                                System.out.println("Inputan salah!!!");
                                break;
                        }
                        break;
                    case 8:
                        System.out.println("\n                ================== TIKET TERJUAL PADA MODA TRANSPORTASI BUS =================");
                        busTerjual.tiketTerjual();
                        System.out.println("\n                ================ TIKET TERJUAL PADA MODA TRANSPORTASI KERETA ================");
                        keretaTerjual.tiketTerjual();
                        System.out.println("\n                ================ TIKET TERJUAL PADA MODA TRANSPORTASI PESAWAT ================");
                        pesawatTerjual.tiketTerjual();
                        int hargatotal = busTerjual.hargatotal + keretaTerjual.hargatotal + pesawat.hargatotal;
                        System.out.printf("| Total Semua                                                                            Rp.%-20s|\n", hargatotal);
                        System.out.println("+----------------------+-------------------+----------------------+----------------------+----------------------+");
                        break;
                    default:
                        throw new IllegalArgumentException("Inputan tidak Valid");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka yang valid!");
            } catch (IllegalArgumentException e) {
                System.out.println("Input tidak valid. Pilihan tidak sesuai!");
            } catch (NoSuchElementException e) {
                System.out.println("Input tidak boleh kosong!");
            } catch (NullPointerException e) {
                System.out.println("Kota / Jalur tidak ada!!!");
            }
        } while (pilihan != 0);
        input.close();
        masukkan.close();
    }
    public static void addNode(Graph stadt, String name){
        Kota node = stadt.cariKota(name);
        if (node == null){
            stadt.tambahKota(name);
              System.out.println("Kota " +name + " ditambahkan");
//            System.out.printf("|   %-13s| Ditambah  |\n",name);
//            System.out.println("------------------------------");
        }else {
              System.out.println("Kota " +name + " Sudah ada!");
//            System.out.println("|   " + name + "   |   Sudah Ada |");
//            System.out.println("---------------------------------");
        }
    }
    public static void addEdge(Graph stadt, String ori, String dest, int jarak){
        Kota end = stadt.cariKota(dest);
        Kota begin = stadt.cariKota(ori);
        if((begin != null) && (end != null)){
            if(!stadt.cekJalur(begin, end)){
                stadt.tambahJalur(end, jarak, begin);
                System.out.println("Jalur dari kota " +begin.infoKota+ " ke kota " +end.infoKota+ " ditambahkan");
//                System.out.printf("|   %-13s|  %-15s| %-10d|\n", begin.infoKota,end.infoKota, jarak);
//                System.out.println("------------------------------------------------");
            }else {
                System.out.println("Jalur dari kota " +begin.infoKota+ " ke kota " +end.infoKota+ " sudah ada!");
//                System.out.println("|   " + begin.infoKota + "   |   " + end.infoKota + "   |     Sudah Ada    |");
//                System.out.println("----------------------------------------------");
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
                System.out.println("Jalur dari kota " +begin.infoKota+ " ke kota " +end.infoKota+ " sudah ada!");
//                System.out.println("+--------------------------------------------+");
//                System.out.println("|   " + begin.infoKota + "   |   " + end.infoKota + "   |     Sudah Ada    |");
//                System.out.println("+--------------------------------------------+");
            }
        }
    }

    public static void searchStadt(Graph stadt, String name) {
        Kota node = stadt.cariKota(name);
        if (node != null) {
            System.out.println("Kota " + name + " Ditemukan");
        } else {
            System.out.println("Kota " + name + " Tidak ditemukan!");
        }
    }
}
