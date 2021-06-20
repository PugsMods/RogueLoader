package com.pugzarecute.rougeloaderspigot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class RougeloaderSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            Bukkit.getServer().getPluginManager().loadPlugin(new File("essx.jar"));
        } catch (InvalidPluginException e) {
            e.printStackTrace();
        } catch (InvalidDescriptionException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
