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
public abstract class StatusEffect {

    private String name;
    private Status status;
    private int duration;

    public StatusEffect(String name, Status status, int duration) {
        this.name = name;
        this.status = status;
        this.duration = duration;
    }

    public abstract void apply(Battle battle);

    public Status checkStatus() {

        decrementDuration();

        if (this.duration <= 0) {
            return Status.OK;
        } else {
            return this.status;
        }
    }

    public void decrementDuration() {
        this.duration--;
    }
    
    public Status getStatus(){
        return this.status;
    }
}
