package at.grevinelveck.slfunctions;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MSleepThread implements Runnable {
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

			Bukkit.broadcastMessage(skyLabMessageArray[i]);// TODO:This may not
															// be the most
															// indicated
															// method
			if (!player.isOnline()) {
				if (type.equalsIgnoreCase("ban")) {
					player.setBanned(true);
				}
				Bukkit.broadcastMessage("Target ran away, shutting down.");
				return;
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		for (int count = 0; count < 10; count++) {
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

			Player upPlayer=Bukkit.getPlayer(player.getName());
			Location location = upPlayer.getLocation();
			World world = upPlayer.getWorld();
			world.strikeLightning(location);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Random rand = new Random();
			int lockOne = rand.nextInt(10) - 5;
			int lockTwo = rand.nextInt(10) - 5;
			Location newloc = new Location(world, upPlayer.getLocation().getX()
					+ lockOne, upPlayer.getLocation().getY(), upPlayer
					.getLocation().getZ() + lockTwo);
			world.strikeLightning(newloc);
			world.createExplosion(newloc, 0);

		}
		if (type.equalsIgnoreCase("kick")) {
			player.kickPlayer("The cake was not a lie");/* snerk */
		}
		if (type.equalsIgnoreCase("ban")) {
			player.setBanned(true);
		}
	}

	public MSleepThread(Player player, String type) {
		this.player = player;
		this.type = type;
	}
}
