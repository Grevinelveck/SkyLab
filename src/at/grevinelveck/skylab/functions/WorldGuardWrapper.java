package at.grevinelveck.skylab.functions;/*not really*/

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class WorldGuardWrapper {
	private WorldGuardPlugin wgp;
	public WorldGuardWrapper() {
		wgp=(WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
	}

	public boolean isInRegion(Player player) {
		try {
			return wgp.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()).size()!=0;
		} catch (NullPointerException e) {
			// GULP
		}
		return false;
	}

}

