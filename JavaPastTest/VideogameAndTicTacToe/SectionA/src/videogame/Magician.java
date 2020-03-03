package videogame;

public class Magician extends Entity implements SpellCaster {
    public static final int STRENTH_MULTIPLIER = 2;

    public Magician(String name, int lifePoints) {
        super(name, lifePoints);
    }

    @Override
    public int getStrength() {
        return lifePoints * STRENTH_MULTIPLIER;
    }

    @Override
    public int minimumStrikeToDestroy() {
        return lifePoints;
    }
}