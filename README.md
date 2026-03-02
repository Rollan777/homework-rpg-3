# Homework 3: RPG Battle Engine — Singleton + Adapter

## Overview
You now have heroes (HW1) and enemies (HW2). The studio wants a **battle engine** that can run fights between them. The problem is that heroes and enemies expose different APIs, and the game must still be clean and extensible.

Your mission: **use Singleton and Adapter patterns** to integrate gameplay.

## What You Will Build
- A global battle engine (Singleton)
- A unified combat interface (Adapter)
- A demo that runs a battle between heroes and enemies

## Patterns and Roles
- **Singleton**: `BattleEngine` is the single coordinator of battles
- **Adapter**: `HeroCombatantAdapter` and `EnemyCombatantAdapter` translate different APIs into a shared `Combatant` interface

## Connection to Previous Homework
- **HW1** created heroes with Factory patterns
- **HW2** created enemies with Builder + Prototype
- **HW3** makes them fight using Singleton + Adapter

## Requirements at a Glance
- Implement a Singleton battle engine
- Implement Adapter classes to wrap heroes and enemies
- Create a round-based battle simulation
- Demonstrate everything in `Main.java`
- Provide UML diagrams for Singleton and Adapter

## Running the Project
```bash
# Compile
javac -d out $(find src -name "*.java")

# Run
java -cp out com.narxoz.rpg.Main
```

## Project Structure
```
homework_rpg_3/
├── src/
│   └── com/
│       └── narxoz/
│           └── rpg/
│               ├── Main.java
│               ├── battle/
│               ├── adapter/
│               ├── hero/
│               ├── enemy/
│               └── hints/
├── ASSIGNMENT.md
├── QUICKSTART.md
├── FAQ.md
├── STUDENT_CHECKLIST.md
└── README.md
```

## Deliverables
- Completed Java code
- UML diagrams (2)
- Clear demo output

Good luck. Keep the architecture clean and your patterns explicit.
