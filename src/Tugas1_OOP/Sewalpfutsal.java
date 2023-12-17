/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tugas1_OOP;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class Sewalpfutsal {

    String Namapenyewa, lapangan, bola;
    String namapenyewa, Totalwaktu, Nolapangan, Waktumasuk, Waktukeluar,tanggalpesan,totalpembayaran;
//int harga,nourutan,;
    void infNamapenyewa(String Nama_Penyewa) {
        this.Namapenyewa = Nama_Penyewa;
    }

    void inflapangan(String lapangan) {
        this.lapangan = lapangan;
    }

    void infbola(String bola) {
        this.bola = bola;
    }

    void infnamapenyewa(String nama_penyewa) {
        this.namapenyewa = nama_penyewa;
    }

    void infTotalwaktu(String Total_waktu) {
        this.Totalwaktu = Total_waktu;
    }

    void infNolapangan(String No_lapangan) {
        this.Nolapangan = No_lapangan;
    }

    void infWaktumasuk(String Waktu_masuk) {
        this.Waktumasuk = Waktu_masuk;
    }

    void infWaktukeluar(String Waktu_keluar) {
        this.Waktukeluar = Waktu_keluar;
    }
        void inftanggalpesan(String tanggal_pesan) {
        this.tanggalpesan = tanggal_pesan;
    }
      void inftotalpembayaran(String total_pembayaran) {
        this.totalpembayaran = total_pembayaran;
    }
    String printNamapenyewa() {
        return Namapenyewa;
    }

    String printlapangan() {
        return lapangan;
    }

    String printbola() {
        return bola;
    }

    String printnamapenyewa() {
        return namapenyewa;
    }

    String printTotalwaktu() {
        return Totalwaktu;
    }

    String printNolapangan() {
        return Nolapangan;
    }

    String printWaktumasuk() {
        return Waktumasuk;
    }

    String printWaktukeluar() {
        return Waktukeluar;
    }
        String printtanggalpesan() {
        return tanggalpesan;
    }
        String printtotalpembayaran() {
        return totalpembayaran;
    }
}
