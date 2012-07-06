package at.grevinelveck.slfunctions;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class SkyLabCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLable, String[] args) {
		if (commandLable.equalsIgnoreCase("SkyLab")) {
			switch (args.length) {
			case 0:
				sender.sendMessage("SkyLab requires a target to fire");
				break;
			case 1:
			// assign args[1] as player
			{
				Player player = Bukkit.getPlayer(args[0]);
				if (player != null) {
					Thread mST = new Thread(new MSleepThread(player, "none"));
					System.out
							.println(/* eclipse shortcuts <3 */"herpderp thread created and launched");

					mST.run();
					return true;
				} else {
					sender.sendMessage("Target not found");
				}
				break;
			}
			case 2: {
				// assign args[1] as player
				Player player = Bukkit.getPlayer(args[1]);
				if (args[0].equalsIgnoreCase("ban")
						|| args[0].equalsIgnoreCase("kick")
						|| args[0].equalsIgnoreCase("none")) {

					String type = args[0];
					if (sender.getServer().getPlayer(args[1]) != null) {
						Thread mST = new Thread(new MSleepThread(player, type));

						mST.run();
						return true;
					} else {
						sender.sendMessage("Target not found");
					}
				} else {
					sender.sendMessage("Invalid type: availiable types:");
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
