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
        System.out.println("Hello Hytale! PersistentSignatureHit mod setup complete.");

    }

    public Object getEntityRegistryAccess() {
        return this.getEntityRegistry();
    }

    /*
     * public void onEnable() {
     * }
     * 
     * public void onDisable() {
     * }
     */
}
