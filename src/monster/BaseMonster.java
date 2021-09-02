/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;


import move.BaseMove;
import utils.Element;
import utils.Status;

/**
 *
 * @author elgabro
 */
public abstract class BaseMonster {
    private String name;
    private StatBlock stats;
    private BaseMove[] moves = new BaseMove[4];
    private Status status;
    

    
    protected Element element;
    
    
    
    public BaseMonster(String name, int hp, int vel, int atk, int def){
        this.name = name;
        this.stats = new StatBlock(hp, vel, atk, def);
        status = Status.OK;
        
    }
    
    public abstract Element getWeakness();
    public abstract Element getResistance();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatBlock getStats() {
        return stats;
    }

    public void setStats(StatBlock stats) {
        this.stats = stats;
    }

    public BaseMove[] getMoves() {
        return moves;
    }

    public void setMoves(BaseMove[] moves) {
        this.moves = moves;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
    public Element getElement() {
        return element;
    }
    
    public void setElement(Element element){
        this.element = element;
    }

    
    
    
    public void fastMoveset(BaseMove a, BaseMove b, BaseMove c, BaseMove d){
        this.moves[0] = a;
        this.moves[1] = b;
        this.moves[2] = c;
        this.moves[3] = d;
    }
    
    public void promptStats(){
        System.out.println(name);
        System.out.println("HP-> "+ stats.getStat("hp") + "/" + stats.getMaxStat("hp"));
        System.out.println("VEL-> "+ stats.getStat("vel") + "/" + stats.getMaxStat("vel"));
        System.out.println("ATK-> "+ stats.getStat("atk") + "/" + stats.getMaxStat("atk"));
        System.out.println("DEF-> "+ stats.getStat("def") + "/" + stats.getMaxStat("def"));
        promptMoveset();
    }
    
    public void promptMoveset(){
        for(BaseMove move : moves){
            move.promptMove();
        }
    }
    
    public void checkHp(){
        this.status = this.getStats().getStat("hp") <= 0 ? Status.DEAD : this.status;
    }
    

}
