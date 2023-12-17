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
public  class gaji_reward extends gaji_abs_reward {
    double menit,bonus,gajipokok,tunjangan,anak;
    int waktu;
    
    @Override
    double lembur(){
        return 0;
    }
    
    
    @Override
    double tunjangananak(){
        if(anak==1){
            tunjangan=0.1*gajipokok;
        }else if (anak>1){
            tunjangan=0.2* gajipokok;
        }
        return tunjangan; 
    }
    String bonus(){
        double bon;
        bon = lembur()+tunjangananak();
        return Double.toString(bon);
    }

}