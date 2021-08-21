/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package move;

import battle.Battle;
import utils.Element;
import utils.RNG;

/**
 *
 * @author elgabro
 */
public class DamageMove extends BaseMove {

    private int damage;
    private Element element;

    public DamageMove(String name, String description, int damage, Element element) {
        super(name, description);
        this.damage = damage;
        this.element = element;

    }

    @Override
    public void activate(Battle battle) {
        int baseAttack = battle.getAttacker().getStats().getStat("atk");
        int baseDefense = battle.getDefender().getStats().getStat("def");
        int currentHp = battle.getDefender().getStats().getStat("hp");

        stab(battle);
        int roll = RNG.Roll10();
        int total = baseAttack + roll + this.damage;

        // Inizio il calcolo del danno
        if (battle.getDefender().getWeakness() == this.element) {
            System.out.println("Super efficace");
            total *= 2;
        }
        if (battle.getDefender().getResistance() == this.element) {
            System.out.println("Non molto efficace");
            total /= 2;
        }
        total = (int) Math.ceil(total);

        total = total - baseDefense;

        // Controllo che il totale non faccia recuperare HP all'avversario
        if (total <= 0) {
            total = 1;
        }

        battle.getDefender().getStats().setStat("hp", currentHp - total);

    }

    private void stab(Battle battle) {
        if (battle.getAttacker().getElement() == this.element) {
            this.damage += (int) Math.ceil(this.damage / 2);
        }
    }
}
