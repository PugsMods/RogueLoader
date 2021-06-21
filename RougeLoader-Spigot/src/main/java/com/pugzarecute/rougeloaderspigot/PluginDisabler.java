package com.pugzarecute.rougeloaderspigot;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginBase;

import java.io.File;


public class PluginDisabler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 2) {
            if(args[0].equalsIgnoreCase("enable")) {
                if(Bukkit.getPluginManager().getPlugin(args[1]) != null){
                Bukkit.getPluginManager().enablePlugin(Bukkit.getPluginManager().getPlugin(args[1]));}
                else {
                    sender.sendMessage("Sorry, Plugin "+args[1]+"Could not be found.");
                }
            }

        }
        return false;
    }
}
