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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    // Reduce the fighter's stamina accordingly
    public void takeDamage(int damage) {
        this.stamina -= damage;
    }

    // Return the number of damage points to be inflicted on opponent
    public int calculateDamage(Fighter opponent) {
        return opponent.stamina == 1 ? 1 : 2;
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


public class Practice7ec8 {
    public static void main(String[] args) {
        Fighter joe = new Fighter("Joe", "Human Warrior", 16, 12);
        Fighter alex = new Fighter("Alex", "Elf Lord", 18, 6);
        System.out.println("At the start of the battle, stats are:");
        System.out.println(String.format("%s - %s - skill: %d; stamina: %d", joe.getName(), joe.getType(), joe.getSkill(), joe.getStamina()));
        System.out.println(String.format("%s - %s - skill: %d; stamina: %d", alex.getName(), alex.getType(), alex.getSkill(), alex.getStamina()));
        System.out.println("------------------------------");
        while (simulateBattle(joe, alex)) {
            System.out.println("------------------------------");
        }
    }

    public static boolean simulateBattle(Fighter first, Fighter second) {
        if (first.isDead() || second.isDead()) {
            Fighter winner = first.isDead() ? second : first;
            System.out.println(String.format("End of battle, %s - %s - skill: %d; stamina: %d wins!", winner.getName(), winner.getType(), winner.getSkill(), winner.getStamina()));
            return false;
        }

        int firstAttack = first.calculateAttackScore();
        int secondAttack = second.calculateAttackScore();
        boolean isFirst = firstAttack > secondAttack;
        Fighter attacker = isFirst ? first : second;
        Fighter attacked = !isFirst ? second : first;
        if (firstAttack == secondAttack) {
            System.out.println(String.format("%s draws with %s", first.getName(), second.getName()));
        } else {
            attacked.takeDamage(attacker.calculateDamage(attacked));
            System.out.println(String.format("%s hits %s, stats are:", attacker.getName(), attacked.getName()));
            System.out.println(String.format("%s - %s - skill: %d; stamina: %d", first.getName(), first.getType(), first.getSkill(), first.getStamina()));
            System.out.println(String.format("%s - %s - skill: %d; stamina: %d", second.getName(), second.getType(), second.getSkill(), second.getStamina()));
        }

        return true;
    }
}