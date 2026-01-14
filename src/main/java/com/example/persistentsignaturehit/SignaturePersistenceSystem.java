package com.example.persistentsignaturehit;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

// Managing persistent stats. For now, just a simple counter in memory.
public class SignaturePersistenceSystem {

    private static int signatureStat = 0;

    public static void incrementStat() {
        signatureStat++;
    }

    public static int getStat() {
        return signatureStat;
    }
}
