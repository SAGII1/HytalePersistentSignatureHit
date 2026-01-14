package com.example.persistentsignaturehit;

import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;

public class PersistentSignatureHit extends JavaPlugin {

    public PersistentSignatureHit(JavaPluginInit init) {
        super(init);
    }

    public void onEnable() {
        System.out.println("Hello Hytale! PersistentSignatureHit mod setup complete.");
    }

    public void onDisable() {
    }
}
