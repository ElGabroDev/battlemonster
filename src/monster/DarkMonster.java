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
public class DarkMonster extends BaseMonster {

    private Element element;

    public DarkMonster(String name, int hp, int vel, int atk, int def) {
        super(name, hp, vel, atk, def);
        element = Element.DARK;
    }

    @Override
    public Element getWeakness() {
        return Element.LIGHT;
    }

    @Override
    public Element getResistance() {
        return Element.DARK;
    }

}
