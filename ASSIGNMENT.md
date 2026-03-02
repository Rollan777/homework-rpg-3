# Homework 3: Detailed Assignment Instructions

## Background Story
The studio has heroes (HW1) and enemies (HW2). Now they need a battle engine to run fights. The problem is that hero and enemy APIs are different, and the game must still be easy to maintain.

Your job: **Use Singleton and Adapter patterns to integrate gameplay.**

---

## Part 1: Singleton Pattern — Global Battle Engine

### The Problem
You must ensure there is exactly one battle engine running the game logic.

### Your Tasks
1. Create `BattleEngine` as a Singleton.
2. Provide `getInstance()` access.
3. Hide the constructor.
4. Add a method to set a deterministic random seed.
5. Add a method to run an encounter.

### Required Methods
- `public static BattleEngine getInstance()`
- `public BattleEngine setRandomSeed(long seed)`
- `public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB)`
- `public void reset()`

### Questions to Guide You
- Why does the game need a single engine instance?
- What breaks if multiple engines exist?
- How can you prevent direct construction?

---

## Part 2: Adapter Pattern — Unify Incompatible APIs

### The Problem
Heroes and enemies expose different method names and behaviors. The battle engine must work with a single interface.

### Your Tasks
1. Define a `Combatant` interface with methods: `getName()`, `getAttackPower()`, `takeDamage(int)`, `isAlive()`.
2. Create `HeroCombatantAdapter` that wraps a `Hero`.
3. Create `EnemyCombatantAdapter` that wraps an `Enemy`.
4. Ensure the adapters translate methods correctly.

### Example API Mismatch
- Hero uses `getPower()` and `receiveDamage()`.
- Enemy uses `getDamage()` and `applyDamage()`.

### Questions to Guide You
- Why not just change Hero and Enemy to match?
- How does Adapter preserve existing code?

---

## Part 3: Gameplay Integration

### Requirements
1. Create a round-based fight between two teams.
2. Each round, Team A attacks Team B in order.
3. Each round, Team B attacks Team A in order.
4. When a combatant dies, remove it from the fight.
5. End when one team has 0 living combatants.

### Output Requirements
Your `Main.java` should demonstrate:
- Singleton behavior (same instance twice).
- Adapter behavior (heroes and enemies both fight).
- A full battle simulation and summary.

---

## Part 4: UML Diagrams

Create two UML diagrams.

1. Singleton Diagram
Show `BattleEngine` with a private constructor and static instance.

2. Adapter Diagram
Show `Combatant`, adapters, `Hero`, `Enemy`, and the dependency from `BattleEngine` to `Combatant`.

---

## Part 5: Demonstration Checklist
- Main demo compiles and runs.
- Battle output is readable and consistent.
- No direct `BattleEngine` dependency on Hero or Enemy classes.

---

## Grading Rubric (Total: 15 points)

### Singleton Pattern (6 points)
- Correct Singleton implementation: 2 pts.
- Access through `getInstance()` only: 2 pts.
- Engine used meaningfully in demo: 2 pts.

### Adapter Pattern (6 points)
- `Combatant` interface correctness: 2 pts.
- `HeroCombatantAdapter` correct mapping: 2 pts.
- `EnemyCombatantAdapter` correct mapping: 2 pts.

### Integration and UML (3 points)
- Battle simulation works end-to-end: 1 pt.
- UML diagrams correct and clear: 1 pt.
- Clean separation between engine and concrete types: 1 pt.

---

## Common Pitfalls to Avoid
- Exposing a public constructor in the Singleton.
- Returning a new `BattleEngine` instance from `getInstance()`.
- Letting `BattleEngine` call Hero or Enemy methods directly.
- Not removing dead combatants from the battle.

---

## Academic Integrity
You may discuss ideas and read references, but you must implement your own code. The goal is to understand why these patterns exist.
