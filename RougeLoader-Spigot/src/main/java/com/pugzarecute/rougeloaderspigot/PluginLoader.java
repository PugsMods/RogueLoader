/*
 * Copyright (C) 2021 PugzAreCute
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
 *
 */

package com.pugzarecute.rougeloaderspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;

import java.io.File;

public class PluginLoader implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(args.length == 1)){
            sender.sendMessage("Wrong Usage! Please do /load <JARFILE_NAME>");
            return false;
        }else {
            try {
                Bukkit.getServer().getPluginManager().loadPlugin(new File("plugins"+File.separator+args[0]));
            } catch (InvalidPluginException | InvalidDescriptionException e) {
                sender.sendMessage("Failed to load plugin "+args[0]+", is the plugin in the plugins folder? Is it a valid plugin?");
            }
            return true;
        }
    }
}
