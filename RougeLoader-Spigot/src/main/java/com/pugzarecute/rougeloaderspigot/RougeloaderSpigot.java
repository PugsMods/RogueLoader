package com.pugzarecute.rougeloaderspigot;

import org.bukkit.Bukkit;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class RougeloaderSpigot extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("load").setExecutor(new PluginLoader());
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
