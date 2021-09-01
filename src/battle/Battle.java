/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battle;

import mechanics.MoveSelect;
import mechanics.Turn;
import monster.BaseMonster;
import utils.GameStatus;
import utils.RNG;
import utils.Status;

/**
 *
 * @author elgabro
 */
public class Battle {

    /*
    Per ora turn non ha funzione. La battaglia funziona così: Vengono richieste le mosse da selezionare prima per il 
    nostro Mostro poi, temporaneamente in assenza di AI, quella dell'avversario. A questo punto viene valutato il mostro con
    la velocità più alta. Attacker e Defender sono due nomi come convenzione. Attacker è chi attacca, e defender chi difende. Per
    passare l'attacco da un mostro all'altro uso un metodo changeAttackerDefender, quindi attacker è SEMPRE considerato il mostro che 
    attacca. Il gameStatus parte da START per eventuali implementazioni future, ma passa quasi subito a CONTINUE.
    
    La battaglia utilizza motli metodi statici divisi in altre classi, per gestire in maniera ottimale le meccaniche di gioco.
     */
    private int turn;
    private BaseMonster attacker;
    private BaseMonster defender;
    private GameStatus gameStatus = GameStatus.START;

    public Battle(BaseMonster attacker, BaseMonster defender) {
        this.attacker = attacker;
        this.defender = defender;
        this.gameStatus = GameStatus.CONTINUE;
    }

    public BaseMonster getAttacker() {
        return attacker;
    }

    public void setAttacker(BaseMonster attacker) {
        this.attacker = attacker;
    }

    public BaseMonster getDefender() {
        return defender;
    }

    public void setDefender(BaseMonster defender) {
        this.defender = defender;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    
    /**
     * Esegue un round completo per entrambi i mostri.
     * Vengono selezionati da terminale due numeri interi tramite il metodo statico 
     * select() della classe MoveSelect. Viene quindi controllate quindi le velocità per decidere
     * quale sarà il mostro ad effettuare il primo attacco. selection1 fa riferimento alla NOSTRA selezione
     * mentre selection2 a quella dell'avversario. Nel primo caso siamo noi ad effettuare per primi la mossa, 
     * nel secondo caso viene cambiato l'attaccante con il difensore, per poi eseguire la mossa. Entrambe vengono
     * eseguite col metodo makeMove() di questa stessa classe.
     */
    public void makeRound() {

        int selection1, selection2;

        this.attacker.promptStats();
        System.out.println("------------------------------");
        this.defender.promptStats();

        System.out.println("------------------------------");

        System.out.println("Cosa devo fare?");
        selection1 = MoveSelect.select();
        System.out.println("Cosa deve fare l'avversario?");
        selection2 = MoveSelect.select();

        if (checkSpeed() == this.attacker) {
            makeMove(selection1, selection2);
        } else {
            changeAttackerDefender();
            makeMove(selection2, selection1);
        }

    }

    /**
     * Valuta il mostro con la velocità più alta. Viene prima preso in esame il caso in cui le velocità siano uguali. Viene 
     * quindi utilizzato un numero random (1-10) per determinare casualmente l'ordine. Questo metodo serve per la valutazione 
     * della velocità durante il round.
     * 
     */
    public BaseMonster checkSpeed() {

        

        if (this.attacker.getStats().getStat("vel") >= this.defender.getStats().getStat("vel")) {
            return this.attacker;
        } else {
            return this.defender;
        }
        
        
    }

    /**
     * Scambia l'attaccante con il difensore della battaglia.
     */
    public void changeAttackerDefender() {
        BaseMonster temp;
        temp = this.attacker;
        this.attacker = this.defender;
        this.defender = temp;
    }

    /**
     * Esegue il turno di utilizzo delle mosse selezionate, inoltre controlla lo stato della battaglia. Vengono utilizzati due numeri
     * interi (0-3) per selezionare la mossa da quelle associate al mostro, questo numero viene passato insieme al contesto della battaglia
     * alla classe Turn nel metodo makeTurn(Battle battle, int selection). 
     * 
     * @param a 
     * @param b
     */
    public void makeMove(int a, int b) {
        System.out.println("Attacco di " + this.attacker.getName());
        System.out.println(this.attacker.getName() + " usa " + this.attacker.getMoves()[a].getName());
        Turn.makeTurn(this, a);
        updateBattle();
        changeAttackerDefender();
        System.out.println("Attacco di " + this.attacker.getName());
        System.out.println(this.attacker.getName() + " usa " + this.attacker.getMoves()[b].getName());
        Turn.makeTurn(this, b);
        updateBattle();
    }

    /**
     * Controlla lo stato della salute dei mostri e della partita.
     */
    public void updateBattle() {
        updateMonster();
        updateGameStatus();
    }

    /**
     * Invoca i metodi di attaccante e difensore per il controllo degli HP, i punti ferita. Come si vede nel metodo 
     * relativo alla classe BaseMonster, checkHP cambia lo stato del mostro a DEAD se questo ha 0 o meno hp.
     */
    public void updateMonster() {
        this.attacker.checkHp();
        this.defender.checkHp();
    }

    /**
     * Controlla lo stato dell'attaccante e del difensore. Se uno dei due è DEAD allora viene invocato il proclaimWinner. 
     * L'attaccante viene valutato prima del difensore per decisione di sviluppo, infatti in un gioco RPG classico, non esiste
     * il pareggio in battaglia, ma in generale l'incontro viene considerato perso se il protagonista arriva a 0 hp.
     */
    public void updateGameStatus() {
        if (this.attacker.getStatus() == Status.DEAD) {
            proclaimWinner(this.defender, this.attacker);
        }

        if (this.defender.getStatus() == Status.DEAD) {
            proclaimWinner(this.attacker, this.defender);
        }

    }

    /**
     * Viene proclamato lo sconfitto ed il vincitore, il gameStatus viene settato a GAMEOVER.
     * 
     * @param winner
     * @param loser
     */
    public void proclaimWinner(BaseMonster winner, BaseMonster loser) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(loser.getName() + " non è più in grado di combattere");
        System.out.println(winner.getName() + " vince l'incontro!!!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        this.gameStatus = GameStatus.GAMEOVER;
    }
}
