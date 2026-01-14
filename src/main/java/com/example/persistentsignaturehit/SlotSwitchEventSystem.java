package com.example.persistentsignaturehit;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.query.Query;
import com.hypixel.hytale.component.system.EntityEventSystem;
import com.hypixel.hytale.server.core.event.events.ecs.SwitchActiveSlotEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class SlotSwitchEventSystem extends EntityEventSystem<EntityStore, SwitchActiveSlotEvent> {

    public SlotSwitchEventSystem() {
        super(SwitchActiveSlotEvent.class);
    }

    @Override
    public void handle(int i, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk,
            @Nonnull Store<EntityStore> store,
            @Nonnull CommandBuffer<EntityStore> commandBuffer,
            @Nonnull SwitchActiveSlotEvent event) {

        System.out.println("[SlotSwitch] Event received! Entity ID index: " + i);

        var ref = archetypeChunk.getReferenceTo(i);
        PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());

        if (playerRef != null) {
            SignaturePersistenceSystem.incrementStat();
            int stat = SignaturePersistenceSystem.getStat();

            System.out.println("[SlotSwitch] Player " + playerRef.toString() +
                    " switched from " + event.getPreviousSlot() +
                    " to " + event.getNewSlot() +
                    " Stat: " + stat);
            // TODO: Send chat message to player
        }
    }

    @Nullable
    @Override
    public Query<EntityStore> getQuery() {
        return PlayerRef.getComponentType();
    }
}
