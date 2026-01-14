package com.example.persistentsignaturehit;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

public class PersistentSignatureHit extends JavaPlugin {

    public PersistentSignatureHit(JavaPluginInit init) {
        super(init);
    }

    @Override
    protected void setup() {
        super.setup();
        System.out.println("[PersistentSignatureHit] Setting up slot switch event system...");

        // Register the slot switch event system
        try {
            getEntityStoreRegistry().registerSystem(new SlotSwitchEventSystem());
            System.out.println("[PersistentSignatureHit] SlotSwitchEventSystem registered successfully!");
        } catch (Exception e) {
            System.err.println("[PersistentSignatureHit] Failed to register event system: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("[PersistentSignatureHit] Setup complete");
    }
}
