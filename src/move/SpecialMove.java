/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package move;

import battle.Battle;

/**
 *
 * @author elgabro
 */
public class SpecialMove extends BaseMove{

    private String stat;
    private int value;
    private boolean self;
    
    public SpecialMove(String name, String description, String stat, int value, boolean self){
        super(name, description);
        this.stat = stat;
        this.value = value;
        this.self = self;
    }
    
    @Override
    public void activate(Battle battle) {
        if(this.self){
            battle.getAttacker().getStats().setStat(this.stat, battle.getAttacker().getStats().getStat(this.stat) + value);
        }else{
            battle.getDefender().getStats().setStat(this.stat, battle.getDefender().getStats().getStat(this.stat) + value);
        }
    }
    
}
