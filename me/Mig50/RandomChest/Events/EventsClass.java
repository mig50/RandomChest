package me.Mig50.RandomChest.Events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.Mig50.RandomChest.RandomChest;


public class EventsClass implements Listener{
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
		Block block = event.getBlock();
		if(block.getType() != Material.CHEST)
			return;
		else {
			Location found = null;
			for(Location l: RandomChest.chestlocations) {
				if(l.equals(block.getLocation())) {
					found = block.getLocation();
				}
			}
			if(found != null)
				RandomChest.chestlocations.remove(found);
			return;
		}
			
	}
}
