package videogame;

public abstract class Entity {
	
	protected String name;
	protected int lifePoints = 0;

	public Entity(String name, int lifePoints) {
		assert(lifePoints >= 0);
		this.name = name;
		this.lifePoints = lifePoints;
	}

	public final boolean isAlive() {
		return lifePoints > 0;
	}
	
	public final int applySpell(SpellCaster spellCaster) {
		return propagateDamage(spellCaster.getStrength());
	}
	
	protected int propagateDamage(int damageAmount) {
		assert damageAmount >= 0;
		if (damageAmount > lifePoints) {
			lifePoints = 0;
			return damageAmount - lifePoints;
		} else {
			lifePoints -= damageAmount;
			return damageAmount;
		}
	}

	public abstract int minimumStrikeToDestroy();

	@Override
	public String toString() {
		return name + "(" + lifePoints + ")";
	}
}
