package itemglowing.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;

public class Pickup implements Listener {
	@EventHandler
	public void PickupEvent(PlayerAttemptPickupItemEvent e){
		e.setCancelled(true);
	}
}
