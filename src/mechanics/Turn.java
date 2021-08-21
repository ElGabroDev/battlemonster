/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mechanics;

import battle.Battle;
import move.BaseMove;

/**
 *
 * @author elgabro
 */
public class Turn {

    /**
     *
     * Metodo statico, vengono passati il contesto della battaglia e l'intero della mossa selezionata. Viene quindi salvata 
     * la mossa selezionata dall'attaccante, e viene attivata grazie all'override a seconda del tipo di questa. Viene passato
     * il contesto della battaglia.
     * 
     * @param battle
     * @param turnSelection
     */
    public static void makeTurn(Battle battle, int turnSelection) {

        BaseMove moveSelected;

        System.out.println("");
        System.out.println("Esecuzione mossa");
        System.out.println("--------------");

        moveSelected = battle.getAttacker().getMoves()[turnSelection];

        moveSelected.activate(battle);

    }

}
