package at.grevinelveck.skylab.functions;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import at.grevinelveck.skylab.SkyLab;

public class PrimaryThread implements Runnable {
	private SkyLab skylab;

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

			Bukkit.broadcastMessage(skyLabMessageArray[i]);
			if (!player.isOnline()) {
				if (type.equalsIgnoreCase("ban")) {
					player.setBanned(true);
				}
				Bukkit.broadcastMessage("Target ran away, shutting down.");
				return;
			}
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		for (int count = 0; count < 20; count++) {
			if (!player.isOnline()) {
				if (type.equalsIgnoreCase("ban")) {
					player.setBanned(true);
				}
				Bukkit.broadcastMessage("Target prematurly destroyed. Uploading obituary.");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Bukkit.broadcastMessage("Upload complete, shutting down.");
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
			Location newloc = new Location(world, player.getLocation().getX()
					+ lockOne, player.getLocation().getY(), player
					.getLocation().getZ() + lockTwo);
			world.strikeLightning(newloc);
			world.createExplosion(newloc, 1);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (type.equalsIgnoreCase("kick")) {
			player.kickPlayer("The cake was not a lie");/* snerk */
		}
		if (type.equalsIgnoreCase("ban")) {
			player.setBanned(true);
		}
	}

	public PrimaryThread(Player player, String type) {
		this.player = player;
		this.type = type;
	}
}
