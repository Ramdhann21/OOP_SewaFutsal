/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bab3;

/**
 *
 * @author user
 */
public class limas_segitiga extends segitiga {
    double tinggiLimas,vol;
    double VolumeLimas(){
        vol=((0.333 * luas ())*tinggiLimas);
        return vol;
    }
}
