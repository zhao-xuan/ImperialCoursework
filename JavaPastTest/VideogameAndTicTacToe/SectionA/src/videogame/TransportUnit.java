package videogame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransportUnit extends Entity {
    public static final int DAMAGE_DECAY = 2;
    List<Entity> entities;

    public TransportUnit(String name, int lifePoints) {
        super(name, lifePoints);
        entities = new ArrayList<>();
    }

    public void add(Entity entity) {
        entities.add(entity);
    }

    @Override
    protected int propagateDamage(int damageAmount) {
        return super.propagateDamage(damageAmount) +
                entities.stream()
                        .map(i -> i.propagateDamage(damageAmount / DAMAGE_DECAY))
                        .reduce(Integer::sum)
                        .get();
    }

    @Override
    public int minimumStrikeToDestroy() {
        return Math.max(lifePoints,
                entities.stream().map(e -> e.minimumStrikeToDestroy() * 2).max(Integer::compareTo).get());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(super.toString() + " transporting: [");
        if (!entities.isEmpty()) {
            s.append(entities.get(0).toString());
        }
        entities.stream().skip(1).forEach(i -> s.append(", ").append(i.toString()));
        s.append("]");
        return s.toString();
    }
}