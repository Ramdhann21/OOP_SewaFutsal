/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas4;

import tugas3.*;

/**
 *
 * @author user
 */
public class rentalfutsal {
   public String nama;
   private int id,notelephon,waktusewa,waktumasuk,waktukeluar;
    
    
    public void Nama (String nama ){
        this.nama= nama;
    }
    public int getID (){
        return id ;
    }
    public void setID(int ID){
        this.id = id;
    }
    public int getNotelephon (){
        return notelephon;
    }
    public void setNotelephone(int Notelephone){
        this.notelephon = Notelephone;
    }
    public int getwaktusewa (){
        return waktusewa;
    }
    public void setWaktusewa (int  waktusewa ){
        this.waktusewa= waktusewa;
    }
    public int getWaktumasuk(){
        return waktumasuk;
    }
    public void setWaktumasuk (int waktumasuk ){
        this.waktumasuk= waktumasuk;
    }
    public int getwaktukeluar (){
        return waktukeluar ;
    }
    public void setwaktukeluar (int waktukeluar ){
        this.waktukeluar= waktukeluar;
    }    
}
