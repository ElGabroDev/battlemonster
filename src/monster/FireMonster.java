/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import utils.Element;

/**
 *
 * @author elgabro
 */
public class FireMonster extends BaseMonster {

    

    public FireMonster(String name, int hp, int vel, int atk, int def) {
        super(name, hp, vel, atk, def);
        this.element = Element.FIRE;
    }

    @Override
    public Element getWeakness() {
        return Element.WATER;
    }

    @Override
    public Element getResistance() {
        return Element.GRASS;
    }

}
