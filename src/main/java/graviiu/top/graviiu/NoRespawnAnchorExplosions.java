package graviiu.top.graviiu;

import org.bukkit.plugin.java.JavaPlugin;

public final class NoRespawnAnchorExplosions extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getLogger().info("NoRespawnAnchorExplosions Enabled!");

        getServer().getPluginManager().registerEvents(new NoRespawnAnchorExplosionsEvent(), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("NoRespawnAnchorExplosions Disabled!");


    }
}
