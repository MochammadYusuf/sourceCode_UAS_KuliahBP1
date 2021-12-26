package kuliah.UAS;

import java.util.Scanner;

public class UAS_BP1 {

    static String[][] bubbleSort(String[] menu, int[] harga) {

        String hasil[][] = new String[10][2];
        for (int a = 0; a < harga.length; a++) {
            for (int b = 0; b < menu.length - 1; b++) {
                if ((menu[b + 1]) != null) {
                    if (harga[b] > harga[b + 1]) {
                        // Mengurutkan Harga
                        int temp = harga[b];
                        harga[b] = harga[b + 1];
                        harga[b + 1] = temp;
                        // Mengurutkan Menu
                        String temp2 = menu[b];
                        menu[b] = menu[b + 1];
                        menu[b + 1] = temp2;
                    }
                }
            }
        }
        for (int i = 0; i < menu.length; i++) {
            hasil[i][0] = menu[i];
            hasil[i][1] = String.valueOf(harga[i]);
        }
        return hasil;

    }

    static String[][] searchMenu(String[] menu, int[] harga, String cari) {

        String[][] hasil = new String[10][2];
        int index = 0;
        for (int i = 0; i < menu.length - 1; i++) {
            if (menu[i + 1] != null) {
                if (menu[i].indexOf(cari) >= 0) {
                    hasil[index][0] = menu[i];
                    hasil[index][1] = String.valueOf(harga[i]);
                    index++;
                }
            }
        }
        return hasil;

    }

    static int hitungHarga(int hargaSatuan, int nominal) {

        int harga = hargaSatuan * nominal;
        return harga;

    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //Inisialisasi
        boolean akun = false;

        String makanan[] = new String[10];
        String minuman[] = new String[10];
        String cemilan[] = new String[10];
        int hargaMkn[] = new int[10];
        int hargaMnm[] = new int[10];
        int hargaCml[] = new int[10];

        //menu Makanan
        int jmlMkn = 7;
        makanan[0] = "Mie Goreng  ";
        hargaMkn[0] = 4000;
        makanan[1] = "Mie Kuah    ";
        hargaMkn[1] = 4000;
        makanan[2] = "Tahu Telor  ";
        hargaMkn[2] = 10000;
        makanan[3] = "Sate Ayam   ";
        hargaMkn[3] = 12000;
        makanan[4] = "Sate Kambing";
        hargaMkn[4] = 15000;
        makanan[5] = "Soto Ayam   ";
        hargaMkn[5] = 8000;
        makanan[6] = "Nasi Goreng ";
        hargaMkn[6] = 10000;
        //menu Minuman
        int jmlMnm = 6;
        minuman[0] = "Pop Ice     ";
        hargaMnm[0] = 4000;
        minuman[1] = "Es Teh      ";
        hargaMnm[1] = 3000;
        minuman[2] = "Es Jeruk    ";
        hargaMnm[2] = 4000;
        minuman[3] = "Es Coklat   ";
        hargaMnm[3] = 6000;
        minuman[4] = "Es Susu     ";
        hargaMnm[4] = 5000;
        minuman[5] = "Kopi        ";
        hargaMnm[5] = 3000;
        //menu Cemilan
        int jmlCml = 4;
        cemilan[0] = "Kentang Goreng";
        hargaCml[0] = 10000;
        cemilan[1] = "Gorengan      ";
        hargaCml[1] = 8000;
        cemilan[2] = "Pentol Bakar  ";
        hargaCml[2] = 15000;
        cemilan[3] = "Siomay        ";
        hargaCml[3] = 16000;

        String transaksi[][] = new String[20][3];
        String[] atasNama = new String[20];
        int[] nominal = new int[20];
        int[] totalHarga = new int[20];
        int totalTransaksi = 0;
        int menu = 0;
        int index = 0, idxMkn = 0, idxCml = 0, idxMnm = 0;

        System.out.println("=================================================================");
        System.out.println("Kedai Halu 99");
        System.out.println("=================================================================\n");

        while (!akun) {

            System.out.print("Login Sebagai [Kasir/Admin/Owner] : ");
            String auth = scan.next();

            switch (auth.toLowerCase()) {

                case "kasir": //Kasir
                    System.out.println("\nLogin Sebagai Kasir!\n");

                    boolean pilihMenu = false;

                    while (!pilihMenu) {

                        System.out.println("=================================================================");
                        System.out.println("Daftar Menu : ");
                        System.out.println("1. Aneka Makanan");
                        System.out.println("2. Aneka Cemilan");
                        System.out.println("3. Aneka Minuman");
                        System.out.println("=================================================================");
                        System.out.print("Pilih Menu : ");
                        int pilih = scan.nextInt();
                        System.out.println("=================================================================");

                        switch (pilih) {

                            case 1: //Makanan

                                boolean forOpsi1 = false;

                                while (!forOpsi1) {

                                    System.out.print("Show All / Cari Menu Makanan [1/2] : ");
                                    int opsi1 = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi1) {

                                        case 1: //Show All Menu Makanan

                                            String[][] sortMakanan = bubbleSort(makanan, hargaMkn);
                                            System.out.println("Daftar Menu Makanan : ");
                                            System.out.println("No.\tNama Makanan\tHarga Per-Porsi");
                                            for (int c = 0; c < jmlMkn; c++) {
                                                System.out.println((c + 1) + ".\t" + sortMakanan[c][0] + "\tRp"
                                                        + sortMakanan[c][1]);
                                            }

                                            System.out.println("=================================================================");

                                            System.out.print("Pilih menu : ");
                                            menu = scan.nextInt();
                                            System.out.print("Nominal : ");
                                            nominal[index] = scan.nextInt();

                                            transaksi[index][0] = sortMakanan[menu - 1][0];
                                            transaksi[index][1] = String.valueOf(sortMakanan[menu - 1][1]);
                                            totalHarga[index] = hitungHarga(Integer.parseInt(transaksi[index][1]),
                                                     nominal[index]);
                                            totalTransaksi = totalTransaksi + totalHarga[index];

                                            index++;

                                            System.out.println("=================================================================");

                                            break;

                                        case 2: //Cari Menu Makanan

                                            System.out.print("Cari Menu Makanan : ");
                                            String cariMakanan = scan.next();

                                            String hasilCari[][] = searchMenu(makanan, hargaMkn, cariMakanan);
                                            System.out.println("Hasil Pencarian : ");
                                            System.out.println("No.\tNama Makanan\tHarga Per-Porsi");
                                            for (int i = 0; i < hasilCari.length; i++) {
                                                if (hasilCari[i][0] != null) {
                                                    System.out.println((i + 1) + ".\t" + hasilCari[i][0] + "\tRp"
                                                            + Integer.parseInt(hasilCari[i][1]));
                                                }
                                            }

                                            System.out.println("=================================================================");

                                            System.out.print("Pilih menu : ");
                                            menu = scan.nextInt();
                                            System.out.print("Nominal : ");
                                            nominal[index] = scan.nextInt();

                                            transaksi[index][0] = hasilCari[menu - 1][0];
                                            transaksi[index][1] = String.valueOf(hasilCari[menu - 1][1]);
                                            totalHarga[index] = hitungHarga(Integer.parseInt(transaksi[index][1]),
                                                     nominal[index]);
                                            totalTransaksi = totalTransaksi + totalHarga[index];

                                            index++;

                                            System.out.println("=================================================================");

                                            break;

                                        default:
                                            System.out.println("Opsi Anda Salah!");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi 1 Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Memesan Makanan Lagi (Y/N) : ");

                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            forOpsi1 = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }

                                break;
                            case 2: //Cemilan

                                boolean forOpsi2 = false;

                                while (!forOpsi2) {

                                    System.out.print("Show All / Cari Menu Cemilan [1/2] : ");
                                    int opsi2 = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi2) {

                                        case 1: //Show All Menu Cemilan

                                            String[][] sortCemilan = bubbleSort(cemilan, hargaCml);
                                            System.out.println("Daftar Menu Cemilan : ");
                                            System.out.println("No.\tNama Cemilan\tHarga Per-Porsi");
                                            for (int d = 0; d < jmlCml; d++) {
                                                System.out.println((d + 1) + ".\t" + sortCemilan[d][0] + "\tRp"
                                                        + sortCemilan[d][1]);
                                            }

                                            System.out.println("=================================================================");

                                            System.out.print("Pilih menu : ");
                                            menu = scan.nextInt();
                                            System.out.print("Nominal : ");
                                            nominal[index] = scan.nextInt();

                                            transaksi[index][0] = sortCemilan[menu - 1][0];
                                            transaksi[index][1] = String.valueOf(sortCemilan[menu - 1][1]);
                                            totalHarga[index] = hitungHarga(Integer.parseInt(transaksi[index][1]),
                                                     nominal[index]);
                                            totalTransaksi = totalTransaksi + totalHarga[index];

                                            index++;

                                            System.out.println("=================================================================");

                                            break;

                                        case 2: //Cari Menu Cemilan

                                            System.out.print("Cari Menu Cemilan : ");
                                            String cariCemilan = scan.next();

                                            String hasilCari[][] = searchMenu(cemilan, hargaCml, cariCemilan);
                                            System.out.println("Hasil Pencarian : ");
                                            System.out.println("No.\tNama Cemilan\tHarga Per-Porsi");
                                            for (int i = 0; i < hasilCari.length; i++) {
                                                if (hasilCari[i][0] != null) {
                                                    System.out.println((i + 1) + ".\t" + hasilCari[i][0] + "\tRp"
                                                            + Integer.parseInt(hasilCari[i][1]));
                                                }
                                            }

                                            System.out.println("=================================================================");

                                            System.out.print("Pilih menu : ");
                                            menu = scan.nextInt();
                                            System.out.print("Nominal : ");
                                            nominal[index] = scan.nextInt();

                                            transaksi[index][0] = hasilCari[menu - 1][0];
                                            transaksi[index][1] = String.valueOf(hasilCari[menu - 1][1]);
                                            totalHarga[index] = hitungHarga(Integer.parseInt(transaksi[index][1]),
                                                     nominal[index]);
                                            totalTransaksi = totalTransaksi + totalHarga[index];

                                            index++;

                                            System.out.println("=================================================================");

                                            break;

                                        default:
                                            System.out.println("Opsi Anda Salah");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi 2 Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Memesan Cemilan Lagi (Y/N) : ");

                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            forOpsi2 = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }

                                break;

                            case 3: //Minuman

                                boolean forOpsi3 = false;

                                while (!forOpsi3) {

                                    System.out.print("Show All / Cari Menu Minuman [1/2] : ");
                                    int opsi3 = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi3) {

                                        case 1: //Show All Menu Minuman

                                            String[][] sortMinuman = bubbleSort(minuman, hargaMnm);
                                            System.out.println("Daftar Menu Minuman : ");
                                            System.out.println("No.\tNama Minuman\tHarga Per-Porsi");
                                            for (int e = 0; e < jmlMnm; e++) {
                                                System.out.println((e + 1) + ".  " + sortMinuman[e][0] + "\tRp"
                                                        + sortMinuman[e][1]);
                                            }

                                            System.out.println("=================================================================");

                                            System.out.print("Pilih menu : ");
                                            menu = scan.nextInt();
                                            System.out.print("Nominal : ");
                                            nominal[index] = scan.nextInt();

                                            transaksi[index][0] = sortMinuman[menu - 1][0];
                                            transaksi[index][1] = String.valueOf(sortMinuman[menu - 1][1]);
                                            totalHarga[index] = hitungHarga(Integer.parseInt(transaksi[index][1]),
                                                     nominal[index]);
                                            totalTransaksi = totalTransaksi + totalHarga[index];

                                            index++;

                                            System.out.println("=================================================================");

                                            break;

                                        case 2: //Cari Menu Minuman

                                            System.out.print("Cari Menu Minuman : ");
                                            String cariMinuman = scan.next();

                                            String hasilCari[][] = searchMenu(minuman, hargaMnm, cariMinuman);
                                            System.out.println("Hasil Pencarian : ");
                                            System.out.println("No.\tNama Minuman\tHarga Per-Porsi");
                                            for (int i = 0; i < hasilCari.length; i++) {
                                                if (hasilCari[i][0] != null) {
                                                    System.out.println((i + 1) + ".\t" + hasilCari[i][0] + "\tRp"
                                                            + Integer.parseInt(hasilCari[i][1]));
                                                }
                                            }

                                            System.out.println("=================================================================");

                                            System.out.print("Pilih menu : ");
                                            menu = scan.nextInt();
                                            System.out.print("Nominal : ");
                                            nominal[index] = scan.nextInt();

                                            transaksi[index][0] = hasilCari[menu - 1][0];
                                            transaksi[index][1] = String.valueOf(hasilCari[menu - 1][1]);
                                            totalHarga[index] = hitungHarga(Integer.parseInt(transaksi[index][1]),
                                                     nominal[index]);
                                            totalTransaksi = totalTransaksi + totalHarga[index];

                                            index++;

                                            System.out.println("=================================================================");

                                            break;

                                        default:
                                            System.out.println("Opsi Anda Salah");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi 3 Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Memesan Minuman Lagi (Y/N) : ");

                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            forOpsi3 = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }

                                break;

                            default:
                                System.out.println("Pilihan Menu Tidak Tersedia!");
                                break;

                        }

                        System.out.println("");
                        System.out.println("=================================================================");

                        String jawab;
                        boolean stopAsk = false;

                        // Loop (Pertanyaan Transaksi Kembali)
                        while (!stopAsk) {
                            System.out.print("Ingin Memilih Menu Lagi (Y/N) : ");

                            jawab = scan.next();

                            if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                continue;
                            }

                            stopAsk = true;

                            if (jawab.toLowerCase().equals("n")) {
                                pilihMenu = true;
                            }

                        }

                        System.out.println("=================================================================");

                    }

                    System.out.println("Daftar Transaksi : ");
                    System.out.println("No.\tNama Menu\tHarga Per-Porsi\tNominal\tTotal Harga");
                    for (int i = 0; i < index; i++) {
                        System.out.println((i + 1) + ".\t" + transaksi[i][0] + "\tRp" + transaksi[i][1] + "\t\t"
                                + nominal[i] + "\t" + totalHarga[i]);
                    }
                    System.out.println("=================================================================");
                    System.out.println("Total Transaksi Kedai Halu 99 : " + totalTransaksi);
                    System.out.println("=================================================================");

                    break;

                case "admin": //Admin
                    System.out.println("\nLogin Sebagai Admin!\n");

                    boolean pilihMenu2 = false;

                    while (!pilihMenu2) {

                        //CRUD
                        System.out.println("=================================================================");
                        System.out.println("Opsi Admin : ");
                        System.out.println("1. Menampilkan Menu");
                        System.out.println("2. Menambah Menu");
                        System.out.println("3. Mengubah Menu");
                        System.out.println("4. Menghapus Menu");
                        System.out.println("=================================================================");
                        System.out.print("Pilih Menu : ");
                        int pilih2 = scan.nextInt();
                        System.out.println("=================================================================");

                        switch (pilih2) {

                            case 1: //Menampilkan Menu

                                boolean read = false;

                                System.out.println("");

                                while (!read) {

                                    System.out.println("=================================================================");
                                    System.out.println("Daftar Opsi : ");
                                    System.out.println("1. Menampilkan Menu Makanan");
                                    System.out.println("2. Menampilkan Menu Cemilan");
                                    System.out.println("3. Menampilkan Menu Minuman");
                                    System.out.println("=================================================================");
                                    System.out.print("Pilih Opsi : ");
                                    int opsi = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi) {

                                        case 1: //Tampilkan Menu Makanan

                                            boolean forOpsiMakanan = false;

                                            while (!forOpsiMakanan) {

                                                System.out.print("Show All / Cari Menu Makanan [1/2] : ");
                                                int opsi1 = scan.nextInt();
                                                System.out.println("=================================================================");

                                                switch (opsi1) {

                                                    case 1: //Show All Menu Makanan

                                                        String[][] sortMakanan = bubbleSort(makanan, hargaMkn);
                                                        System.out.println("Daftar Menu Makanan : ");
                                                        System.out.println("No.\tNama Makanan\tHarga Per-Porsi");
                                                        for (int c = 0; c < jmlMkn; c++) {
                                                            System.out.println((c + 1) + ".\t" + sortMakanan[c][0] + "\tRp"
                                                                    + sortMakanan[c][1]);
                                                        }

                                                        System.out.println("=================================================================");

                                                        break;

                                                    case 2: //Cari Menu Makanan

                                                        System.out.print("Cari Menu Makanan : ");
                                                        String cariMakanan = scan.next();

                                                        String hasilCari[][] = searchMenu(makanan, hargaMkn, cariMakanan);
                                                        System.out.println("Hasil Pencarian : ");
                                                        System.out.println("No.\tNama Makanan\tHarga Per-Porsi");
                                                        for (int i = 0; i < hasilCari.length; i++) {
                                                            if (hasilCari[i][0] != null) {
                                                                System.out.println((i + 1) + ".\t" + hasilCari[i][0] + "\tRp"
                                                                        + Integer.parseInt(hasilCari[i][1]));
                                                            }
                                                        }

                                                        System.out.println("=================================================================");

                                                        break;

                                                    default:
                                                        System.out.println("Opsi Anda Salah!");

                                                }

                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi 1 Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Menampilkan Menu Makanan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        forOpsiMakanan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;
                                        case 2: //Tampilkan Menu Cemilan

                                            boolean forOpsiCemilan = false;

                                            while (!forOpsiCemilan) {

                                                System.out.print("Show All / Cari Menu Cemilan [1/2] : ");
                                                int opsi2 = scan.nextInt();
                                                System.out.println("=================================================================");

                                                switch (opsi2) {

                                                    case 1: //Show All Menu Cemilan

                                                        String[][] sortCemilan = bubbleSort(cemilan, hargaCml);
                                                        System.out.println("Daftar Menu Cemilan : ");
                                                        System.out.println("No.\tNama Cemilan\tHarga Per-Porsi");
                                                        for (int d = 0; d < jmlCml; d++) {
                                                            System.out.println((d + 1) + ".\t" + sortCemilan[d][0] + "\tRp"
                                                                    + sortCemilan[d][1]);
                                                        }

                                                        System.out.println("=================================================================");

                                                        break;

                                                    case 2: //Cari Menu Cemilan

                                                        System.out.print("Cari Menu Cemilan : ");
                                                        String cariCemilan = scan.next();

                                                        String hasilCari[][] = searchMenu(cemilan, hargaCml, cariCemilan);
                                                        System.out.println("Hasil Pencarian : ");
                                                        System.out.println("No.\tNama Cemilan\tHarga Per-Porsi");
                                                        for (int i = 0; i < hasilCari.length; i++) {
                                                            if (hasilCari[i][0] != null) {
                                                                System.out.println((i + 1) + ".\t" + hasilCari[i][0] + "\tRp"
                                                                        + Integer.parseInt(hasilCari[i][1]));
                                                            }
                                                        }

                                                        System.out.println("=================================================================");

                                                        break;

                                                    default:
                                                        System.out.println("Opsi Anda Salah");

                                                }

                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi 2 Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Menampilkan Menu Cemilan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        forOpsiCemilan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;
                                        case 3: //Tampilkan Menu Minuman

                                            boolean forOpsiMinuman = false;

                                            while (!forOpsiMinuman) {

                                                System.out.print("Show All / Cari Menu Minuman [1/2] : ");
                                                int opsi3 = scan.nextInt();
                                                System.out.println("=================================================================");

                                                switch (opsi3) {

                                                    case 1: //Show All Menu Minuman

                                                        String[][] sortMinuman = bubbleSort(minuman, hargaMnm);
                                                        System.out.println("Daftar Menu Minuman : ");
                                                        System.out.println("No.\tNama Minuman\tHarga Per-Porsi");
                                                        for (int e = 0; e < jmlMnm; e++) {
                                                            System.out.println((e + 1) + ".  " + sortMinuman[e][0] + "\tRp"
                                                                    + sortMinuman[e][1]);
                                                        }

                                                        System.out.println("=================================================================");

                                                        break;

                                                    case 2: //Cari Menu Minuman

                                                        System.out.print("Cari Menu Minuman : ");
                                                        String cariMinuman = scan.next();

                                                        String hasilCari[][] = searchMenu(minuman, hargaMnm, cariMinuman);
                                                        System.out.println("Hasil Pencarian : ");
                                                        System.out.println("No.\tNama Minuman\tHarga Per-Porsi");
                                                        for (int i = 0; i < hasilCari.length; i++) {
                                                            if (hasilCari[i][0] != null) {
                                                                System.out.println((i + 1) + ".\t" + hasilCari[i][0] + "\tRp"
                                                                        + Integer.parseInt(hasilCari[i][1]));
                                                            }
                                                        }

                                                        System.out.println("=================================================================");

                                                        break;

                                                    default:
                                                        System.out.println("Opsi Anda Salah");

                                                }

                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi 3 Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Menampilkan Menu Minuman Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        forOpsiMinuman = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;
                                        default:
                                            System.out.println("Opsi Menampilkan Anda Salah!");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi Read Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Ingin Menampilkan Menu Lagi (Y/N) : ");
                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            read = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }

                                break;
                            case 2: //Menambah Menu

                                boolean create = false;

                                System.out.println("");

                                while (!create) {

                                    System.out.println("=================================================================");
                                    System.out.println("Daftar Opsi : ");
                                    System.out.println("1. Menambah Menu Makanan");
                                    System.out.println("2. Menambah Menu Cemilan");
                                    System.out.println("3. Menambah Menu Minuman");
                                    System.out.println("=================================================================");
                                    System.out.print("PIlih Opsi : ");
                                    int opsi1 = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi1) {

                                        case 1: // Create Makanan

                                            boolean createMakanan = false;

                                            while (!createMakanan) {

                                                System.out.print("Nama Menu Makanan : ");
                                                scan = new Scanner(System.in);
                                                makanan[jmlMkn] = scan.nextLine();
                                                System.out.print("Harga Menu Makanan : ");
                                                hargaMkn[jmlMkn] = scan.nextInt();
                                                System.out.println("Menambahkan Menu Makanan Berhasil!");
                                                jmlMkn++;

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi createMakanan Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Menambah Menu Makanan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        createMakanan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;
                                        case 2: // Create Cemilan

                                            boolean createCemilan = false;

                                            while (!createCemilan) {

                                                System.out.print("Nama Menu Cemilan : ");
                                                scan = new Scanner(System.in);
                                                makanan[jmlCml] = scan.nextLine();
                                                System.out.print("Harga Menu Cemilan : ");
                                                hargaMkn[jmlCml] = scan.nextInt();
                                                System.out.println("Menambahkan Menu Cemilan Berhasil!");
                                                jmlMkn++;

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi createCemilan Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Menambah Menu Cemilan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        createCemilan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;
                                        case 3: // Create Minuman

                                            boolean createMinuman = false;

                                            while (!createMinuman) {

                                                System.out.print("Nama Menu Minuman : ");
                                                scan = new Scanner(System.in);
                                                makanan[jmlMnm] = scan.nextLine();
                                                System.out.print("Harga Menu Minuman : ");
                                                hargaMkn[jmlMnm] = scan.nextInt();
                                                System.out.println("Manambahkan Menu Minuman Berhasil!");
                                                jmlMkn++;

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi createMinuman Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Menambah Menu Minuman Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        createMinuman = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;
                                        default:
                                            System.out.println("Opsi Menambah Anda Salah!");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi Create Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Ingin Menambah Menu Lagi (Y/N) : ");

                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            create = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }

                                break;
                            case 3: //Mengubah Menu

                                boolean update = false;

                                System.out.println("");

                                while (!update) {

                                    System.out.println("=================================================================");
                                    System.out.println("Daftar Opsi : ");
                                    System.out.println("1. Mengubah Menu Makanan");
                                    System.out.println("2. Mengubah Menu Cemilan");
                                    System.out.println("3. Mengubah Menu Minuman");
                                    System.out.println("=================================================================");
                                    System.out.print("PIlih Opsi : ");
                                    int opsi2 = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi2) {

                                        case 1: //Meng-Edit Makanan

                                            boolean updateMakanan = false;

                                            while (!updateMakanan) {

                                                System.out.print("Nama Menu Makanan : ");
                                                scan = new Scanner(System.in);
                                                String namaMakanan1 = scan.nextLine();
                                                boolean findMakanan1 = false;
                                                int idxFindMakanan1 = -1;
                                                for (int i = 0; i < jmlMkn; i++) {
                                                    if (makanan[i].compareToIgnoreCase(namaMakanan1) == 0) {
                                                        findMakanan1 = true;
                                                        idxFindMakanan1 = i;
                                                        break;
                                                    }
                                                }
                                                if (findMakanan1 == false) {
                                                    System.out.println("Menu Tidak Ada!");
                                                } else {
                                                    // Mengubah isi Array Makanan
                                                    for (int i = idxFindMakanan1; i < jmlMkn - 1; i++) {
                                                        makanan[i] = makanan[i + 1];
                                                        hargaMkn[i] = hargaMkn[i + 1];
                                                    }
                                                    jmlMkn--;
                                                }
                                                System.out.print("Perbarui Nama Menu Makanan : ");
                                                scan = new Scanner(System.in);
                                                makanan[jmlMkn] = scan.nextLine();
                                                System.out.print("Perbarui Harga Menu Makanan : ");
                                                hargaMkn[jmlMkn] = scan.nextInt();
                                                System.out.println("Pemberuan Menu Makanan Berhasil!");
                                                jmlMkn++;

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi Edit Makanan Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Mengubah Menu Makanan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        updateMakanan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;

                                        case 2: //Meng-Edit Cemilan

                                            boolean updateCemilan = false;

                                            while (!updateCemilan) {

                                                System.out.print("Nama Menu Cemilan : ");
                                                scan = new Scanner(System.in);
                                                String namaCemilan1 = scan.nextLine();
                                                boolean findCemilan1 = false;
                                                int idxFindCemilan1 = -1;
                                                for (int i = 0; i < jmlCml; i++) {
                                                    if (cemilan[i].compareToIgnoreCase(namaCemilan1) == 0) {
                                                        findCemilan1 = true;
                                                        idxFindCemilan1 = i;
                                                        break;
                                                    }
                                                }
                                                if (findCemilan1 == false) {
                                                    System.out.println("Menu Cemilan Tidak Ada!");
                                                } else {
                                                    // Mengubah isi Array Makanan
                                                    for (int i = idxFindCemilan1; i < jmlCml - 1; i++) {
                                                        cemilan[i] = cemilan[i + 1];
                                                        hargaCml[i] = hargaCml[i + 1];
                                                    }
                                                    jmlCml--;
                                                }
                                                System.out.print("Perbarui Nama Menu Cemilan : ");
                                                scan = new Scanner(System.in);
                                                cemilan[jmlCml] = scan.nextLine();
                                                System.out.print("Perbarui Harga Menu Cemilan : ");
                                                hargaCml[jmlCml] = scan.nextInt();
                                                System.out.println("Pemberuan Menu Cemilan Berhasil!");
                                                jmlCml++;

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi Edit Cemilan Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Mengubah Menu Cemilan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        updateCemilan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;

                                        case 3: //Meng-Edit Minuman

                                            boolean updateMinuman = false;

                                            while (!updateMinuman) {

                                                System.out.print("Nama Menu Minuman : ");
                                                scan = new Scanner(System.in);
                                                String namaMinuman1 = scan.nextLine();
                                                boolean findMinuman1 = false;
                                                int idxFindMinuman1 = -1;
                                                for (int i = 0; i < jmlMnm; i++) {
                                                    if (minuman[i].compareToIgnoreCase(namaMinuman1) == 0) {
                                                        findMinuman1 = true;
                                                        idxFindMinuman1 = i;
                                                        break;
                                                    }
                                                }
                                                if (findMinuman1 == false) {
                                                    System.out.println("Menu Minuman Tidak Ada!");
                                                } else {
                                                    // Mengubah isi Array Makanan
                                                    for (int i = idxFindMinuman1; i < jmlMnm - 1; i++) {
                                                        minuman[i] = minuman[i + 1];
                                                        hargaMnm[i] = hargaMnm[i + 1];
                                                    }
                                                    jmlMkn--;
                                                }
                                                System.out.print("Perbarui Nama Menu Minuman : ");
                                                scan = new Scanner(System.in);
                                                minuman[jmlMnm] = scan.nextLine();
                                                System.out.print("Perbarui Harga Menu Minuman : ");
                                                hargaMnm[jmlMnm] = scan.nextInt();
                                                System.out.println("Pemberuan Menu Minuman Berhasil!");
                                                jmlMnm++;

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi Edit Minuman Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Mengubah Menu Minuman Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        updateMinuman = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;

                                        default:
                                            System.out.println("Opsi Update Anda Salah!");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi Edit Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Ingin Mengubah Menu Lagi (Y/N) : ");

                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            update = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }

                                break;
                            case 4: // Menghapus Menu

                                boolean delete = false;

                                System.out.println("");

                                while (!delete) {

                                    System.out.println("=================================================================");
                                    System.out.println("Daftar Opsi : ");
                                    System.out.println("1. Menghapus Menu Makanan");
                                    System.out.println("2. Menghapus Menu Cemilan");
                                    System.out.println("3. Menghapus Menu Minuman");
                                    System.out.println("=================================================================");
                                    System.out.print("PIlih Opsi : ");
                                    int opsi3 = scan.nextInt();
                                    System.out.println("=================================================================");

                                    switch (opsi3) {

                                        case 1: //Menghapus Menu Makanan

                                            boolean deleteMakanan = false;

                                            while (!deleteMakanan) {

                                                System.out.print("Nama Menu Makanan : ");
                                                scan = new Scanner(System.in);
                                                String namaMakanan = scan.nextLine();
                                                boolean findMakanan = false;
                                                int idxFindMakanan = -1;
                                                for (int i = 0; i < jmlMkn; i++) {
                                                    if (makanan[i].compareToIgnoreCase(namaMakanan) == 0) {
                                                        findMakanan = true;
                                                        idxFindMakanan = i;
                                                        break;
                                                    }
                                                }
                                                if (findMakanan == false) {
                                                    System.out.println("Menu Tidak Ada!");
                                                } else {
                                                    // Mengubah isi Array Makanan
                                                    for (int i = idxFindMakanan; i < jmlMkn - 1; i++) {
                                                        makanan[i] = makanan[i + 1];
                                                        hargaMkn[i] = hargaMkn[i + 1];
                                                    }
                                                    System.out.println("Penghapusan Menu " + namaMakanan + " Berhasil!");
                                                    jmlMkn--;
                                                }

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi delete Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Menghapus Menu Makanan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        deleteMakanan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;

                                        case 2: //Menghapus Menu Cemilan

                                            boolean deleteCemilan = false;

                                            while (!deleteCemilan) {

                                                System.out.print("Nama Menu Cemilan : ");
                                                scan = new Scanner(System.in);
                                                String namaCemilan = scan.nextLine();
                                                boolean findCemilan = false;
                                                int idxFindCemilan = -1;
                                                for (int i = 0; i < jmlCml; i++) {
                                                    if (cemilan[i].compareToIgnoreCase(namaCemilan) == 0) {
                                                        findCemilan = true;
                                                        idxFindCemilan = i;
                                                        break;
                                                    }
                                                }
                                                if (findCemilan == false) {
                                                    System.out.println("Menu Tidak Ada!");
                                                } else {
                                                    // Mengubah isi Array Makanan
                                                    for (int i = idxFindCemilan; i < jmlCml - 1; i++) {
                                                        cemilan[i] = cemilan[i + 1];
                                                        hargaCml[i] = hargaCml[i + 1];
                                                    }
                                                    System.out.println("Penghapusan Menu " + namaCemilan + " Berhasil!");
                                                    jmlCml--;
                                                }

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi delete Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Menghapus Menu Cemilan Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        deleteCemilan = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;

                                        case 3: //Menghapus Menu Minuman

                                            boolean deleteMinuman = false;

                                            while (!deleteMinuman) {

                                                System.out.print("Nama Menu Minuman : ");
                                                scan = new Scanner(System.in);
                                                String namaMinuman = scan.nextLine();
                                                boolean findMinuman = false;
                                                int idxFindMinuman = -1;
                                                for (int i = 0; i < jmlMkn; i++) {
                                                    if (minuman[i].compareToIgnoreCase(namaMinuman) == 0) {
                                                        findMinuman = true;
                                                        idxFindMinuman = i;
                                                        break;
                                                    }
                                                }
                                                if (findMinuman == false) {
                                                    System.out.println("Menu Tidak Ada!");
                                                } else {
                                                    // Mengubah isi Array Makanan
                                                    for (int i = idxFindMinuman; i < jmlMnm - 1; i++) {
                                                        minuman[i] = minuman[i + 1];
                                                        hargaMnm[i] = hargaMnm[i + 1];
                                                    }
                                                    System.out.println("Penghapusan Menu " + namaMinuman + " Berhasil!");
                                                    jmlMnm--;
                                                }

                                                System.out.println("=================================================================");
                                                System.out.println("");
                                                System.out.println("=================================================================");

                                                String jawab;
                                                boolean stopAsk = false;

                                                // Loop (Pertanyaan Opsi delete Kembali)
                                                while (!stopAsk) {
                                                    System.out.print("Ingin Menghapus Menu Minuman Lagi (Y/N) : ");

                                                    jawab = scan.next();

                                                    if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                                        continue;
                                                    }

                                                    stopAsk = true;

                                                    if (jawab.toLowerCase().equals("n")) {
                                                        deleteMinuman = true;
                                                    }

                                                }

                                                System.out.println("=================================================================");

                                            }

                                            break;

                                        default:
                                            System.out.println("Opsi Menghapus Anda Salah");

                                    }

                                    System.out.println("");
                                    System.out.println("=================================================================");

                                    String jawab;
                                    boolean stopAsk = false;

                                    // Loop (Pertanyaan Opsi delete Kembali)
                                    while (!stopAsk) {
                                        System.out.print("Ingin Menghapus Menu Lagi (Y/N) : ");

                                        jawab = scan.next();

                                        if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                            continue;
                                        }

                                        stopAsk = true;

                                        if (jawab.toLowerCase().equals("n")) {
                                            delete = true;
                                        }

                                    }

                                    System.out.println("=================================================================");

                                }
                                break;
                            default:
                                System.out.println("Pilihan Opsi Salah!");

                        }

                        System.out.println("");
                        System.out.println("=================================================================");

                        String jawab;
                        boolean stopAsk = false;

                        // Loop (Pertanyaan Opsi Admin Kembali)
                        while (!stopAsk) {
                            System.out.print("Ingin Memilih Opsi Lain (Y/N) : ");

                            jawab = scan.next();

                            if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                continue;
                            }

                            stopAsk = true;

                            if (jawab.toLowerCase().equals("n")) {
                                pilihMenu2 = true;
                            }

                        }

                        System.out.println("=================================================================");

                    }

                    break;

                case "owner": //Owner
                    System.out.println("Login Sebagai Owner!");
                    
                    boolean pilihMenu3 = false;

                    while (!pilihMenu3) {

                        //CRUD
                        System.out.println("=================================================================");
                        System.out.println("Opsi Admin : ");
                        System.out.println("1. Menampilkan Daftar Pesanan");
                        System.out.println("2. Menampilkan Menu Terlaris");
                        System.out.println("=================================================================");
                        System.out.print("Pilih Menu : ");
                        int pilih3 = scan.nextInt();
                        System.out.println("=================================================================");

                        switch (pilih3) {
                            
                            case 1 : //Menampilkan Daftar Pesanan
                                
                                System.out.println("Daftar Transaksi : ");
                                System.out.println("No.\tNama Menu\tHarga Per-Porsi\tNominal\tTotal Harga");
                                for (int i = 0; i < index; i++) {
                                    System.out.println((i + 1) + ".\t" + transaksi[i][0] + "\tRp" + transaksi[i][1] + "\t\t"
                                            + nominal[i] + "\t" + totalHarga[i]);
                                }
                                System.out.println("=================================================================");
                                System.out.println("Total Transaksi Kedai Halu 99 : " + totalTransaksi);
                                System.out.println("=================================================================");
                                
                                break;
                                
                            case 2 : //Menampilkan Menu Terlaris
                                
                                for (int a = 0; a < nominal.length; a++) {
                                    for (int b = 0; b < nominal.length - 1; b++) {
                                        if(nominal[b] < nominal[b+1]) {
                                            // Mengurutkan Nominal
                                            int temp = nominal[b];
                                            nominal[b] = nominal[b+1];
                                            nominal[b+1] = temp;
                                            // Mengurutkan Menu
                                            String temp2 = transaksi[b][0];
                                            transaksi[b][0] = transaksi[b+1][0];
                                            transaksi[b+1][0] = temp2;
                                            // Mengurutkan Harga
                                            String temp3 = transaksi[b][1];
                                            transaksi[b][1] = transaksi[b+1][1];
                                            transaksi[b+1][1] = temp3;
                                            //Mengurutkan Total Harga
                                            int temp4 = totalHarga[b];
                                            totalHarga[b] = totalHarga[b+1];
                                            totalHarga[b+1] = temp4;
                                        }
                                    }
                                }
                                
                                System.out.println("Daftar Transaksi : ");
                                System.out.println("No.\tNama Menu\tHarga Per-Porsi\tNominal\tTotal Harga");
                                for (int i = 0; i < index; i++) {
                                    System.out.println((i + 1) + ".\t" + transaksi[i][0] + "\tRp" + transaksi[i][1] + "\t\t"
                                            + nominal[i] + "\t" + totalHarga[i]);
                                }
                                System.out.println("=================================================================");
                                
                                break;
                                
                            default:
                                System.out.println("Pilihan Opsi Salah!");
                            
                        }
                        
                        System.out.println("");
                        System.out.println("=================================================================");

                        String jawab;
                        boolean stopAsk = false;

                        // Loop (Pertanyaan Opsi Owner Kembali)
                        while (!stopAsk) {
                            System.out.print("Ingin Memilih Opsi Lain (Y/N) : ");

                            jawab = scan.next();

                            if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                                continue;
                            }

                            stopAsk = true;

                            if (jawab.toLowerCase().equals("n")) {
                                pilihMenu3 = true;
                            }

                        }

                        System.out.println("=================================================================");
                        
                    }

                    break;

                default:
                    System.out.println("Akun Salah atau Tidak Ditemukan");
                    break;

            }

            System.out.println("");
            System.out.println("=================================================================");

            String jawab;
            boolean stopAsk = false;

            // Loop (Pertanyaan Login Kembali)
            while (!stopAsk) {
                System.out.print("Ingin Login Kembali (Y/N) : ");

                jawab = scan.next();

                if (!jawab.toLowerCase().equals("y") && !jawab.toLowerCase().equals("n")) {
                    continue;
                }

                stopAsk = true;

                if (jawab.toLowerCase().equals("n")) {
                    akun = true;
                }

            }

            System.out.println("=================================================================\n");

        }
        
        System.out.println("");
        System.out.println("=================================================================");
        System.out.println("Terima Kasih!!!");
        System.out.println("=================================================================\n");

    }

}
