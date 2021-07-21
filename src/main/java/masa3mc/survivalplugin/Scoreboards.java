package masa3mc.survivalplugin;

import fr.mrmicky.fastboard.FastBoard;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Scoreboards {

    public void onDisplay(FastBoard board){
        board.updateLines(
                "§7┌────────",
                "§7├─§9World",
                "" + world(board.getPlayer()),
                "§7├─§aDirection",
                "" + direction(board.getPlayer()),
                "§7├─§eMoney",
                "" + money(board.getPlayer()),
                "§7├─§cX-Y-Z",
                "" + xyz(board.getPlayer()),
                "§7├─§bRank",
                "" + rank(board.getPlayer()),
                "" + rankpoint(board.getPlayer()),
                "§7└────────"

        );
    }

    private String rankpoint(Player player) {
        String point = "§7│ §f"+ Events.point.get(player.getName()) + " point";
        return point;
    }

    private String world(Player player) {
        String wo;
        if (player.getWorld() == Bukkit.getWorld("Main")) {
            wo = "§7│ §fメインワールド";
        } else if (player.getWorld() == Bukkit.getWorld("lobby_the_end")) {
            wo = "§7│ §fエンドワールド";
        } else if (player.getWorld() == Bukkit.getWorld("lobby_nether")) {
            wo = "§7│ §fネザーワールド";
        } else if (player.getWorld() == Bukkit.getWorld("resource")) {
            wo = "§7│ §f資源ワールド";
        } else if (player.getWorld() == Bukkit.getWorld("lobby")) {
            wo = "§7│ §fロビー";
        } else if (player.getWorld() == Bukkit.getWorld("shop")) {
            wo = "§7│ §fユーザーショップ";
        } else if (player.getWorld() == Bukkit.getWorld("tutorial")) {
            wo = "§7│ §fチュートリアル";
        } else if (player.getWorld() == Bukkit.getWorld("PvP")) {
            wo = "§7│ §fPvP";
        } else {
            wo = "§7│ §6null";
        }
        return wo;
    }

    private String direction(Player player) {
        String dir;
        double rotation = (player.getLocation().getYaw() - 90) % 360;
        if (rotation < 0) {
            rotation += 360.0;
        }
        if (0 <= rotation && rotation < 22.5) {
            dir = "§7│ §f西";
        } else if (22.5 <= rotation && rotation < 67.5) {
            dir = "§7│ §f北西";
        } else if (67.5 <= rotation && rotation < 112.5) {
            dir = "§7│ §f北";
        } else if (112.5 <= rotation && rotation < 157.5) {
            dir = "§7│ §f北東";
        } else if (157.5 <= rotation && rotation < 202.5) {
            dir = "§7│ §f東";
        } else if (202.5 <= rotation && rotation < 247.5) {
            dir = "§7│ §f南東";
        } else if (247.5 <= rotation && rotation < 292.5) {
            dir = "§7│ §f南";
        } else if (292.5 <= rotation && rotation < 337.5) {
            dir = "§7│ §f南西";
        } else if (337.5 <= rotation && rotation < 360.0) {
            dir = "§7│ §f西";
        } else {
            dir = "§7│§fnull";
        }
        return dir;
    }

    private String money(Player player) {
        Economy economy = SurvivalPlugin.getEconomy();
        String money = "§7│ §f" + economy.format(economy.getBalance(player));
        return money;
    }

    private String xyz(Player player) {
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();
        String zahyou = "§7│ §f" + x + "," + y + "," + z;
        return zahyou;
    }

    private String rank(Player player) {
        String rn;
        if(player.hasPermission("spl.admin")){
            rn = "§7│ §cAdmin";
        }else if(player.hasPermission("group.beginner")){
            rn = "§7│ §fBeginner";
        }else if(player.hasPermission("group.regular-1")){
            rn = "§7│ §aRegular-1";
        }else if(player.hasPermission("group.regular-2")){
            rn = "§7│ §aRegular-2";
        }else if(player.hasPermission("group.regular-3")){
            rn = "§7│ §aRegular-3";
        }else if(player.hasPermission("group.iron-1")){
            rn = "§7│ §7Iron-1";
        }else if(player.hasPermission("group.iron-2")){
            rn = "§7│ §7Iron-2";
        }else if(player.hasPermission("group.iron-3")){
            rn = "§7│ §7Iron-3";
        }else if(player.hasPermission("group.gold-1")){
            rn = "§7│ §6Gold-1";
        }else if(player.hasPermission("group.gold-2")){
            rn = "§7│ §6Gold-2";
        }else if(player.hasPermission("group.gold-3")){
            rn = "§7│ §6Gold-3";
        }else if(player.hasPermission("group.diamond-1")){
            rn = "§7│ §bDiamond-1";
        }else if(player.hasPermission("group.diamond-2")){
            rn = "§7│ §bDiamond-2";
        }else if(player.hasPermission("group.diamond-3")){
            rn = "§7│ §bDiamond-3";
        }else if(player.hasPermission("group.netherite-1")){
            rn = "§7│ §cNetherite-1";
        }else if(player.hasPermission("group.netherite-2")){
            rn = "§7│ §cNetherite-2";
        }else if(player.hasPermission("group.netherite-3")){
            rn = "§7│ §cNetherite-3";
        }else {
            rn = "§7│ §eproCrafter";
        }
        return rn;
    }
}
