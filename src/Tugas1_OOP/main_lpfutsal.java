/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas1_OOP;

/**
 *
 * @author user
 */
public class main_lpfutsal {

    // LocalDate tanggalSekarang = LocalDate.now();
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    //   String tanggalFormat = tanggalSekarang.format(formatter);
    public static void main(String[] args) {

        Sewalpfutsal sewa = new Sewalpfutsal();
        sewa.infnamapenyewa("Ramdhan saviola Zulkifly");
        sewa.infTotalwaktu("3 jam");
        sewa.infNolapangan(" no 1");
        sewa.infWaktumasuk("jam 08:00");
        sewa.infWaktukeluar("jam 11:00");
        sewa.inftanggalpesan("10-11-2023");
         sewa.inftotalpembayaran("150.000");

        System.out.println("SEWA Lapangan futsal");
        System.out.println("TANGGAL : ");
        System.out.println("===================");
        System.out.println("");
        System.out.println("nama Penyewa: " + sewa.printnamapenyewa());
        System.out.println("Total Waktu: " + sewa.printTotalwaktu());
        System.out.println("No lapangan: " + sewa.printNolapangan());
        System.out.println("Waktu Masuk: " + sewa.printWaktumasuk());
        System.out.println("Waktu Keluar: " + sewa.printWaktukeluar());
        System.out.println("tanggal pesan: " + sewa.printtanggalpesan());
        System.out.println("total pembayaran: " + sewa.printtotalpembayaran());
    }
}
