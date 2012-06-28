package at.Grevinelveck.SLFunctions;

import org.bukkit.Bukkit;

public class MSleepThread {
	// Set a running sleep thread to use SLFunctions
	public class SleepTnterrupt implements Runnable {
		@Override
		public void run() {
			int loop = 0;
			String[] skyLabMessageArray = {
					"Skylab online.  Charging primary coils.",
					"Acquiring designated target.",
					"Target found, Powering secondary coils",
					"Taget locked.  /*+ targetPlayer+*/ will now be terminated." };
			while (loop < skyLabMessageArray.length) {
				try {
					Bukkit.broadcast(skyLabMessageArray[loop], null);
					Thread.sleep(4000);
				} catch (InterruptedException x) {
					return;
				}
			}
		}
	}
}
