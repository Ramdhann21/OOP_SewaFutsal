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
abstract public class kendaraan {
    String bahanbakar;
    int kursi,roda;
    
    kendaraan (){
        kursi = 2;
        roda = 4;
        bahanbakar = "biosolar";
    }
    abstract String  nyalakanmesin();
    abstract int roda ();
    abstract String bahanbakar ();
     
    
}
