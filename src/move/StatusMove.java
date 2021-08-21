/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package move;

import battle.Battle;
import utils.Status;
import utils.StatusEffect;

/**
 *
 * @author elgabro
 */
public class StatusMove extends BaseMove{

    private StatusEffect statusEffect;
    
    public StatusMove(String name, String description, StatusEffect statusEffect){
        super(name, description);
        this.statusEffect = statusEffect;
    }
    
    @Override
    public void activate(Battle battle) {
        battle.getDefender().setStatus(this.statusEffect.getStatus());
    }
    
}
