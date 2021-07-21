package masa3mc.survivalplugin.RankUpDown;

import masa3mc.survivalplugin.Events;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Rankdown {

    public void UserRankDown(Player p){
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        long point = Events.point.get(p.getName());

        if(p.hasPermission("spl.admin")){
            return;
        }else//R-1
            if(point < 101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.beginner");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");

        }else //R-2
            if(point < 1101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.regular-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else //R-3
            if(point < 3101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.regular-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.regular-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//I-1
            if(point < 6101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set regular.regular-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//I-2
            if(point < 11101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.iron-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//I-3
            if(point < 21101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.iron-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//G-1
            if(point < 36101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.iron-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//G-2
            if(point < 66101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.gold-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else //G-3
            if(point < 116101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.gold-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//D-1
            if(point < 216101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.gold-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//D-2
            if(point < 416101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.diamond-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//D-3
            if(point < 816101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.diamond-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//N-1
            if(point < 1416101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.diamond-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//N-2
            if(point < 2216101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.netherite-1");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//N-3
            if(point < 3116101) {
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.netherite-2");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.netherite-3");
                Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }else//N-3
                if (point < 4116101) {
                    Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission set group.netherite-3");
                    Bukkit.dispatchCommand(console, "lp user " + p.getName() + " permission unset group.professional-crafter");
        }
    }
}
