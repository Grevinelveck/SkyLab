package at.Grevinelveck.Skylab;


import at.Grevinelveck.SLFunctions.*;

import org.bukkit.World;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
public class SkyLab {

	static Systemstatus sS;
	static MSleepThread mST;
	static LSleepThread lSt;
	public SkyLab(){	}


//on command event
public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[]args){
	Player player = (Player) sender;
	World world = player.getWorld();
	if (commandLable.equalsIgnoreCase("SkyLab")){
		if(args.length==0){
			player.sendMessage("SkyLab requires a target to fire");
		}else if (args.length==1){
			if (player.getServer().getPlayer(args[0]!=null)){
				Player targetplayer=player.getServer().getPlayer(args[0]);
			
mST=new MSleepThread();
wait();
lSt=new LSleepThread(player);
wait();
//Ban or kick if needed with appropriate message
//Power down message
return true;
			}
			return false;
	
		
		}
}
}
	
public static void main(String[] args){
	sS=new Systemstatus();
	
}
}
