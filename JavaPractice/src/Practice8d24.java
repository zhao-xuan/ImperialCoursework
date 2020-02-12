import java.util.Random;

class Fighter {
    String name;
    String type;
    int skill;
    int stamina;

    public Fighter(String name, String type, int skill, int stamina) {
        assert (skill >= 1 && skill <= 18);
        assert (stamina >= 1 && stamina <= 24);

        this.name = name;
        this.type = type;
        this.skill = skill;
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // Calculate an attack score for the fighter using the procedure described above
    public int calculateAttackScore() {
        Random dice = new Random();
        return this.skill + dice.nextInt(5) + dice.nextInt(5) + 2;
    }

    // Determine whether fighter is still alive
    public boolean isDead() {
        return this.stamina == 0;
    }
}

class LuckyFighter extends Fighter {
    String strategy;
    int luck;
    public LuckyFighter(String name, String type, String strategy, int skill, int stamina, int luck) {
        super(name, type, skill, stamina);
        assert (luck >= 1 && luck <= 18);
        assert (strategy.equals("Aggressive") || strategy.equals("Defensive") || strategy.equals("Average"));

        this.strategy = strategy;
        this.luck = luck;
    }

    // Return the number of damage points to be inflicted on opponent
    public int calculateDamage(Fighter opponent) {
        int finalDamage = 2;
        boolean isUsingLuckToAttack = new Random().nextInt(10) > (strategy.equals("Aggressive") ? 3 : 7);
        if (strategy.equals("Average")) {isUsingLuckToAttack = this.luck >= 12 ? true : false;}
        
        if (isUsingLuckToAttack) {
            int sumOfDices = new Random().nextInt(5) + new Random().nextInt(5) + 2;
            System.out.println(String.format("%s goes for an aggressive hit...", this.getName()));
            System.out.println(String.format("%s tests luck...", this.getName()));
            if (sumOfDices <= this.luck) {
                System.out.println(String.format("%s is lucky!", this.getName()));
                System.out.println("The hit is aggressive!");
                finalDamage *= 2;
            } else {
                System.out.println(String.format("%s is unlucky!", this.getName()));
                System.out.println("The hit is reduced by one!");
                finalDamage--;
            }
            this.luck--;
        }
    
        return opponent.stamina == 1 ? 1 : finalDamage;
    }

    // Reduce the fighter's stamina accordingly
    public void takeDamage(int damage) {
        int finalDamage = 2;
        boolean isUsingLuckToDefend = new Random().nextInt(10) > (strategy.equals("Defensive") ? 3 : 7);
        if (strategy.equals("Average")) {isUsingLuckToDefend = this.luck >= 12 ? (new Random().nextInt(10) > 6) : false;}
        if (damage > 2) { isUsingLuckToDefend = true; }

        if (isUsingLuckToDefend) {
            int sumOfDices = new Random().nextInt(5) + new Random().nextInt(5) + 2;
            System.out.println(String.format("%s tries to resist the damage...", this.getName()));
            System.out.println(String.format("%s tests luck...", this.getName()));
            if (sumOfDices <= this.luck) {
                System.out.println(String.format("%s is lucky!", this.getName()));
                System.out.println("The damage is partially resisted!");
                finalDamage--;
            } else {
                System.out.println(String.format("%s is unlucky!", this.getName()));
                System.out.println("The damage is increased!");
                finalDamage++;
            }
            this.luck--;
        }

        this.stamina = this.stamina - finalDamage < 0 ? 0 : this.stamina - finalDamage;
    }

    public String getType() {
        return strategy + " " + type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLuck() {
        return luck;
    }
}

public class Practice8d24 {
    public static void main(String[] args) {
        LuckyFighter joe = new LuckyFighter("Joe", "Human Warrior", "Aggressive", 16, 12, 12);
        LuckyFighter alex = new LuckyFighter("Alex", "Elf Lord", "Defensive", 18, 6, 11);
        System.out.println("At the start of the battle, stats are:");
        System.out.println(String.format("%s - %s - skill: %d; stamina: %d; luck: %d", joe.getName(), joe.getType(), joe.getSkill(), joe.getStamina(), joe.getLuck()));
        System.out.println(String.format("%s - %s - skill: %d; stamina: %d; luck: %d", alex.getName(), alex.getType(), alex.getSkill(), alex.getStamina(), alex.getLuck()));
        System.out.println("------------------------------");
        while (simulateBattle(joe, alex)) {
            System.out.println("------------------------------");
        }
    }

    public static boolean simulateBattle(LuckyFighter first, LuckyFighter second) {
        if (first.isDead() || second.isDead()) {
            LuckyFighter winner = first.isDead() ? second : first;
            System.out.println(String.format("End of battle, %s - %s - skill: %d; stamina: %d wins!", winner.getName(), winner.getType(), winner.getSkill(), winner.getStamina()));
            return false;
        }

        int firstAttack = first.calculateAttackScore();
        int secondAttack = second.calculateAttackScore();
        boolean isFirst = firstAttack > secondAttack;
        LuckyFighter attacker = isFirst ? first : second;
        LuckyFighter attacked = isFirst ? second : first;
        if (firstAttack == secondAttack) {
            System.out.println(String.format("%s draws with %s", first.getName(), second.getName()));
        } else {
            attacked.takeDamage(attacker.calculateDamage(attacked));
            System.out.println(String.format("%s hits %s, stats are:", attacker.getName(), attacked.getName()));
            System.out.println(String.format("%s - %s - skill: %d; stamina: %d; luck: %d", first.getName(), first.getType(), first.getSkill(), first.getStamina(), first.getLuck()));
            System.out.println(String.format("%s - %s - skill: %d; stamina: %d; luck: %d", second.getName(), second.getType(), second.getSkill(), second.getStamina(), second.getLuck()));
        }

        return true;
    }
}