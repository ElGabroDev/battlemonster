/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import battle.Battle;

/**
 *
 * @author elgabro
 */
public class PoisonStatus extends StatusEffect{
    
    public PoisonStatus(String name, Status status, int duration){
        super(name, status, duration);
    }
    
    @Override
    public void apply(Battle battle){
        battle.getAttacker().getStats().setStat("hp", battle.getAttacker().getStats().getStat("hp") - 2 - RNG.Roll10());
        checkStatus();
    }
}
