package at.grevinelveck.skylab;

import java.util.logging.Logger;

import at.grevinelveck.skylab.functions.*;

import org.bukkit.plugin.*;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyLab extends JavaPlugin {
	static SkyLabCommandExecutor skyLabKill;
	public static boolean worldguarded = true;
	public static SkyLab plugin;
	public static WorldGuardWrapper wgr;

	public final Logger logger = Logger.getLogger("Minecraft");

	public void loadConfiguration() {
		getConfig().options().copyDefaults(true);
		saveConfig();

	}

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " is offline");

	}

	@Override
	public void onEnable() {
		if (getServer().getPluginManager().getPlugin("WorldGuard") == null
				|| !getConfig().getBoolean("Settings.respectWorldGuardRegion")) {
			worldguarded = false;
		} else {
			wgr = new WorldGuardWrapper();
		}
		PluginDescriptionFile pdfFile = this.getDescription();

		this.logger.info(pdfFile.getName() + " is online");
		plugin = this;
		loadConfiguration();
		skyLabKill = new SkyLabCommandExecutor();
		getCommand("SkyLab").setExecutor(skyLabKill);
		getCommand("SL").setExecutor(skyLabKill);

	}
}
