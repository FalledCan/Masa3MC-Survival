package masa3mc.survivalplugin.Commands.Other;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class NickCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission("spl.nick")) {
                if (args.length == 1) {
                    String nick = String.valueOf(args[0]);
                    String check = nick.replace("&0","")
                            .replace("&1","")
                            .replace("&2","")
                            .replace("&3","")
                            .replace("&4","")
                            .replace("&5","")
                            .replace("&6","")
                            .replace("&7","")
                            .replace("&8","")
                            .replace("&9","")
                            .replace("&a","")
                            .replace("&b","")
                            .replace("&c","")
                            .replace("&d","")
                            .replace("&e","")
                            .replace("&f","")
                            .replace("&k","")
                            .replace("&l","")
                            .replace("&m","")
                            .replace("&n","")
                            .replace("&o","")
                            .replace("&r","");
                    int n = check.length();
                    if(n < 11) {
                        String cleanernick = nick.replace("&k","");
                        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                        Bukkit.dispatchCommand(console, "lp user " + player.getName() + " meta setsuffix " + cleanernick);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "§b[§aspl§b]§f ニックネームを" + cleanernick + "§fに変更しました。"));
                    }else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "§b[§aspl§b]§c ニックネームが長すぎます!!10文字以下にしてください。"));
                    }
                } else {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    Bukkit.dispatchCommand(console, "lp user " + player.getName() + " meta removesuffix 1");
                    player.sendMessage("§b[§aspl§b]§f ニックネームをクリアしました。");
                }
            }else {
                player.sendMessage("§b[§aspl§b]§c Rank-Iron-1以上が必要です。");
            }
        }else{
            sender.sendMessage("§b[§aspl§b]§cこれはプレイヤーようです");
        }
        return true;
    }
}
