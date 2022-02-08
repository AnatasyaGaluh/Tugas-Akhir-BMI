/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anatasya
 */
import java.util.*;

public class appBMI {
    public static void main(String[] args) {

        System.out.println("~ SELAMAT DATANG ~");

        //inisialisasi variabel
        double weight = 0, height = 0, bmi, target, periode, kal;

        //looping untuk mencetak dan kembali ke menu utama
        boolean cetakMenu = true;
        do {
            System.out.println("\n##### Main Menu #####");
            System.out.println("1. Masukkan Data\n2. Kalkulasi BMI\n3. Kalkulasi Kalori\n4. Keluar\n");

            //input pilihan menu
            int menu;
            String inputMenu = "Silakan masukkan menu pilihan Anda: ";
            do {
                menu = cekInt(inputMenu);
            } while (!noMenu(menu));

            //switch case menu 1-4
            switch (menu) {
                case 1:
                    System.out.println("\n======== Masukkan Data ========\n");
                    System.out.println("Silakan masukkan data Anda:\n");
                    String inputWeight = "Berat badan (kg) : ";
                    String inputHeight = "Tinggi badan (cm): ";

                    //input age, weight, height
                    weight = cekDouble(inputWeight);
                    height = cekDouble(inputHeight);
                    System.out.println();

                    //kembali ke menu utama
                    tekanNol();
                    break;
                case 2:
                    System.out.println("\n======== Kalkulasi BMI ========\n");

                    //kalkulasi BMI
                    bmi = rounding(weight / Math.pow((height/100), 2));

                    //cetak weight, height, bmi
                    System.out.println("Dengan tinggi badan " + height + " cm dan berat badan " + weight + " kg,");
                    System.out.println("Body mass index Anda adalah: " + bmi);

                    //kategorisasi BMI
                    String kategori = cekKategori(bmi);

                    //cetak tabel BMI
                    tabelBmi(height);

                    //cetak kategori
                    System.out.println("Anda masuk ke dalam kategori " + kategori + ".\n");

                    //kembali ke menu utama
                    tekanNol();
                    break;
                case 3:
                    System.out.println("\n======== Kalkulasi Kalori ========\n");
                    String inputTarget = "Target berat badan (kg): ";
                    String inputPeriode = "Periode untuk mencapai target (hari): ";

                    //input target berat badan dan periode untuk mencapai target
                    target = cekDouble(inputTarget);
                    periode = cekInt(inputPeriode);

                    //kalkulasi kalori
                    if (target < weight) {
                        //untuk weight loss
                        kal = rounding(((weight - target)*7700)/periode);
                        System.out.println("\nAnda perlu membakar " + kal + " kalori per hari.\n");
                    } else {
                        //untuk weight gain
                        kal = rounding(((target - weight)*7000)/periode);
                        System.out.println("\nAnda perlu mengkonsumsi " + kal + " kalori per hari.\n");
                    }

                    //kembali ke menu utama
                    tekanNol();
                    break;
                case 4:
                    System.out.println("\n~~ TERIMA KASIH ~~");
                    //keluar aplikasi
                    cetakMenu = false;
            }
        } while (cetakMenu);
    }

    // ################################ METHODS ################################

    public static void tabelBmi(double n) {
        //inisialisasi variabel array
        double[] bmi = {18.5, 24.9, 25, 29.9, 30};
        double[] range = new double[5];

        //konversi tinggi badan dalam (cm) ke (m)
        n = n/100;

        //for loop untuk mengisi array range
        for (int i = 0; i < bmi.length; i++) {
            range[i] = rounding((bmi[i] * Math.pow(n, 2)));
        }

        //cetak tabel BMI sesuai tinggi badan user
        System.out.println("\n+---------------+-------------------+");
        System.out.println("|  Berat Badan  |      Kategori     |");
        System.out.println("+---------------+-------------------|");
        System.out.println("|  < " + range[0] + "       |  Underweight      |");
        System.out.println("|  " + range[0] + " - " + range[1] + "  |  Normal           |");
        System.out.println("|  " + range[2] + " - " + range[3] + "  |  Overweight       |");
        System.out.println("|  > " + range[4] + "       |  Very overweight  |");
        System.out.println("+---------------+-------------------+");
    }

    public static String cekKategori(double n) {
        String kategori;

        //cek kategori BMI dengan input weight (n)
        if (n < 18.5) {
            kategori = "underweight";
        } else if (n < 25) {
            kategori = "normal";
        } else if (n < 30) {
            kategori = "overweight";
        } else {
            kategori = "sangat overweight";
        }
        return kategori;
    }

    public static double cekDouble(String n) {
        Scanner scan = new Scanner(System.in);
        boolean koma;
        double num = 0;

        //cek apakah input user valid (double)
        do {
            try {
                System.out.print(n);
                num = scan.nextDouble();
                scan.nextLine();
                koma = true;
            } catch (InputMismatchException e) {
                System.out.println("Input Anda tidak valid.");
                scan.next();
                koma = false;
            }
        } while (!koma);
        return num;
    }

    public static int cekInt(String n) {
        Scanner scan = new Scanner(System.in);
        boolean angka;
        int num = 0;

        //cek apakah input user valid (int)
        do {
            try {
                System.out.print(n);
                num = scan.nextInt();
                scan.nextLine();
                angka = true;
            } catch (InputMismatchException e) {
                System.out.println("Input Anda tidak valid.");
                scan.next();
                angka = false;
            }
        } while (!angka);
        return num;
    }

    public static double rounding(double n) {
        //rounding nilai double ke 1 desimal
        return Math.round(n * 10.0) / 10.0;
    }

    public static boolean noMenu(int n) {
        boolean oneToFour = true;

        //cek apakah input user valid (menu 1-4)
        if (n < 1 || n > 4) {
            System.out.println("Mohon memilih angka dari 1-4.");
            oneToFour = false;
        }
        return oneToFour;
    }

    public static void tekanNol() {
        Scanner scan = new Scanner(System.in);
        boolean zero;
        String a = "Tekan 0 untuk kembali ke menu utama: ";

        //cek apakah input user valid (0)
        do {
            System.out.print(a);
            String nol = scan.nextLine();
            if (nol.equals("0")) {
                zero = true;
            } else {
                System.out.println("Input Anda tidak valid.");
                zero = false;
            }
        } while (!zero);
    }
}
