package at.Grevinelveck.SLFunctions;

import org.bukkit.Bukkit;



public class SLFunctions {
	SleepThread ST;
	public SLFunctions(String targetPlayer) {

		//this needs stored as an array
		int loop=0;
				String[] skyLabMessageArray={"Skylab online.  Charging primary coils.","Acquiring designated target.","Target found, Powering secondary coils","Taget locked.  "+ targetPlayer+" will now be terminated."};
while (loop<5){
	
	ST=new SleepThread();
	Bukkit.broadcast(skyLabMessageArray[loop], null);

}
	
}
		
}
