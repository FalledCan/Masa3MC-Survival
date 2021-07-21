package masa3mc.survivalplugin.Commands.Fly;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeedCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String spl = "§b[§aspl§b]§r ";

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(player.hasPermission("spl.fs")){
                if(args.length == 0){
                    player.sendMessage(spl+ ChatColor.WHITE + "/fs 1~10");
                }else if(args.length == 1){
                    double sp = Double.parseDouble(args[0]);
                    if(sp<11 && sp>0) {
                        double sp2 = sp * 0.1;
                        float sp3 = (float) sp2;
                        player.setFlySpeed(sp3);
                        player.sendMessage(spl + ChatColor.GREEN + "flyspeedを" + sp + "に変更しました。");
                    }else {
                        player.sendMessage(spl+ ChatColor.WHITE + "/fs 1~10");
                    }
                }else {
                    player.sendMessage(spl+ ChatColor.RED + "/fs 0~10");
                }
            }else {
                player.sendMessage(spl+ ChatColor.RED + "permissionを持っていません");
            }
        }else {
            sender.sendMessage(spl+ ChatColor.RED + "this command cannot use by console");
        }
        return true;
    }
}
