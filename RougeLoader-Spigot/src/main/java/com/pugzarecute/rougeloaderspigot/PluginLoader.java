package com.pugzarecute.rougeloaderspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;

import java.io.File;
import java.io.FileNotFoundException;

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
                sender.sendMessage("Failed to load plugin "+args[0]);
            }
            return true;
        }
    }
}
