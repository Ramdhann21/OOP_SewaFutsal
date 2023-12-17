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
public class prisma_segitiga extends segitiga {
    double tinggiPrisma,vol;
    double volumePrisma(){
        vol = (luas() *tinggiPrisma);
        return vol;
    }
}
