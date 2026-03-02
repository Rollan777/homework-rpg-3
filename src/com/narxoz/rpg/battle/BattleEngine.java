package com.narxoz.rpg.battle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class BattleEngine {
    private static BattleEngine instance;

    private Random random = new Random(1L);

    private BattleEngine() {
    }

    public static BattleEngine getInstance() {
        if (instance == null) {
            instance = new BattleEngine();
        }
        return instance;
    }

    public BattleEngine setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public void reset() {
        // пока состояния нет — оставим метод на будущее
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
        if (teamA == null || teamB == null) {
            throw new IllegalArgumentException("Teams must not be null");
        }
        if (teamA.isEmpty() || teamB.isEmpty()) {
            throw new IllegalArgumentException("Teams must not be empty");
        }

        EncounterResult result = new EncounterResult();
        result.addLog("Battle started!");
        result.addLog("Team A size: " + teamA.size() + ", Team B size: " + teamB.size());

        int rounds = 0;
        int maxRounds = 100; // защита от бесконечного боя

        while (hasAlive(teamA) && hasAlive(teamB) && rounds < maxRounds) {
            rounds++;
            result.addLog("\n--- Round " + rounds + " ---");

            doTeamTurn("A", teamA, "B", teamB, result);
            if (!hasAlive(teamB)) break;

            doTeamTurn("B", teamB, "A", teamA, result);
        }

        result.setRounds(rounds);

        if (hasAlive(teamA) && !hasAlive(teamB)) {
            result.setWinner("Team A");
            result.addLog("\nBattle finished: Team A wins!");
        } else if (hasAlive(teamB) && !hasAlive(teamA)) {
            result.setWinner("Team B");
            result.addLog("\nBattle finished: Team B wins!");
        } else {
            result.setWinner("Draw");
            result.addLog("\nBattle finished: Draw (max rounds reached)");
        }

        return result;
    }

    private void doTeamTurn(String attackersName,
                            List<Combatant> attackers,
                            String defendersName,
                            List<Combatant> defenders,
                            EncounterResult result) {

        for (Combatant attacker : attackers) {
            if (!attacker.isAlive()) continue;

            Combatant target = pickRandomAlive(defenders);
            if (target == null) {
                return;
            }

            int dmg = attacker.getAttackPower();
            if (dmg < 0) dmg = 0;

            result.addLog(attackersName + ": " + attacker.getName()
                    + " attacks " + defendersName + ": " + target.getName()
                    + " for " + dmg);

            target.takeDamage(dmg);

            if (!target.isAlive()) {
                result.addLog(defendersName + ": " + target.getName() + " is defeated!");
            }
        }
    }

    private boolean hasAlive(List<Combatant> team) {
        for (Combatant c : team) {
            if (c != null && c.isAlive()) return true;
        }
        return false;
    }

    private Combatant pickRandomAlive(List<Combatant> team) {
        List<Combatant> alive = new ArrayList<>();
        for (Combatant c : team) {
            if (c != null && c.isAlive()) alive.add(c);
        }
        if (alive.isEmpty()) return null;
        return alive.get(random.nextInt(alive.size()));
    }
}