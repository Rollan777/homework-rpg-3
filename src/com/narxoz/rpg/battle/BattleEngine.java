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
        // TODO: reset any battle state if you add it
    }

    public EncounterResult runEncounter(List<Combatant> teamA, List<Combatant> teamB) {
        // TODO: validate inputs and run round-based battle
        // TODO: use random if you add critical hits or target selection
        EncounterResult result = new EncounterResult();
        result.setWinner("TBD");
        result.setRounds(0);
        result.addLog("TODO: implement battle simulation");
        return result;
    }
}
