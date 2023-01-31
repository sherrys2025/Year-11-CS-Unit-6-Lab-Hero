import java.util.*;
public class Hero {
    private String name;
    public int hitPoints;

    public Hero(String name){
        this.name = name;
        hitPoints = 100;
    }

    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return ("Hero{name='"+name+"', hitPoints=" + hitPoints + "}");
    }

    public void attack(Hero opponent){
        double prob = Math.random();
        if (prob < 0.5)
            opponent.hitPoints -= 10;
        else
            hitPoints -= 10;
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while (this.hitPoints > 0 && opponent.hitPoints > 0){
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return (name + ": "+ hitPoints + "\t"+ opponent.getName() + ": "+ opponent.getHitPoints());
    }

    private void nFightsToTheDeathHelper(Hero opponent, int n){

    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int hero =0;
        for (int i = 0; i<n; i++){
            senzuBean();
            opponent.senzuBean();
            fightUntilTheDeathHelper(opponent);
            if (this.hitPoints > 0)
                hero++;

        }
        int opp = n-hero;
        if(hero < opp)
            return (this.name + ": " + hero + " wins\n"+opponent.getName() + ": " + opp + "wins\n" + opponent.getName() + "wins!");
        else if (hero > opp) {
            return (this.name + ": " + hero + " wins\n"+opponent.getName() + ": " + opp + "wins\n" + name + "wins!");
        }
        else
            return (this.name + ": " + hero + " wins\n"+opponent.getName() + ": " + opp + "wins\nOMG! It was actually a draw!");
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        senzuBean();
        opponent.senzuBean();
        while (this.hitPoints > 0 && opponent.getHitPoints() > 0){
            Thread.sleep(1000);
            attack(opponent);
            System.out.println(name + ": "+ hitPoints + "\t"+ opponent.getName() + ": "+ opponent.getHitPoints() + "\n");
        }


        if(this.hitPoints < opponent.getHitPoints())
            System.out.println(opponent.getName()+" wins!");
        else if (this.hitPoints > opponent.getHitPoints()) {
            System.out.println(name+" wins!");
        }
        else
            System.out.println("OMG! It was actually a draw!");
    }

}
