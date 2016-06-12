package ppodds.other.joinmessage.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import ppodds.other.joinmessage.JoinMessage;

public class msg implements CommandExecutor
{
	private JoinMessage jm;
	
	public msg(JoinMessage jm)
	{
		this.jm = jm;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args)
	{
		if (lable.equalsIgnoreCase("msg") && sender instanceof Player && args.length == 2 && sender.hasPermission("joinmessage.admin"))
		{
			Player p = (Player) sender;
			if (args[0].equalsIgnoreCase("joined"))
			{
				try
				{
					File f = new File(jm.getDataFolder() + File.separator + "config.yml");
					YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
					y.set("Message.JoinedTheGame", (String) args[1]);
					y.save(f);
					p.sendMessage("更改玩家加入遊戲訊息成功!");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			else
			if (args[0].equalsIgnoreCase("left"))
			{
				try
				{
					File f = new File(jm.getDataFolder() + File.separator + "config.yml");
					YamlConfiguration y = YamlConfiguration.loadConfiguration(f);
					y.set("Message.LeftTheGame", (String) args[1]);
					y.save(f);
					p.sendMessage("更改玩家離開遊戲訊息成功!");
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
