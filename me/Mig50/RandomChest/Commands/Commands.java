package me.Mig50.RandomChest.Commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Mig50.RandomChest.RandomChest;

public class Commands implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
        if (cmd.getLabel().equalsIgnoreCase("randomchest")){
        	if(args.length == 0) {
        		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6---- Random Chest ----"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "\n&f/randomchest spawn -> &7Spawn a chest in a random location of the map\n&f/randomchest list -> &7Get a list of all the spawned chests in the session"));
             
                return true;
        	}
        	if(args[0].equalsIgnoreCase("spawn")) {
        		if(player.hasPermission("randomchest.spawn")) {
        			int x,z;
            		Random rand = new Random();
            		x = rand.nextInt(2000) - 1000;
            		z = rand.nextInt(2000) - 1000;
            		Location loc = new Location(Bukkit.getServer().getWorld("world"), x, Bukkit.getServer().getWorld("world").getHighestBlockYAt(x,z), z);
            		loc.getBlock().setType(Material.CHEST);
            		RandomChest.chestlocations.add(loc);
            		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYou spawned a chest!"));
            		Bukkit.getServer().broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&4A chest was spawned at " + " X: " + loc.getBlockX() + " Y: " + loc.getBlockY() + " Z: " + loc.getBlockZ()));
            		return true;
        		}else {
            		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYou don't have permission to spawn a chest!"));
            		return true;
            	}
        	}
        	if(args[0].equalsIgnoreCase("list")) {
        		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Random Chest"));
        		if(RandomChest.chestlocations.isEmpty()) {
        			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fThere weren't spawned any chests on this session!"));
        			return true;
        		}
        		int i=1;
        		for (Location l : RandomChest.chestlocations) {
        			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f" + i + " -> X: " + l.getBlockX() + " Y: " + l.getBlockY() + " Z: " + l.getBlockZ()));
        			i++;
        		}
        	}
        	if(args[0].equalsIgnoreCase("remove")) {
        		player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYou removed the spawned chest!"));
        		return true;
        	}
            
            return true;
        }
        else if(cmd.getLabel().equalsIgnoreCase("teste")){
            //sender.sendMessage("Hey! You can't use this in the terminal!");
        	
            return true;
        }
		return false;
	}
}
