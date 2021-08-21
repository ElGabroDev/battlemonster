/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameengine3;

import battle.Battle;
import monster.BaseMonster;
import monster.FireMonster;
import monster.WaterMonster;
import move.BaseMove;
import move.DamageMove;
import move.SpecialMove;
import utils.Element;
import utils.GameStatus;

/**
 *
 * @author elgabro
 */
public class GameEngine3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Credo due mostri per la battaglia, assegno nome, hp, velocità, atk, def
        BaseMonster squirtle = new WaterMonster("Squirtle", 100, 22, 12, 10);
        BaseMonster charmander = new FireMonster("Charmander", 100, 22, 10, 12);
        
        //Creo delle mosse, sfrutto il polimorfismo
        BaseMove fuocoBase = new DamageMove("Fire", "Una mossa di fuoco base", 5, Element.FIRE);
        BaseMove acquaBase = new DamageMove("Acqua", "Una mossa di acqua base", 5, Element.WATER);
        BaseMove atkUp = new SpecialMove("Danzaspada", "Aumenta l'attacco", "atk", 20, true);
        
        //Creo i Moveset conun metodo di assegnazione veloce
        squirtle.fastMoveset(acquaBase, acquaBase, acquaBase, acquaBase);
        charmander.fastMoveset(fuocoBase, atkUp, fuocoBase, fuocoBase);
        
        //Creo la battaglia
        Battle stage = new Battle(charmander, squirtle);
        
        //Do inizio al ciclo di battaglia
        
        /*
        Importante: La condizione di battaglia è attualmente settata alla FINE dei turni dei mostri che combattono.
        Il check va fatto alla fine di ogni mossa su entrambi i contendenti, anche dopo l'applicazione degli effetti perché
        uno dei due potrebbe andare a 0 o meno hp. Il gameStatus iniziale è settato su START, ma passa subito a CONTINUE a meno
        di errori di runtime per la creazione dell'oggetto Battle. Quando uno dei due Mostri arriva a 0 o meno hp, il 
        gameStatus va in GAMEOVER.
        */
        while(stage.getGameStatus() == GameStatus.CONTINUE){
            stage.makeRound();
        }
        
        
        
        
    }
    
}
