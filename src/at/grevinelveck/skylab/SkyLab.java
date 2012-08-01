package at.grevinelveck.skylab;
import java.util.logging.Logger;

import at.grevinelveck.skylab.functions.*;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyLab extends JavaPlugin {
	static SkyLabCommandExecutor skyLabKill;


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
		skyLabKill = new SkyLabCommandExecutor();
		getCommand("SkyLab").setExecutor(skyLabKill);
		
	}
}
