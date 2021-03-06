package me.badbones69.crazyenvoy.multisupport;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public enum Support {
	
	HOLOGRAPHIC_DISPLAYS("HolographicDisplays"),
	PLACEHOLDER_API("PlaceholderAPI"),
	MVDW_PLACEHOLDER_API("MVdWPlaceholderAPI"),
	WORLD_GUARD("WorldGuard"),
	WORLD_EDIT("WorldEdit"),
	CMI("CMI-Disabled");// Disabled till I can figure out how to make it work.
	
	private String name;
	
	private Support(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin(name);
	}
	
	public Boolean isPluginLoaded() {
		return Bukkit.getServer().getPluginManager().getPlugin(name) != null;
	}
	
}