# Singleton Hints

## Goal
Ensure only one `BattleEngine` instance exists.

## Checklist
- Private constructor
- Static instance field
- Public `getInstance()`

## Sample Skeleton
```java
public final class BattleEngine {
    private static BattleEngine instance;

    private BattleEngine() {
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }
}
```

## Common Mistakes
- Public constructor
- `getInstance()` returning a new object each time
- Storing game state in multiple places
