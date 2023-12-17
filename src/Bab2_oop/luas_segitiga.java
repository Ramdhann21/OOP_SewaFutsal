/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bab2_oop;

/**
 *
 * @author user
 */
public class luas_segitiga {
    int alas, tinggi;
    double luas;
    
    
    public luas_segitiga(){
        this.alas = 10;
    }
    public double luas(){
        luas = (alas*tinggi)/2;
        return luas ;
    }
}
