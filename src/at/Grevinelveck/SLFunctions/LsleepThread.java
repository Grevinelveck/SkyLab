package at.Grevinelveck.SLFunctions;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

	public class LSleepThread implements Runnable {

		private Player player;
		public LSleepThread(Player player){this.player=player;}
		public void run(){
			int count=0;
			while (count<10)
			{
		    try {
				Location location = player.getLocation();
				World world = player.getWorld();
				world.strikeLightning(location);
		      Thread.sleep(500);
		      	long seed = System.currentTimeMillis();
				Random rand = new Random(seed); 
				double lockOne = rand.nextDouble()*22-11;
				double lockTwo = rand.nextDouble()*22-11;
		      Location newloc = new Location(world, player.getLocation().getX()+lockOne,player.getLocation().getY(),player.getLocation().getZ()+lockTwo);
		      world.strikeLightning(newloc);
		    }
		     catch (InterruptedException x) {
			}
		    count++;
		}
		
	}
	}
	