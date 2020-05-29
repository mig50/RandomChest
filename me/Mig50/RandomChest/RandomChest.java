package me.Mig50.RandomChest;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import me.Mig50.RandomChest.Commands.Commands;
import me.Mig50.RandomChest.Events.EventsClass;


public class RandomChest extends JavaPlugin {
	public static ArrayList<Location> chestlocations;
	
	public void onEnable() {
		chestlocations = new ArrayList<Location>();
		//get chests from database
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "\n\nRandomChest has been enabled!\n\n");
		getServer().getPluginManager().registerEvents(new EventsClass(), this);
		this.getCommand("randomchest").setExecutor((CommandExecutor) new Commands());
	}
	public void onDisable() {
		//remover chests
		/*for(Location l : chestlocations) {
			l.getBlock().setType(Material.AIR);
		}*/
		//save the chests on database
		getServer().getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "\n\nRandomChest has been disabled!\n\n");
	}
}
