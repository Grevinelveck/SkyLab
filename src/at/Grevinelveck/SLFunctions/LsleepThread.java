package at.Grevinelveck.SLFunctions;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

	public class LsleepThread implements Runnable {
		private Player player;
		public LsleepThread(Player player){this.player=player;}
		public void run(){
			Location location = player.getLocation();
			World world = player.getWorld();
			world.strikeLightning(location);
			int count=0;
			while (count<10)
			{
		    try {
		      Thread.sleep(500);
//random lightning strike goes here.
		      count++;
		    }
		     catch (InterruptedException x) {
		      return;
			}
		}
		
	}
	}
	