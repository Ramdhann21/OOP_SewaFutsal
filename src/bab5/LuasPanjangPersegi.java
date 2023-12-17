/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bab5;

/**
 *
 * @author user
 */
public class LuasPanjangPersegi extends BangunDatar{
    int Panjang;
    int lebar;

    public double Luar() {
        return super.Luas(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public double Luas (){
        return Luas (Panjang,lebar);
    }
}
