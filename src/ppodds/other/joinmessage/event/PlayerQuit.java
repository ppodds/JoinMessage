package ppodds.other.joinmessage.event;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import ppodds.other.joinmessage.JoinMessage;

public class PlayerQuit implements Listener
{
	private JoinMessage jm;
	
	public PlayerQuit(JoinMessage jm)
	{
		this.jm = jm;
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		File f = new File(jm.getDataFolder() + File.separator + "config.yml");
		YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
		e.setQuitMessage(y.getString("Message.LeftTheGame").replaceAll("%p", e.getPlayer().getName()));
	}
}
