package at.grevinelveck.skylab;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import at.grevinelveck.skylab.functions.*;

import org.bukkit.Location;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyLab extends JavaPlugin {
	static SkyLabCommandExecutor skyLabKill;
	public volatile Map<String,Location> pmap = new HashMap<String, Location>();


	public final Logger logger = Logger.getLogger("Minecraft");

	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " is offline");
		
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " is online");
		getServer().getPluginManager().registerEvents(new SkyLabEventListener(this), this);
		skyLabKill = new SkyLabCommandExecutor(this);
		getCommand("SkyLab").setExecutor(skyLabKill);
		
	}
}
