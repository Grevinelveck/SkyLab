package at.Grevinelveck.SLFunctions;

import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Systemstatus extends JavaPlugin {
	public static Systemstatus plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	public void onDisable(){
		PluginDescriptionFile pdfFile=this.getDescription();
		this.logger.info(pdfFile.getName()+" is offnline");
	}
	public void onEnable(){
		PluginDescriptionFile pdfFile=this.getDescription();
		this.logger.info(pdfFile.getName()+" is online");
	}

	}
