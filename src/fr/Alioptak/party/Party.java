package fr.Alioptak.party;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Party extends JavaPlugin implements Listener{

int bord;
	int bord_pos;
	int bord_test;
	int Z;
	int X;
	int Compte;
	Scoreboard board;
	int min1;
	int sec1;
	int min;
	int sec;
	int pause = 0;
	int e;
	int pause1;
	int day;
	int r_hour;
	int secu_2 = 0;
	int anti_msg;
	int episode = 0;
	private ArrayList<Player> shoot = new ArrayList<Player>();

	
		public void onEnable() {
			Bukkit.getServer().getPluginManager().registerEvents(this, this);
			getConfig().options().copyDefaults(true);
			saveConfig();
			bord = getConfig().getInt("Radius");
			X = getConfig().getInt("Center_X");
			Z = getConfig().getInt("Center_Z");
			PluginManager pm = getServer().getPluginManager();
			pm.registerEvents(this, this);	
			anti_msg = 1;
       
	}
		
	
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		
		if(cmd.getName().equalsIgnoreCase("start")){
			if(anti_msg == 0){
			secu_2 = 3;	
			}
			if(args.length < 2 || args.length >2){
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
						sender.sendMessage(ChatColor.RED+"Error: please enter two numbers on your command (minutes and seconds)");
						sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
						}else if(args.length == 2 ){
							min = Integer.parseInt(args[0]);
							sec = Integer.parseInt(args[1]);
							getConfig().set("Minutes", min);
							getConfig().set("Seconds", sec);
							saveConfig();
						Bukkit.getScheduler().cancelAllTasks();
			sender.sendMessage(ChatColor.GREEN+"Game start / restart with : "+ min +" minutes and "+sec+" seconds.");
			min1 = getConfig().getInt("Minutes");
			sec1 = getConfig().getInt("Seconds");
			if(min > 99 || min < 0 || sec > 59 || sec < 0){
				sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				sender.sendMessage(ChatColor.RED+"Error : Maximum time ="+ChatColor.AQUA+ " 99m "+ChatColor.BOLD+": "+ChatColor.AQUA+"59s");
				sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				if(min1 > 99){
				min1 = 99;
				
			}
				if(min1 <= -1){
				min1 = 0;
			}
				if(sec1 > 59){
				sec1 = 59;	
			}
				if(sec1 < 1){
				sec1 = 5;
			}}else{
			min = min1;
			sec = sec1;
			ScoreboardManager manager = Bukkit.getScoreboardManager();
			board = manager.getNewScoreboard();
			final Objective objective = board.registerNewObjective("Test", "Test2");

			Bukkit.getScheduler().scheduleAsyncRepeatingTask(this, new Runnable(){
				public void run() {
				
					if(pause == 0){
						
				for(Player pl : Bukkit.getOnlinePlayers()){	
					Score score1 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN+"Players : "));
					score1.setScore(Bukkit.getOnlinePlayers().length);
					Score score3 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.RED+"Difficulty : "));
					score3.setScore(pl.getWorld().getDifficulty().getValue());
				
					Score score5 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN+"Hour :"));
					int hour = (int) pl.getWorld().getTime();
					int hour_g = 0;
					if(hour > 0 && hour < 1000){
						hour_g = 7;
					}
					if(hour > 1000 && hour <2000){
						hour_g = 8;
					}
					if(hour > 2000 && hour < 3000){
						hour_g = 9;
					}
					if(hour > 3000 && hour < 4000){
						hour_g = 10;
					}
					if(hour > 4000 && hour < 5000){
						hour_g = 11;
					}
					if(hour > 5000 && hour < 6000){
						hour_g = 12;
					}
					if(hour > 6000 && hour < 7000){
						hour_g = 13;
					}
					if(hour > 7000 && hour < 8000){
						hour_g = 14;
					}
					if(hour > 8000 && hour < 9000){
						hour_g = 15;
					}
					if(hour > 9000 && hour < 10000){
						hour_g = 16;
					}
					if(hour > 10000 && hour < 11000){
						hour_g = 17;
					}
					if(hour > 11000 && hour < 12000){
						hour_g = 18;
					}
					if(hour > 12000 && hour < 13000){
						hour_g = 19;
					}
					if(hour > 13000 && hour < 14000){
						hour_g = 20;
					}
					if(hour > 14000 && hour < 15000){
						hour_g = 21;
					}
					if(hour > 15000 && hour < 16000){
						hour_g = 22;
					}
					if(hour > 16000 && hour < 17000){
						hour_g = 23;
					}
					if(hour > 17000 && hour < 18000){
						hour_g = 0;
					}
					if(hour > 18000 && hour < 19000){
						hour_g = 1;
					}
					if(hour > 19000 && hour < 20000){
						hour_g = 2;
					}
					if(hour > 20000 && hour < 21000){
						hour_g = 3;
					}
					if(hour > 21000 && hour < 22000){
						hour_g = 4;
					}
					if(hour > 22000 && hour < 23000){
						hour_g = 5;
					}
					if(hour > 23000 && hour < 24000){
						hour_g = 6;
					}
					
					getConfig().set("Hour", hour_g);
					saveConfig();
					score5.setScore(getConfig().getInt("Hour"));
					
				getConfig().set("Minutes", min);
				getConfig().set("Seconds", sec);
				saveConfig();
				getConfig().get("scoreboard_title");
				objective.setDisplayName(ChatColor.GRAY+getConfig().getString("scoreboard_title")+" "+ChatColor.AQUA+min+"m"+ChatColor.BOLD+" : "+ChatColor.AQUA+sec--+"s");
				pl.setScoreboard(board);

				}
				
				if(sec <= -1 && min > 0){
					e = 1;
					if(e == 1){
					min--;
					sec = 59;
					getConfig().set("Minutes", min);
				saveConfig();
				e = 0;
					}
					}
				else if(min == 0 && sec == -1){
					
				Bukkit.broadcastMessage(ChatColor.AQUA+"!=--------------Fin de la partie--------------=!");
				Bukkit.getScheduler().cancelAllTasks();
				}}}}
					, 0, 20);
				}}
			
					return true;	}//fin
			
		if(cmd.getName().equalsIgnoreCase("STitle") || cmd.getName().equalsIgnoreCase("ST")){
			if (sender instanceof Player){	
				if(args.length < 1 || args.length > 3) {
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
					sender.sendMessage(ChatColor.RED+"Error: please enter a string on your command");
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				}else
					if(args.length <=3){
						
					if(args.length == 1){
					getConfig().set("scoreboard_title", args[0].toString());
					if(anti_msg == 0){
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
					sender.sendMessage(ChatColor.GREEN+"The title of the scoreboard was changed.");
					sender.sendMessage(ChatColor.RED+"/!\\ WARNING : if you set more than 20 characters as the plugin made errors /!\\");
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
					}}else
				if(args.length == 2){
					getConfig().set("scoreboard_title", args[0].toString()+" "+args[1].toString());
					
				}else
					if(args.length == 3){
						getConfig().set("scoreboard_title", args[0].toString()+" "+args[1].toString()+" "+args[2].toString());
						
					}	}	
			}
			}
			if(cmd.getName().equalsIgnoreCase("pause")){
					if (sender instanceof Player){	
						if(pause == 0){
					
					pause = 1;
					sender.sendMessage(ChatColor.AQUA+"Successfull command! Please repeat the command for restart the game!");
						
						}else{
							int secu = 0;
							if(secu == 0){
							pause = 0;
							
							for(Player pl : Bukkit.getOnlinePlayers()){
								PotionEffect pe = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 125, 255);
								pl.addPotionEffect(pe);
							}
							secu = 1;
							((Player) sender).chat("/start "+ getConfig().getInt("Minutes")+" "+getConfig().getInt("Seconds"));
						}}
					
					
				}return true;
			
					
		
		}
		if(cmd.getName().equalsIgnoreCase("center")){
			sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
			sender.sendMessage(ChatColor.GREEN+"The center of your map is :"+ChatColor.GRAY+" X = "+ X+" Z = "+Z);
			sender.sendMessage(ChatColor.GREEN+" /setborder to set the center and the radius of your map!");
			sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");

		}
		if(cmd.getName().equalsIgnoreCase("setborder")){
		if (sender instanceof Player){	
		if(args.length < 1 || args.length >1){
			sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				sender.sendMessage(ChatColor.RED+"Error: please enter just a number to your command");
				sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
			}else if(args.length == 1){
				bord_test = Integer.parseInt(args[0]);
				if(bord_test <= 10000 && bord_test > 1){
				X = Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlockX();
				Z = Bukkit.getServer().getPlayer(sender.getName()).getLocation().getBlockZ();
				
				bord = bord_test;
				sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				sender.sendMessage(ChatColor.GREEN+"Enjoy! you have been set the radius of the border to "+ChatColor.AQUA+bord+ChatColor.GREEN+" blocks.");
				sender.sendMessage(ChatColor.GREEN+"Now the center of your map is at :"+ChatColor.GRAY+" X = "+ X+" Z = "+Z);
				sender.sendMessage(ChatColor.AQUA+"The corners of the square are now in: :");
				int northeast_X = X+bord;
				int northeast_Z = Z-bord;
				int Southeast_X = X+bord;
				int Southeast_Z = Z+bord;
				int Southwest_X = X-bord;
				int Southwest_Z = Z+bord;
				int Northwest_X = X-bord;
				int Northwest_Z = Z-bord;
				
				sender.sendMessage(ChatColor.GRAY+"Northeast = X = "+ northeast_X + " Z = " + northeast_Z);
				sender.sendMessage(ChatColor.GRAY+"Southeast = X = "+ Southeast_X + " Z = " + Southeast_Z);
				sender.sendMessage(ChatColor.GRAY+"Southwest = X = "+ Southwest_X + " Z = " + Southwest_Z);
				sender.sendMessage(ChatColor.GRAY+"Northwest = X = "+ Northwest_X + " Z = " + Northwest_Z);
				int Long_X = northeast_X-X + Southeast_X-X-1;
				int air = Long_X*Long_X;
				long volume = air;
				sender.sendMessage("");
				sender.sendMessage(ChatColor.AQUA+"For :");
				sender.sendMessage(ChatColor.GRAY+"    - an area of : " + air + " blocks");		
				sender.sendMessage(ChatColor.GRAY+"    - a global volume of : "+ volume*256 + " blocks (layer 0 to 256)");
				sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				
				getConfig().set("Radius", bord);
				getConfig().set("Center_X", X);
				getConfig().set("Center_Z", Z);
				saveConfig();

				}else{
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
					sender.sendMessage(ChatColor.RED+"Error: Please enter a number between 0 and 10000.");
					sender.sendMessage(ChatColor.GREEN+"Exemple : /setborder 500");
					sender.sendMessage(ChatColor.YELLOW+"!=--------------------------------------------=!");
				}
				
			
			
			}}}
	return false;
			
	}
	
	@EventHandler
	public void on(final PlayerMoveEvent player){
		Player p = player.getPlayer(); 
		if(pause == 1){
			Block block = p.getLocation().getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY()-1, p.getLocation().getBlockZ());
			
			if(!(block.getType().isSolid())){
			p.teleport(new Location(p.getWorld(), p.getLocation().getBlockX(), p.getLocation().getBlockY()-1, p.getLocation().getBlockZ()));
			}else{
			player.setCancelled(true);
			}
		}
		if(p.getLocation().getBlockX() >= bord + X - 25){
			Compte++;
			if(Compte >= 20){
				Compte = 0;
				p.playSound(p.getLocation(), Sound.NOTE_BASS, 100, 100);
			p.sendMessage(ChatColor.RED+"/!\\ Warning you are too close to the border map /!\\");
			}	}
			
		if(p.getLocation().getBlockX() <=  X - bord + 25){
		
			Compte++;
			if(Compte >= 20){
				Compte = 0;

				p.playSound(p.getLocation(), Sound.NOTE_BASS, 100, 100);

			p.sendMessage(ChatColor.RED+"/!\\ Warning you are too close to the border map /!\\");
			}	}
		if(p.getLocation().getBlockZ() >= bord + Z - 25){
				
			Compte++;
			if(Compte >= 20){
				Compte = 0;

				p.playSound(p.getLocation(), Sound.NOTE_BASS, 100, 100);

			p.sendMessage(ChatColor.RED+"/!\\ Warning you are too close to the border map /!\\");
			}	}
		if(p.getLocation().getBlockZ() <=  Z - bord + 25){
				
			Compte++;
			if(Compte >= 20){
				Compte = 0;

				p.playSound(p.getLocation(), Sound.NOTE_BASS, 100, 100);

			p.sendMessage(ChatColor.RED+"/!\\ Warning you are too close to the border map /!\\");
			}	}
			
			
		
	if(player.getPlayer().getLocation().getBlockX() >= bord + X){ // -
	player.getPlayer().sendMessage(ChatColor.RED+ "End of map.");
	player.setCancelled(true);
	if(player.isCancelled()){
	p.teleport(new Location(p.getWorld(), p.getLocation().getX() -1, p.getLocation().getY(), p.getLocation().getZ()));
	player.setCancelled(false);
	}
}
if(player.getPlayer().getLocation().getBlockX() <= X - bord){ // +
	player.getPlayer().sendMessage(ChatColor.RED+ "End of map.");
	player.setCancelled(true);
	if(player.isCancelled()){
	p.teleport(new Location(p.getWorld(), p.getLocation().getX() +1, p.getLocation().getY(), p.getLocation().getZ()));
	player.setCancelled(false);
	}
}
if(player.getPlayer().getLocation().getBlockZ() >= bord + Z){ // -
	player.getPlayer().sendMessage(ChatColor.RED+ "End of map.");
	player.setCancelled(true);
	if(player.isCancelled()){
	p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ() -1));
	player.setCancelled(false);
	}
}
if(player.getPlayer().getLocation().getBlockZ() <= Z - bord){ // +
	player.getPlayer().sendMessage(ChatColor.RED+ "End of map.");
	player.setCancelled(true);
	if(player.isCancelled()){
	p.teleport(new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ() +1));
	player.setCancelled(false);
	}
	}

	}
}