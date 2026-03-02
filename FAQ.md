# Frequently Asked Questions (FAQ)

## General

### Q: How is this different from HW1 and HW2?
**A:** HW1 and HW2 focus on object creation. HW3 focuses on **integration** and **coordination** using Singleton and Adapter patterns.

### Q: Can I change Hero and Enemy to have the same methods?
**A:** No. The mismatch is intentional so you can practice Adapter.

### Q: Do I need to use randomness?
**A:** You can, but your engine must support deterministic output using a seed.

## Singleton

### Q: Why Singleton here?
**A:** The battle engine should be a single global coordinator to avoid conflicting game states.

### Q: What makes a correct Singleton?
**A:** Private constructor, one static instance, and a `getInstance()` method.

## Adapter

### Q: Why not just add methods to Hero and Enemy?
**A:** That would change their original APIs and defeats the purpose of Adapter. Adapter lets you integrate without rewriting old code.

### Q: Should the engine know about Hero or Enemy?
**A:** No. It should only depend on the `Combatant` interface.

## Demo

### Q: What should the demo show?
**A:** Singleton usage, adapter usage, and a full battle run with summary output.
