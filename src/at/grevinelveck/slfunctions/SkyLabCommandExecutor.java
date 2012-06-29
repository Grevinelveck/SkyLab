package at.grevinelveck.slfunctions;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SkyLabCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLable, String[] args) {
		Player player = (Player) sender;
		if (commandLable.equalsIgnoreCase("SkyLab")) {
			switch (args.length) {
			case 0:
				player.sendMessage("SkyLab requires a target to fire");
				break;
			case 1:
				if (player.getServer().getPlayer(args[0]) != null) {
					Thread mST = new Thread(new MSleepThread(player, "none"));

					mST.run();
					return true;
				} else {
					player.sendMessage("Target not found");
				}
				break;
			case 2:
				if (args[0].equalsIgnoreCase("ban")
						|| args[0].equalsIgnoreCase("kick")
						|| args[0].equalsIgnoreCase("none")) {

					String type = args[0];
					if (player.getServer().getPlayer(args[1]) != null) {
						Thread mST = new Thread(new MSleepThread(player, type));

						mST.run();
						return true;
					} else {
						player.sendMessage("Target not found");
					}
				} else {
					player.sendMessage("Invalid type: availiable types:");
					player.sendMessage("none, kick, ban");
				}
				break;
			default:
				player.sendMessage("Too many arguments!");
			}
		}
		return false;
	}
}
