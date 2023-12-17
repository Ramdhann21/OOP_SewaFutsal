/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan6;

/**
 *
 * @author user
 */
public abstract class gaji_abs_reward {
    // Atribut
    double gajipokok; // Gaji Pokok
    double tunj_anak; // Tunjangan Anak

    // Method abstract yang akan diimplementasikan di subclass
    abstract double lembur(); // Method lembur
    abstract double tunjangananak(); // Method tunjanganAnak
}

