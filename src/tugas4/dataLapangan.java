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
public class dataLapangan extends rentalfutsal{
    public String nolapangan,jenislapangan,ukuranlapangan;
    public String Nolapangan1,Nolapangan2,Nolapangan3;
    public String JenisLapangan1,JenisLapangan2,JenisLapangan3;
    public String Ukuran1,Ukuran2,Ukuran3;
    
    public dataLapangan(){
    Nolapangan1 = "1";
    Nolapangan2 = "2";
    Nolapangan3 = "3";
    
    JenisLapangan1 = "Rumpu Sintetis";
    JenisLapangan2 = "Interlock";
    JenisLapangan3 = "Vinyl";
    
    Ukuran1 = "Besar";
    Ukuran2 = "Sedang";
    Ukuran3 = "Kecil";
    }
    
   public void NoLapangan (String nolapangan ){
        this.nolapangan = nolapangan;
    }
       public void JenisLapangan (String jenislapangan ){
        this.jenislapangan = jenislapangan;
    }
       public void UkuranLapangan (String ukuranlapangan ){
        this.ukuranlapangan = ukuranlapangan;
    } 
}
