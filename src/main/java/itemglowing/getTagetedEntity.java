package itemglowing;





import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.util.*;


public class getTagetedEntity {

	public static Vector getDirectionBetweenLocations(Location Start, Location End) {
		Vector from = Start.toVector();
		Vector to = End.toVector();
		return to.subtract(from);
	}




	public static Entity getTargetedItemEntity(Player p) {
		UUID uuid = p.getUniqueId();
		List<Entity> list = new ArrayList<>();

		for(Entity entity : p.getWorld().getNearbyEntities(p.getLocation(), 3, 3, 3)) {
			if(entity instanceof Item & !list.contains(entity)) {
				list.add(entity);
			}
		}
		if(Main.getItementity().get(uuid) != null){
			Glow.setGlow(p, Main.getItementity().get(uuid), false);
		}
		Entity targetedentity = null;
		for(Entity e : list) {
			for (double i = 1.0D; i <= p.getLocation().distance(e.getLocation()); i += 0.1) {
				Vector vector = getDirectionBetweenLocations(p.getEyeLocation().add(p.getLocation().getDirection().multiply(i)), e.getLocation());
				if(Math.round(vector.getX()* 100) / 100.0 > 0.5 && Math.round(vector.getZ()* 100) / 100.0 > 0.5){
					if(Math.round(vector.getX()* 100) / 100.0 < -0.5 && Math.round(vector.getZ()* 100) / 100.0 < -0.5) {
						if (Math.round(vector.getY() * 100) / 100.0 > -0.85 && Math.round(vector.getY() * 100) / 100.0 < -0) {
							targetedentity = e;
							Glow.setGlow(p, e, false);
							Glow.setGlow(p, e, true);
							Main.getIseeItemTarget().put(uuid, true);
							Main.getItementity().put(uuid, e);
							return targetedentity;
						}
					}
				}
				else if(Math.round(vector.getX()* 100) / 100.0 > -0.5 && Math.round(vector.getZ()* 100) / 100.0 > -0.5){
					if(Math.round(vector.getX()* 100) / 100.0 < 0.5 && Math.round(vector.getZ()* 100) / 100.0 < 0.5) {
						if (Math.round(vector.getY() * 100) / 100.0 > -0.85 && Math.round(vector.getY() * 100) / 100.0 < -0) {
							targetedentity = e;
							Glow.setGlow(p, e, false);
							Glow.setGlow(p, e, true);
							Main.getIseeItemTarget().put(uuid, true);
							Main.getItementity().put(uuid, e);
							return targetedentity;
						}
					}
				}
				else if(Math.round(vector.getX()* 100) / 100.0 > 0.5 && Math.round(vector.getZ()* 100) / 100.0 > -0.5){
					if(Math.round(vector.getX()* 100) / 100.0 < -0.5 && Math.round(vector.getZ()* 100) / 100.0 < 0.5) {
						if (Math.round(vector.getY() * 100) / 100.0 > -0.85 && Math.round(vector.getY() * 100) / 100.0 < -0) {
							targetedentity = e;
							Glow.setGlow(p, e, false);
							Glow.setGlow(p, e, true);
							Main.getIseeItemTarget().put(uuid, true);
							Main.getItementity().put(uuid, e);
							return targetedentity;
						}
					}
				}
				else if(Math.round(vector.getX()* 100) / 100.0 > -0.5 && Math.round(vector.getZ()* 100) / 100.0 > 0.5){
					if(Math.round(vector.getX()* 100) / 100.0 < 0.5 && Math.round(vector.getZ()* 100) / 100.0 < -0.5) {
						if (Math.round(vector.getY() * 100) / 100.0 > -0.85 && Math.round(vector.getY() * 100) / 100.0 < -0) {
							targetedentity = e;
							Glow.setGlow(p, e, false);
							Glow.setGlow(p, e, true);
							Main.getIseeItemTarget().put(uuid, true);
							Main.getItementity().put(uuid, e);
							return targetedentity;
						}
					}
				}
				Main.getIseeItemTarget().put(uuid, false);
				Glow.setGlow(p, e, false);
				Main.getItementity().put(uuid, null);
			}
			Main.getIseeItemTarget().put(uuid, false);
			Glow.setGlow(p, e, false);
			Main.getItementity().put(uuid, null);
		}
		Main.getIseeItemTarget().put(uuid, false);
		Main.getItementity().put(uuid, null);
		if(Main.getItementity().get(uuid) != null){
			Glow.setGlow(p, Main.getItementity().get(uuid), false);
		}

		return targetedentity;
	}
}
