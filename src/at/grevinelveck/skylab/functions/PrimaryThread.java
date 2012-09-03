package at.grevinelveck.skylab.functions;

import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import at.grevinelveck.skylab.SkyLab;

public class PrimaryThread implements Runnable {

	FileConfiguration config = SkyLab.plugin.getConfig();
	private Player player;
	private String type;

	@Override
	public void run() {/* ill prettyfy this later */

		List<String> skyLabMessageList = config
				.getStringList("Settings.poweringUpArray");
		String[] skyLabMessageArray = skyLabMessageList
				.toArray(new String[skyLabMessageList.size()]);
		String fled = config.getString("Settings.targetFled").replaceAll(
				"%player%", player.getName());
		String kick = config.getString("Settings.kickPlayer").replaceAll(
				"%player%", player.getName());
		String ban = config.getString("Settings.banPlayer").replaceAll(
				"%player%", player.getName());
		String toBanned = config.getString("Settings.messageToBannedPlayer")
				.replaceAll("%player%", player.getName());
		String upload = config.getString("Settings.verifyIsBanned").replaceAll(
				"%player%", player.getName());
		String powerDown = config.getString("Settings.poweringDownMessage")
				.replaceAll("%player%", player.getName());
		boolean crater = config.getBoolean("Settings.explosionsCauseCraters");
		int boom = config.getInt("Settings.explosionSize");
		boolean region;
		if (SkyLab.worldguarded)
			region = SkyLab.wgr.isInRegion(player);
		else
			region = false;

		for (int i = 0; i < skyLabMessageArray.length; i++) {
			String temp = skyLabMessageArray[i].replaceAll("%player%",
					player.getName());
			Bukkit.broadcastMessage(ChatColor.DARK_RED.toString()
					+ ChatColor.BOLD.toString() + temp);

			if (!player.isOnline()) {

				if (type.equalsIgnoreCase("ban")) {
					player.setBanned(true);
					Bukkit.broadcastMessage(ChatColor.DARK_RED.toString()
							+ ChatColor.BOLD.toString() + fled);
					return;
				}
			}
			try {
				Thread.sleep(3000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		for (int count = 0; count < 30; count++) {

			if (!player.isOnline()) {

				if (type.equalsIgnoreCase("ban")) {
					player.setBanned(true);
					Bukkit.broadcastMessage(ChatColor.DARK_RED.toString()
							+ ChatColor.BOLD.toString() + fled);
				}
			}
			player.teleport(player);
			Location location = player.getLocation();
			World world = player.getWorld();
			world.strikeLightning(location);

			if (crater && !region) {
				world.createExplosion(location, boom);
			} else {
				world.createExplosion(location, 0);
			}

			Random rand = new Random();
			int lockOne = rand.nextInt(10) - 5;
			int lockTwo = rand.nextInt(10) - 5;
			int lockThree = rand.nextInt(10) - 5;

			Location newloc = new Location(world, player.getLocation().getX()
					+ lockOne, player.getLocation().getY() + lockThree, player
					.getLocation().getZ() + lockTwo);
			world.strikeLightning(newloc);
			if (crater && !region) {

				world.createExplosion(newloc, boom);
			} else {
				world.createExplosion(newloc, 0);
			}

			Random rand2 = new Random();
			int lockOne2 = rand2.nextInt(10) - 5;
			int lockTwo2 = rand2.nextInt(10) - 5;
			int lockThree2 = rand2.nextInt(10) - 5;

			Location newloc2 = new Location(world, player.getLocation().getX()
					+ lockOne2, player.getLocation().getY() + lockThree2,
					player.getLocation().getZ() + lockTwo2);
			world.strikeLightning(newloc2);

			if (crater && !region) {
				world.createExplosion(newloc2, boom);
			} else {
				world.createExplosion(newloc2, 0);
			}

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (player.getHealth() > 0) {
			player.setHealth(0);
		}

		if (type.equalsIgnoreCase("kick")) {
			player.kickPlayer(kick);
		}

		if (type.equalsIgnoreCase("ban")) {
			Bukkit.broadcastMessage(ChatColor.DARK_RED.toString()
					+ ChatColor.BOLD.toString() + ban);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.kickPlayer(toBanned);
			Bukkit.broadcastMessage(ChatColor.DARK_RED.toString()
					+ ChatColor.BOLD.toString() + upload);
			player.setBanned(true);

		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bukkit.broadcastMessage(ChatColor.DARK_RED.toString()
				+ ChatColor.BOLD.toString() + powerDown);
	}

	public PrimaryThread(Player player, String type) {
		this.player = player;
		this.type = type;
	}
}
