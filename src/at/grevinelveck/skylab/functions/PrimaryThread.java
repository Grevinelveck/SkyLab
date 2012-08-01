package at.grevinelveck.skylab.functions;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class PrimaryThread implements Runnable {
	private Player player;
	private String type;
	@Override
	public void run() {
		String[] skyLabMessageArray = {
				"Skylab online.  Charging primary coils.",
				"Acquiring designated target.",
				"Target found, Powering secondary coils",
				"Taget locked. " + player.getName()
						+ " will now be terminated." };

		for (int i = 0; i < skyLabMessageArray.length; i++) {

			Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  skyLabMessageArray[i]);
			if (!player.isOnline()) {
				if (type.equalsIgnoreCase("ban")) {
					player.setBanned(true);
				}
				Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  "Target ran away, shutting down.");
				return;
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
				}
				Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  "Target prematurly destroyed. Uploading obituary.");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  "Upload complete, shutting down.");
				return;
			}
			player.teleport(player);
			Location location = player.getLocation();
			World world = player.getWorld();
			world.strikeLightning(location);
			world.createExplosion(location, 1);
			Random rand = new Random();
			int lockOne = rand.nextInt(10) - 5;
			int lockTwo = rand.nextInt(10) - 5;
			int lockThree = rand.nextInt(10) - 5;
			Location newloc = new Location(world, player.getLocation().getX()
					+ lockOne, player.getLocation().getY()+lockThree, player
					.getLocation().getZ() + lockTwo);
			world.strikeLightning(newloc);
			world.createExplosion(newloc, 1);
			Random rand2 = new Random();
			int lockOne2 = rand2.nextInt(10) - 5;
			int lockTwo2 = rand2.nextInt(10) - 5;
			int lockThree2 = rand2.nextInt(10) - 5;
			Location newloc2 = new Location(world, player.getLocation().getX()
					+ lockOne2, player.getLocation().getY()+lockThree2, player
					.getLocation().getZ() + lockTwo2);
			world.strikeLightning(newloc2);
			world.createExplosion(newloc2, 1);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (player.getHealth()>0){
			player.setHealth(0);
		}
		if (type.equalsIgnoreCase("kick")) {
			player.kickPlayer("Clean up you act and try again");
		}
		if (type.equalsIgnoreCase("ban")) {
			Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  "Target perminitly destroyed. Uploading obituary.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.kickPlayer("Your obituary report has been uploaded.  The dead may not mingle with the living.");
			Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  "Upload complete.");
			player.setBanned(true);

		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Bukkit.broadcastMessage(ChatColor.DARK_RED.toString() +ChatColor.BOLD.toString() +  "Termination sequence compleate.  SkyLab is powering down.");
	}

	public PrimaryThread(Player player, String type) {
		this.player = player;
		this.type = type;
	}
}
