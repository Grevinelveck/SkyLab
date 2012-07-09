package at.grevinelveck.skylab.functions;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import at.grevinelveck.skylab.SkyLab;

public class SkyLabEventListener implements Listener {
	private SkyLab skylab;

	public SkyLabEventListener(SkyLab skylab) {
		this.skylab = skylab;
	}

	@EventHandler
	public void MoveHandler(PlayerMoveEvent event) {
		if (skylab.pmap.containsKey(event.getPlayer().getName())) {
			skylab.pmap.remove(event.getPlayer().getName());
			skylab.pmap.put(event.getPlayer().getName(), event.getTo());
		}
	}
}
