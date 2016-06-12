package ppodds.other.joinmessage.event;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import ppodds.other.joinmessage.JoinMessage;

public class PlayerJoin implements Listener
{
	private JoinMessage jm;
	
	public PlayerJoin(JoinMessage jm)
	{
		this.jm = jm;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		File f = new File(jm.getDataFolder() + File.separator + "config.yml");
		YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
		e.setJoinMessage(y.getString("Message.JoinedTheGame").replaceAll("%p", e.getPlayer().getName()));
	}
}
