package me.BadBones69.envoy.controlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.BadBones69.envoy.Main;
import me.BadBones69.envoy.Methods;
import me.BadBones69.envoy.api.Envoy;
import me.BadBones69.envoy.api.Flare;

public class FlareControl implements Listener{
	
	@EventHandler
	public void onFlareActivate(PlayerInteractEvent e){
		Player player = e.getPlayer();
		if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
			ItemStack flare = Methods.getItemInHand(player);
			if(flare != null){
				if(Flare.isFlare(flare)){
					e.setCancelled(true);
					if(player.hasPermission("envoy.flare.use")){
						Flare.takeFlare(player, flare);
						player.sendMessage(Methods.getPrefix() + Methods.color(Main.settings.getMessages().getString("Messages.Used-Flare")));
						Envoy.startEnvoy();
					}else{
						player.sendMessage(Methods.getPrefix() + Methods.color(Main.settings.getMessages().getString("Messages.Cant-Use-Flares")));
						return;
					}
				}
			}
		}
	}
	
}