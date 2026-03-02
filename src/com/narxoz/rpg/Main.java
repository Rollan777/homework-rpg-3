package com.narxoz.rpg;

import com.narxoz.rpg.adapter.EnemyCombatantAdapter;
import com.narxoz.rpg.adapter.HeroCombatantAdapter;
import com.narxoz.rpg.battle.BattleEngine;
import com.narxoz.rpg.battle.Combatant;
import com.narxoz.rpg.battle.EncounterResult;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.hero.Mage;
import com.narxoz.rpg.hero.Warrior;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Battle Engine Demo ===\n");

        // Heroes / Enemies (как в прошлых дз, просто создаём)
        Warrior warrior = new Warrior("Arthas");
        Mage mage = new Mage("Jaina");
        Goblin goblin = new Goblin();

        // Wrap into Combatant via adapters
        List<Combatant> heroes = new ArrayList<>();
        heroes.add(new HeroCombatantAdapter(warrior));
        heroes.add(new HeroCombatantAdapter(mage));

        List<Combatant> enemies = new ArrayList<>();
        enemies.add(new EnemyCombatantAdapter(goblin));

        System.out.println("Team A (Heroes):");
        for (Combatant c : heroes) {
            System.out.println("- " + c.getName() + " (ATK=" + c.getAttackPower() + ")");
        }

        System.out.println("\nTeam B (Enemies):");
        for (Combatant c : enemies) {
            System.out.println("- " + c.getName() + " (ATK=" + c.getAttackPower() + ")");
        }

        // Singleton check
        BattleEngine engineA = BattleEngine.getInstance();
        BattleEngine engineB = BattleEngine.getInstance();
        System.out.println("\nSingleton check: " + (engineA == engineB));
        System.out.println();

        // Run battle
        engineA.setRandomSeed(42L);
        EncounterResult result = engineA.runEncounter(heroes, enemies);

        System.out.println("\n=== Result ===");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());

        System.out.println("\n=== Battle Log ===");
        for (String line : result.getBattleLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}