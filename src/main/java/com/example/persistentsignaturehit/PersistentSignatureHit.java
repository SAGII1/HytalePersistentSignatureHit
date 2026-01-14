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
        System.out.println("[PersistentSignatureHit] Setup starting...");

        // Register the system
        try {
            getEntityStoreRegistry().registerSystem(new SlotSwitchEventSystem());

            // Register command
            // Assuming getCommandManager() or similar exists.
            // this.getCommandRegistry().registerCommand(new StrackStatCommand());
            System.out.println("[PersistentSignatureHit] System registered!");
        } catch (Exception e) {
            System.err.println("[PersistentSignatureHit] Failed to register system: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
