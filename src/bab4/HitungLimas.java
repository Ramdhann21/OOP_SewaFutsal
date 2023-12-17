/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bab4;

/**
 *
 * @author user
 */
public class HitungLimas {
    private double LuasAlas;
    public double Tinggi ;
    double Volume;
    double Vol;
    
    public HitungLimas(){
        LuasAlas = 3;
        Tinggi = 5;
    }
    public double  getluasalas(){
        return LuasAlas;
    }
       public void getluasalas(double LuasAlas){
        this.LuasAlas = LuasAlas ; 
    }
       double Vol (){
           return Volume = ((getluasalas()* 0.33) * Tinggi );
       }
}
