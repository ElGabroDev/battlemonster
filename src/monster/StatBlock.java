/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monster;

import java.util.HashMap;

/**
 *
 * @author elgabro
 */
public class StatBlock {
    private HashMap<String, Integer> stats = new HashMap<String, Integer>();
    private HashMap<String, Integer> maxStats = new HashMap<String, Integer>();
    
    public StatBlock(int hp, int vel, int atk, int def){
        this.maxStats.put("hp", hp);
        this.maxStats.put("vel", vel);
        this.maxStats.put("atk", atk);
        this.maxStats.put("def", def);
        
        for(String i : this.maxStats.keySet()){
            this.stats.put(i, this.maxStats.get(i));
        }
    }
    
    public int getStat(String name){
        return this.stats.get(name);
    }
    
    public int getMaxStat(String name){
        return this.maxStats.get(name);
    }
    
    public void setStat(String name, int val){
        this.stats.put(name, val);
    }
    
    public void setMaxStat(String name, int val){
        this.maxStats.put(name, val);
    }
}
