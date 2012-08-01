package at.grevinelveck.skylab.functions;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;


public class SkyLabCommandExecutor implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLable, String[] args) {
		if ((commandLable.equalsIgnoreCase("SkyLab"))||(commandLable.equalsIgnoreCase("SL"))) {
			switch (args.length) {
			case 0:
				sender.sendMessage("SkyLab requires a target to fire");
				break;
			case 1:
			// assign args[1] as player
			{
				Player player = Bukkit.getPlayer(args[0]);
				if ((player != null)&&(sender.hasPermission("SkyLab.kill"))) {
					Thread mST = new Thread(new PrimaryThread(player, "none"));

					mST.run();
					return true;
				} else {
					sender.sendMessage("Target not found or you do not have permission to use this command.");
				}
				break;
			}
			case 2: {
				// assign args[1] as player
				Player player = Bukkit.getPlayer(args[1]);
				if (((args[0].equalsIgnoreCase("ban"))&&(sender.hasPermission("SkyLab.ban")))
						|| ((args[0].equalsIgnoreCase("kick"))&&(sender.hasPermission("SkyLab.kick")))
						|| ((args[0].equalsIgnoreCase("none"))&&(sender.hasPermission("SkyLab.kill")))) {

					String type = args[0];
					if (sender.getServer().getPlayer(args[1]) != null) {
						Thread mST = new Thread(new PrimaryThread(player, type));

						mST.run();
						return true;
					} else {
						sender.sendMessage("Target not found.");
					}
				} else {
					sender.sendMessage("Invalid type or you lack approriate permission: availiable types:");
					sender.sendMessage("none, kick, ban");
				}
				break;
			}
			default:
				sender.sendMessage("Too many arguments!");
			}
		}
		return false;
	}
}
