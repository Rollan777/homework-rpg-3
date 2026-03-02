# Quick Start Guide

## Prerequisites
- Java 17 or higher installed

## Setup

### Verify Java Installation
```bash
java -version
javac -version
```

### Open Project in IDE
- IntelliJ IDEA: Open `homework_rpg_3` and mark `src` as Sources Root.
- VS Code: Open folder and install Java Extension Pack if needed.
- Eclipse: Create a Java project and set `src` as the source folder.

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
├── README.md
├── ASSIGNMENT.md
├── QUICKSTART.md
├── FAQ.md
└── STUDENT_CHECKLIST.md
```

## Building and Running
```bash
# Compile
javac -d out $(find src -name "*.java")

# Run
java -cp out com.narxoz.rpg.Main
```

## Development Workflow
1. Read `README.md` and `ASSIGNMENT.md`.
2. Study `SINGLETON_HINTS.md` and `ADAPTER_HINTS.md`.
3. Complete interfaces first, then adapters, then engine.
4. Run `Main.java` after each change.

## Finding TODOs
Search for `TODO` in your IDE to locate incomplete methods.

## Common Issues
- Package errors: Ensure `src` is set as Sources Root.
- Main not found: Verify `Main.java` is in `com.narxoz.rpg`.
- Compile errors: Complete missing methods and TODOs first.
