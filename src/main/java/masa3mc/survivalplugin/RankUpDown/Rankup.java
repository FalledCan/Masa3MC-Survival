package masa3mc.survivalplugin.RankUpDown;

import masa3mc.survivalplugin.Events;
import masa3mc.survivalplugin.SurvivalPlugin;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Rankup {


    public void UserRankUp(Player p){

        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        Economy economy = SurvivalPlugin.getEconomy();

        String spl = "§b[§aspl§b]§r ";

        long point = Events.point.get(p.getName());

        if(p.hasPermission("group.beginner")){//R-1
            if(point >= 100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.regular-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.beginner");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§aregular-1§6になりました。");
                economy.depositPlayer(p,100);
                p.sendMessage(spl + "報酬として100円を獲得しました。");
                p.sendMessage(spl + "regularランクに昇格したため以下の機能が解放されました。");
                p.sendMessage(spl + "・atmコマンド");
                p.sendMessage(spl + "・enderコマンド（有料）");
            }
        }else if(p.hasPermission("group.regular-1")){//R-2
            if(point >= 1100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.regular-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-1");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§aregular-2§6になりました。");
                economy.depositPlayer(p,1000);
                p.sendMessage(spl + "報酬として1000円を獲得しました。");
            }
        }else if(p.hasPermission("group.regular-2")){//R-3
            if(point >= 3100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.regular-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-2");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§aregular-3§6になりました。");
                economy.depositPlayer(p,2000);
                p.sendMessage(spl + "報酬として2000円を獲得しました。");
            }
        }else if(p.hasPermission("group.regular-3")){//I-1
            if(point >= 6100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.iron-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-3");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§7iron-1§6になりました。");
                economy.depositPlayer(p,3000);
                p.sendMessage(spl + "報酬として3000円を獲得しました。");
                p.sendMessage(spl + "ironランクに昇格したため以下の機能が解放されました。");
                p.sendMessage(spl + "・hatコマンド");
                p.sendMessage(spl + "・nickコマンド");
            }
        }else if(p.hasPermission("group.iron-1")){//I-2
            if(point >= 11100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-1");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§7iron-2§6になりました。");
                economy.depositPlayer(p,5000);
                p.sendMessage(spl + "報酬として5000円を獲得しました。");
            }
        }else if(p.hasPermission("group.iron-2")){//I-3
            if(point >= 21100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-2");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§7iron-3§6になりました。");
                economy.depositPlayer(p,10000);
                p.sendMessage(spl + "報酬として10000円を獲得しました。");
            }
        }else if(p.hasPermission("group.iron-3")){//G-1
            if(point >= 36100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§6gold-1§6になりました。");
                economy.depositPlayer(p,15000);
                p.sendMessage(spl + "報酬として15000円を獲得しました。");
                p.sendMessage(spl + "goldランクに昇格したため以下の機能が解放されました。");
                p.sendMessage(spl + "・enderコマンドの無料化");
                p.sendMessage(spl + "・flyコマンド（有料）");
                p.sendMessage(spl + "・Storageの使用が可能");
            }
        }else if(p.hasPermission("group.gold-1")){//G-2
            if(point >= 66100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§6gold-2§6になりました。");
                economy.depositPlayer(p,30000);
                p.sendMessage(spl + "報酬として30000円を獲得しました。");
            }
        }else if(p.hasPermission("group.gold-2")){//G-3
            if(point >= 116100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§6gold-3§6になりました。");
                economy.depositPlayer(p,50000);
                p.sendMessage(spl + "報酬として50000円を獲得しました。");
            }
        }else if(p.hasPermission("group.gold-3")){//D-1
            if(point >= 216100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§bdiamond-1§6になりました。");
                economy.depositPlayer(p,100000);
                p.sendMessage(spl + "報酬として100000円を獲得しました。");
            }
        }else if(p.hasPermission("group.diamond-1")){//D-2
            if(point >= 416100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§bdiamond-2§6になりました。");
                economy.depositPlayer(p,200000);
                p.sendMessage(spl + "報酬として200000円を獲得しました。");
            }
        }else if(p.hasPermission("group.diamond-2")){//D-3
            if(point >= 816100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§bdiamond-3§6になりました。");
                economy.depositPlayer(p,400000);
                p.sendMessage(spl + "報酬として400000円を獲得しました。");
            }
        }else if(p.hasPermission("group.diamond-3")){//N-1
            if(point >= 1416100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§cnetherite-1§6になりました。");
                economy.depositPlayer(p,600000);
                p.sendMessage(spl + "報酬として600000円を獲得しました。");
                p.sendMessage(spl + "netheriteランクに昇格したため以下の機能が解放されました");
                p.sendMessage(spl + "・flyコマンドの無料化");
            }
        }else if(p.hasPermission("group.netherite-1")){//N-2
            if(point > 2216100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§cnetherite-2§6になりました。");
                economy.depositPlayer(p,800000);
                p.sendMessage(spl + "報酬として800000円を獲得しました。");
            }
        }else if(p.hasPermission("group.netherite-2")){//N-3
            if(point >= 3116100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§cnetherite-3§6になりました。");
                economy.depositPlayer(p,900000);
                p.sendMessage(spl + "報酬として900000円を獲得しました。");
            }
        }else if(p.hasPermission("group.netherite-3")){//N-3
            if(point >= 4116100) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.professional-crafter");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§eprofessional-crafter§6なりました!!!!!!!!");
                economy.depositPlayer(p,1000000);
                p.sendMessage(spl + "報酬として1000000円を獲得しました。");
            }
        }else if(p.hasPermission("group.professional-crafter")){
            if(point >= 14116100){
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.master");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§cMASTER§6なりました!!!!!!!!");
                p.sendMessage(spl + "報酬いらないでしょ");
            }
        }else if(p.hasPermission("group.master")){
            if(point >= 114116100){
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.emperor");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.master");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§bEMPEROR§6なりました!!!!!!!!");
                p.sendMessage(spl + "報酬いらないでしょ");
            }
        }else if(p.hasPermission("group.emperor")){
            if(point >= 314116100){
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.god");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.emperor");
                Bukkit.broadcastMessage("§b[§aspl§b]§6 " + p.getName() + "が§bEMPEROR§6なりました!!!!!!!!");
                p.sendMessage(spl + "報酬いらないでしょ");
            }
        }

      //  Scoreboards sb = new Scoreboards();
       // sb.onSBs(p);

    }
}
