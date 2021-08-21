/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;

/**
 *
 * @author elgabro
 */
public class RNG {
    public static int Roll10(){
        Random random = new Random();
        return random.nextInt(10) + 1;
    }
}
