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

/**
 * Event system that handles slot switching events.
 */
public class SlotSwitchEventSystem extends EntityEventSystem<EntityStore, SwitchActiveSlotEvent> {

    protected SlotSwitchEventSystem() {
        super(SwitchActiveSlotEvent.class);
    }

    @Override
    public void handle(int i, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk,
            @Nonnull Store<EntityStore> store,
            @Nonnull CommandBuffer<EntityStore> commandBuffer,
            @Nonnull SwitchActiveSlotEvent event) {

        var ref = archetypeChunk.getReferenceTo(i);
        PlayerRef playerRef = store.getComponent(ref, PlayerRef.getComponentType());

        if (playerRef == null) {
            return;
        }

        // Log the slot switch
        System.out.println("[SlotSwitch] Player switched from slot " +
                event.getPreviousSlot() + " to slot " + event.getNewSlot());

        // TODO: Implement signature energy preservation logic here
    }

    @Nullable
    @Override
    public Query<EntityStore> getQuery() {
        return PlayerRef.getComponentType();
    }
}
