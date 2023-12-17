/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

/**
 *
 * @author user
 */
public class sewalpfutsal {

    String Nama, NoLapangan, Lokasi;
    int Harga, Jumlah, Total;
    
    
    void harga(int Harga){
        this.Harga = Harga;
    }
    int cetakharga(){
        return Harga;
    }

    void nama(String Nama) {
        this.Nama = Nama;
    }

    void Nolapangan(String NoLapangan) {
        this.NoLapangan = NoLapangan;
    }

    void lokasi(String Lokasi) {
        this.Lokasi = Lokasi;
    }

    String cetakNama() {
        return Nama;
    }

    String cetakLapangan() {
        return NoLapangan;
    }

    String cetaklokasi() {
        return Lokasi;
    }


    void jumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    void total(int Total) {
        this.Total = Total;
    }

//    int Jumlah(){
//        return Jumlah;
//    }
//    int Total(){
//        return Total;
//    }
    public int sewa() {
        Total = (Harga * Jumlah);
        return Total;
    }

}
