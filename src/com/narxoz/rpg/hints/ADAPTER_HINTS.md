# Adapter Hints

## Goal
Unify incompatible Hero and Enemy APIs using a `Combatant` interface.

## Key Idea
Adapters translate method calls without changing the original classes.

## Example Mapping
- `Combatant.getName()` maps to Hero.getName() or Enemy.getTitle()
- `Combatant.getAttackPower()` maps to Hero.getPower() or Enemy.getDamage()
- `Combatant.takeDamage(int)` maps to Hero.receiveDamage(int) or Enemy.applyDamage(int)
- `Combatant.isAlive()` maps to Hero.isAlive() or Enemy.isDefeated()

## Sample Skeleton
```java
public class HeroCombatantAdapter implements Combatant {
    private final Hero hero;

    public HeroCombatantAdapter(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String getName() {
        return hero.getName();
    }
}
```

## Common Mistakes
- Letting `BattleEngine` call Hero or Enemy methods directly
- Returning null from adapter methods
