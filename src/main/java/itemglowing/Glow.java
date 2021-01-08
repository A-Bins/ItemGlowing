package itemglowing;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedDataWatcher;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class Glow {
	public static void setGlow(Player p, Entity e, boolean glow) {

		ProtocolManager pm = ProtocolLibrary.getProtocolManager();


		WrappedDataWatcher watcher = new WrappedDataWatcher();

		WrappedDataWatcher.Serializer serializer = WrappedDataWatcher.Registry.get(Byte.class);
		watcher.setEntity(e);

		if (glow) {
			if (watcher.getObject(0) == null)
				watcher.setObject(0, serializer, (byte) 0x40);
			else
				watcher.setObject(0, serializer, (byte) watcher.getObject(0) | 1 << 6);
		} else {
			if (watcher.getObject(0) == null)
				watcher.setObject(0, serializer, (byte) 0);
			else
				watcher.setObject(0, serializer, (byte) watcher.getObject(0) & ~1 << 6);
		}

		PacketContainer packet = pm.createPacket(PacketType.Play.Server.ENTITY_METADATA);

		packet.getIntegers().write(0, e.getEntityId());

		packet.getWatchableCollectionModifier().write(0, watcher.getWatchableObjects());

		try {
			pm.sendServerPacket(p, packet);
		} catch (InvocationTargetException i) {
			i.printStackTrace();
		}
	}
}