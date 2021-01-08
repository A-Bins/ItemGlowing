package itemglowing;

import itemglowing.Commands.ItemGlow;
import itemglowing.Event.Pickup;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class Main extends JavaPlugin {
	private static Main instance;

	public static Main getInstance(){
		return instance;
	}




	private static HashMap<UUID, Entity> item = new HashMap<UUID, Entity>();

	public static HashMap<UUID, Entity> getItementity(){
		return item;
	}
	private static HashMap<UUID, Boolean> IseeItemTarget = new HashMap<UUID, Boolean>();

	public static HashMap<UUID, Boolean> getIseeItemTarget(){
		return IseeItemTarget;
	}

	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("[  ItemGlowing  ]" + ChatColor.GREEN +" 플러그인 활성화 copyright ©  < Bins#1004 > all rights reserved Bins#1004");
		instance = this;
		getCommand("Glow").setExecutor(new ItemGlow());
		Bukkit.getPluginManager().registerEvents(new Pickup(), this);
		Bukkit.getScheduler().runTaskTimer( this , () -> {
			for (Player p : Bukkit.getOnlinePlayers()) {
				getTagetedEntity.getTargetedItemEntity(p);
			}
		}, 1,1);
	}

	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage("[  ItemGlowing  ]" + ChatColor.RED +" 플러그인 비활성화 copyright ©  < Bins#1004 > all rights reserved Bins#1004" );
	}
}
