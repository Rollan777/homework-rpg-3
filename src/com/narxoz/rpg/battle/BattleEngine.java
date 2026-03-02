package com.narxoz.rpg.battle;

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
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
        if (teamA == null || teamB == null) {
            throw new IllegalArgumentException("Teams must not be null");
        }
        if (teamA.isEmpty() || teamB.isEmpty()) {
            throw new IllegalArgumentException("Teams must not be empty");
        }
        teamA.removeIf(c -> c == null);
        teamB.removeIf(c -> c == null);

        if (teamA.isEmpty() || teamB.isEmpty()) {
            throw new IllegalArgumentException("Teams must contain at least 1 combatant");
        }

        EncounterResult result = new EncounterResult();
        result.addLog("Battle started!");
        result.addLog("Team A size: " + teamA.size() + ", Team B size: " + teamB.size());

        int rounds = 0;
        int maxRounds = 100;

        while (!teamA.isEmpty() && !teamB.isEmpty() && rounds < maxRounds) {
            rounds++;
            result.addLog("\n--- Round " + rounds + " ---");

            doTeamTurn("A", teamA, "B", teamB, result);
            teamA.removeIf(c -> !c.isAlive());
            teamB.removeIf(c -> !c.isAlive());

            if (teamB.isEmpty()) {
                break;
            }

            doTeamTurn("B", teamB, "A", teamA, result);
            teamA.removeIf(c -> !c.isAlive());
            teamB.removeIf(c -> !c.isAlive());
        }

        result.setRounds(rounds);

        if (!teamA.isEmpty() && teamB.isEmpty()) {
            result.setWinner("Team A");
            result.addLog("\nBattle finished: Team A wins!");
        } else if (!teamB.isEmpty() && teamA.isEmpty()) {
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

        for (int i = 0; i < attackers.size(); i++) {
            Combatant attacker = attackers.get(i);
            if (attacker == null || !attacker.isAlive()) {
                continue;
            }

            if (defenders.isEmpty()) {
                return;
            }

            Combatant target = pickRandomTarget(defenders);

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

    private Combatant pickRandomTarget(List<Combatant> defenders) {
        int idx = random.nextInt(defenders.size());
        Combatant target = defenders.get(idx);

        if (target != null && target.isAlive()) {
            return target;
        }

        for (Combatant c : defenders) {
            if (c != null && c.isAlive()) return c;
        }

        return defenders.get(0);
    }
}