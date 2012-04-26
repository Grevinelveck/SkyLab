package at.Grevinelveck.SLFunctions;

import org.bukkit.Bukkit;
import at.Grevinelveck.SLFunctions.sleepThread;



public class SLFunctions {
	sleepThread ST;
	public SLFunctions(String targetplayer) {

		//this needs stored as an array
		int loop=0;
				String[] SkyLabMessageArray={"Skylab online.  Charging primary coils.","Acquiring designated target.","Target found, Powering secondary coils","Taget locked.  "+ targetplayer+" will now be terminated."};
while (loop<5){
	
	ST=new sleepThread();
	Bukkit.broadcast(SkyLabMessageArray[loop], null);

}
	
}
		
}
