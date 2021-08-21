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
public class LightMonster extends BaseMonster {

    private Element element;

    public LightMonster(String name, int hp, int vel, int atk, int def) {
        super(name, hp, vel, atk, def);
        element = Element.LIGHT;
    }

    @Override
    public Element getWeakness() {
        return Element.DARK;
    }

    @Override
    public Element getResistance() {
        return Element.LIGHT;
    }

}