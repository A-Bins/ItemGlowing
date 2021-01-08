package itemglowing.Commands;

import itemglowing.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import static itemglowing.Glow.setGlow;


public class ItemGlow implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player){
			if(p.getTargetEntity(3) != null) {
				setGlow(p, p.getTargetEntity(3), true);
				Entity e = p.getTargetEntity(3);
				Bukkit.getScheduler().scheduleSyncDelayedTask( Main.getInstance() , () -> {
					setGlow(p, e, false);
				}, 20 * 5);
			}
		}
		return false;
	}
}
