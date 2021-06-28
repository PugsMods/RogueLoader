/*
 *     Copyright (C) 2021 PugzAreCute
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.pugzarecute.rougeloaderspigot;

import com.pugzarecute.rougeloaderspigot.commands.PluginLoader;
import com.pugzarecute.rougeloaderspigot.commands.PluginUpdater;
import com.pugzarecute.rougeloaderspigot.commands.RougeCommand;
import com.pugzarecute.rougeloaderspigot.update.RougeUpdater;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public final class RougeloaderSpigot extends JavaPlugin {
    //Current version of the code in this jar. Only used by the UpdateChecker as of now.
    public static final Double CODE_VERSION = 1.0;
    @Override
    public void onEnable() {
        Objects.requireNonNull(getCommand("load")).setExecutor(new PluginLoader());
        Objects.requireNonNull(getCommand("rouge")).setExecutor(new RougeCommand());
        Objects.requireNonNull(getCommand("update_plugin")).setExecutor(new PluginUpdater());

        Bukkit.getLogger().log(Level.INFO,"Starting RougeLoader Update Checker.");
        try {
            //Start the update checker.
            RougeUpdater.checkForUpdates();
        } catch (IOException e) {
            Bukkit.getLogger().log(Level.WARNING,"Failed to start Rouge Update Checker");
        }
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
