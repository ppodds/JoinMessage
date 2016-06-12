package ppodds.other.joinmessage;

import org.bukkit.plugin.java.JavaPlugin;

import ppodds.other.joinmessage.command.msg;
import ppodds.other.joinmessage.event.PlayerJoin;
import ppodds.other.joinmessage.event.PlayerQuit;

public class JoinMessage extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getCommand("msg").setExecutor(new msg(this));
		getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
		getServer().getPluginManager().registerEvents(new PlayerQuit(this), this);
		saveDefaultConfig();
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
