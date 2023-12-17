/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bab6;

/**
 *
 * @author user
 */
public abstract class pesawat extends kendaraan {
    String bahanbakar;
    int sayap,roda;
    
    @Override
    int roda (){
        roda = 6;
 return roda;
    }
    String bahanbakar(){
        bahanbakar = "biosolar";
        return bahanbakar;
    }
}
