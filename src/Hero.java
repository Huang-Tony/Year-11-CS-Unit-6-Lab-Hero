public class Hero {
    private String name;
    private int hitPoints;
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
        return String.format("Hero{name='%1$s', hitPoints=%2$d}", this.name,this.hitPoints);
    }
    public void attack(Hero opponent){
        if(Math.random() < 0.5){
            opponent.hitPoints -=10;
        }else{
            hitPoints -=10;
        }
    }
    public void senzuBean(){
        hitPoints = 100;
    }
    public void fightUntilTheDeathHelper(Hero opponent){
        for(int i = 0; i < 100000; i ++){
            attack(opponent);
            if(opponent.getHitPoints() < 1 || this.hitPoints < 1){
                break;
            }
        }
    }
    public String fightUntilTheDeath(Hero opponent) {
        this.senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);

        return this.name + ": " + this.hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints();
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] wins = {0, 0};
        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);

            if (this.hitPoints > 0) {
                wins[0]++;
            } else {
                wins[1]++;
            }

            this.senzuBean();
            opponent.senzuBean();
        }

        return wins;
    }

    String nFightsToTheDeath(Hero opponent, int n) {
        int[] wins = nFightsToTheDeathHelper(opponent, n);

        String finalMessage;
        if (wins[0] == wins[1]) {
            finalMessage = "OMG! It was actually a draw!";
        } else if (wins[0] > wins[1]) {
            finalMessage = this.name + " wins!";
        } else {
            finalMessage = opponent.getName() + " wins!";
        }

        return this.name + ": " + wins[0] + " wins\n" + opponent.getName() + ": " + wins[1] + " wins\n" + finalMessage;
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    void dramaticFightToTheDeath(Hero opponent) {
//        this.senzuBean();
//        opponent.senzuBean();
//
//        while (true) {
//            if (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
//                this.attack(opponent);
//                this.waitOneSecond();
//                System.out.println(this.name + ": " + this.hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
//            } else {
//                break;
//            }
//
//            if (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
//                opponent.attack(this);
//                this.waitOneSecond();
//                System.out.println(this.name + ": " + this.hitPoints + "\t" + opponent.getName() + ": " + opponent.getHitPoints());
//            } else {
//                break;
//            }
//        }
//
//        if (this.hitPoints > 0) {
//            System.out.println(this.name + " wins!");
//        } else {
//            System.out.println(opponent.getName() + " wins!");
//        }
//
//        this.senzuBean();
//        opponent.senzuBean();
//    }
}
