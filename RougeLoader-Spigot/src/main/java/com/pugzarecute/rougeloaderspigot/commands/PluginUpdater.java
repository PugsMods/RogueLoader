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

package com.pugzarecute.rougeloaderspigot.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;

import java.io.File;

public class PluginUpdater implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 3){
            File oldF = new File("plugins"+File.separator+args[0]);
            Bukkit.getServer().getPluginManager().disablePlugin(Bukkit.getPluginManager().getPlugin(args[2]));
            File newF = new File("plugins"+File.separator+args[1]);
            oldF.renameTo(new File("old-jars"+File.separator+oldF.getName()+"-backup"));
            newF.renameTo(new File("plugins"+File.separator+newF.getName()));
            try {
                Bukkit.getServer().getPluginManager().loadPlugin(newF);
            } catch (InvalidPluginException | InvalidDescriptionException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
