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
public abstract class BaseMove {
    private String name;
    private String description;
    
    public BaseMove(String name, String description){
        this.name = name;
        this.description = description;
    }
    
    public abstract void activate(Battle battle);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void promptMove(){
        System.out.println(name + ", " + description);
    }
    
}
