
package masa3mc.survivalplugin.Commands.Rank;

import masa3mc.survivalplugin.DBcontrol;
import masa3mc.survivalplugin.Events;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        sender.sendMessage("現在使用不可");
        return true;
        /*
        if(sender instanceof Player){
            if(args.length == 0){
                Player player = ((Player) sender).getPlayer();
                String rank;
                long point = Events.point.get(player.getName());
                long NextRank;
                if(point < 100){
                    rank = "§fBeginner";
                    NextRank = 100;
                }else if(point < 1100){
                    rank = "§aregular-1";
                    NextRank = 1100;
                }else if(point < 3100){
                    rank = "§aregular-2";
                    NextRank = 3100;
                }else if(point < 6100){
                    rank = "§aregular-3";
                    NextRank = 6100;
                }else if(point < 11100){
                    rank = "§7Iron-1";
                    NextRank = 11100;
                }else if(point < 21100){
                    rank = "§7Iron-2";
                    NextRank = 21100;
                }else if(point < 36100){
                    rank = "§7Iron-3";
                    NextRank = 36100;
                }else if(point < 66100){
                    rank = "§6Gold-1";
                    NextRank = 66100;
                }else if(point < 116100){
                    rank = "§6Gold-2";
                    NextRank = 116100;
                }else if(point < 216100){
                    rank = "§6Gold-3";
                    NextRank = 216100;
                }else if(point < 416100){
                    rank = "§bDiamond-1";
                    NextRank = 416100;
                }else if(point < 816100){
                    rank = "§bDiamond-2";
                    NextRank = 816100;
                }else if(point < 1416100){
                    rank = "§bDiamond-3";
                    NextRank = 1416100;
                }else if(point < 2216100){
                    rank = "§cNetherite-1";
                    NextRank = 2216100;
                }else if(point < 3116100){
                    rank = "§cNetherite-2";
                    NextRank = 3116100;
                }else if(point < 4116100){
                    rank = "§cNetherite-3";
                    NextRank = 4116100;
                }else {
                    rank = "§eprofessional-crafter";
                    DBcontrol dBcontrol = new DBcontrol();
                    NextRank = dBcontrol.get(player.getUniqueId(), false);
                }
                player.sendMessage("§6"+player.getName()+"のランク情報");
                player.sendMessage("§bRank:"+rank);
                player.sendMessage("§b獲得済みポイント");
                player.sendMessage("§a" + point + "point");
                player.sendMessage("§b次のランクまでのポイント");
                player.sendMessage("§a" + (NextRank - point) + "point");
                return true;
            }else if(args.length == 1){

                Player players = ((Player) sender).getPlayer();
                Player player = Bukkit.getServer().getPlayerExact(args[0]);
                if(player != null){
                    String rank;
                    long point = Events.point.get(player.getName());
                    long NextRank;
                    if (point < 100) {
                        rank = "§fBeginner";
                        NextRank = 100;
                    } else if (point < 1100) {
                        rank = "§aregular-1";
                        NextRank = 1100;
                    } else if (point < 3100) {
                        rank = "§aregular-2";
                        NextRank = 3100;
                    } else if (point < 6100) {
                        rank = "§aregular-3";
                        NextRank = 6100;
                    } else if (point < 11100) {
                        rank = "§7Iron-1";
                        NextRank = 11100;
                    } else if (point < 21100) {
                        rank = "§7Iron-2";
                        NextRank = 21100;
                    } else if (point < 36100) {
                        rank = "§7Iron-3";
                        NextRank = 36100;
                    } else if (point < 66100) {
                        rank = "§6Gold-1";
                        NextRank = 66100;
                    } else if (point < 116100) {
                        rank = "§6Gold-2";
                        NextRank = 116100;
                    } else if (point < 216100) {
                        rank = "§6Gold-3";
                        NextRank = 216100;
                    } else if (point < 416100) {
                        rank = "§bDiamond-1";
                        NextRank = 416100;
                    } else if (point < 816100) {
                        rank = "§bDiamond-2";
                        NextRank = 816100;
                    } else if (point < 1416100) {
                        rank = "§bDiamond-3";
                        NextRank = 1416100;
                    } else if (point < 2216100) {
                        rank = "§cNetherite-1";
                        NextRank = 2216100;
                    } else if (point < 3116100) {
                        rank = "§cNetherite-2";
                        NextRank = 3116100;
                    } else if (point < 4116100) {
                        rank = "§cNetherite-3";
                        NextRank = 4116100;
                    } else {
                        rank = "§eprofessional-crafter";
                        DBcontrol dBcontrol = new DBcontrol();
                        NextRank = dBcontrol.get(player.getUniqueId(), false);
                    }
                    players.sendMessage("§6" + player.getName() + "のランク情報");
                    players.sendMessage("§bRank:" + rank);
                    players.sendMessage("§b獲得済みポイント");
                    players.sendMessage("§a" + point + "point");
                    players.sendMessage("§b次のランクまでのポイント");
                    players.sendMessage("§a" + (NextRank - point) + "point");
                }else {
                    DBcontrol dBcontrol = new DBcontrol();
                    OfflinePlayer ofp = Bukkit.getOfflinePlayer(args[0]);
                    if(ofp.hasPlayedBefore()){
                        String rank;
                        long point = dBcontrol.get(ofp.getUniqueId(), false);
                        long NextRank;
                        if (ofp.isOp()) {
                            rank = "§cAdmin";
                            NextRank = NextRank = dBcontrol.get(ofp.getUniqueId(), false);;
                        } else if (point < 100) {
                            rank = "§fBeginner";
                            NextRank = 100;
                        } else if (point < 1100) {
                            rank = "§aregular-1";
                            NextRank = 1100;
                        } else if (point < 3100) {
                            rank = "§aregular-2";
                            NextRank = 3100;
                        } else if (point < 6100) {
                            rank = "§aregular-3";
                            NextRank = 6100;
                        } else if (point < 11100) {
                            rank = "§7Iron-1";
                            NextRank = 11100;
                        } else if (point < 21100) {
                            rank = "§7Iron-2";
                            NextRank = 21100;
                        } else if (point < 36100) {
                            rank = "§7Iron-3";
                            NextRank = 36100;
                        } else if (point < 66100) {
                            rank = "§6Gold-1";
                            NextRank = 66100;
                        } else if (point < 116100) {
                            rank = "§6Gold-2";
                            NextRank = 116100;
                        } else if (point < 216100) {
                            rank = "§6Gold-3";
                            NextRank = 216100;
                        } else if (point < 416100) {
                            rank = "§bDiamond-1";
                            NextRank = 416100;
                        } else if (point < 816100) {
                            rank = "§bDiamond-2";
                            NextRank = 816100;
                        } else if (point < 1416100) {
                            rank = "§bDiamond-3";
                            NextRank = 1416100;
                        } else if (point < 2216100) {
                            rank = "§cNetherite-1";
                            NextRank = 2216100;
                        } else if (point < 3116100) {
                            rank = "§cNetherite-2";
                            NextRank = 3116100;
                        } else if (point < 4116100) {
                            rank = "§cNetherite-3";
                            NextRank = 4116100;
                        } else {
                            rank = "§eprofessional-crafter";
                            NextRank = dBcontrol.get(ofp.getUniqueId(), false);
                        }
                        players.sendMessage("§6" + ofp.getName() + "のランク情報");
                        players.sendMessage("§bRank:" + rank);
                        players.sendMessage("§b獲得済みポイント");
                        players.sendMessage("§a" + point + "point");
                        players.sendMessage("§b次のランクまでのポイント");
                        players.sendMessage("§a" + (NextRank - point) + "point");
                    }else {
                        players.sendMessage("§b[§aspl§b]§r §cアカウントが存在しません。");
                    }
                }
                return true;
            }
        }else {
            if(args.length == 1) {
                DBcontrol dBcontrol = new DBcontrol();
                Player player = Bukkit.getServer().getPlayerExact(args[0]);
                if(player != null){
                    String rank;
                    long point = Events.point.get(player.getName());
                    long NextRank;
                    if (player.hasPermission("spl.admin")) {
                        rank = "§cAdmin";
                        NextRank = dBcontrol.get(player.getUniqueId(), false);
                    } else if (point < 100) {
                        rank = "§fBeginner";
                        NextRank = 100;
                    } else if (point < 1100) {
                        rank = "§aregular-1";
                        NextRank = 1100;
                    } else if (point < 3100) {
                        rank = "§aregular-2";
                        NextRank = 3100;
                    } else if (point < 6100) {
                        rank = "§aregular-3";
                        NextRank = 6100;
                    } else if (point < 11100) {
                        rank = "§7Iron-1";
                        NextRank = 11100;
                    } else if (point < 21100) {
                        rank = "§7Iron-2";
                        NextRank = 21100;
                    } else if (point < 36100) {
                        rank = "§7Iron-3";
                        NextRank = 36100;
                    } else if (point < 66100) {
                        rank = "§6Gold-1";
                        NextRank = 66100;
                    } else if (point < 116100) {
                        rank = "§6Gold-2";
                        NextRank = 116100;
                    } else if (point < 216100) {
                        rank = "§6Gold-3";
                        NextRank = 216100;
                    } else if (point < 416100) {
                        rank = "§bDiamond-1";
                        NextRank = 416100;
                    } else if (point < 816100) {
                        rank = "§bDiamond-2";
                        NextRank = 816100;
                    } else if (point < 1416100) {
                        rank = "§bDiamond-3";
                        NextRank = 1416100;
                    } else if (point < 2216100) {
                        rank = "§cNetherite-1";
                        NextRank = 2216100;
                    } else if (point < 3116100) {
                        rank = "§cNetherite-2";
                        NextRank = 3116100;
                    } else if (point < 4116100) {
                        rank = "§cNetherite-3";
                        NextRank = 4116100;
                    } else {
                        rank = "§eprofessional-crafter";
                        NextRank = dBcontrol.get(player.getUniqueId(), false);
                    }
                    sender.sendMessage("§6" + player.getName() + "のランク情報");
                    sender.sendMessage("§bRank:" + rank);
                    sender.sendMessage("§b獲得済みポイント");
                    sender.sendMessage("§a" + point + "point");
                    sender.sendMessage("§b次のランクまでのポイント");
                    sender.sendMessage("§a" + (NextRank - point) + "point");
                }else {
                    OfflinePlayer ofp = Bukkit.getOfflinePlayer(args[0]);
                    if(ofp.hasPlayedBefore()){
                        String rank;
                        long point = PointYml.get().getInt("Point." + ofp.getUniqueId());
                        long NextRank;
                        if (point < 100) {
                            rank = "§fBeginner";
                            NextRank = 100;
                        } else if (point < 1100) {
                            rank = "§aregular-1";
                            NextRank = 1100;
                        } else if (point < 3100) {
                            rank = "§aregular-2";
                            NextRank = 3100;
                        } else if (point < 6100) {
                            rank = "§aregular-3";
                            NextRank = 6100;
                        } else if (point < 11100) {
                            rank = "§7Iron-1";
                            NextRank = 11100;
                        } else if (point < 21100) {
                            rank = "§7Iron-2";
                            NextRank = 21100;
                        } else if (point < 36100) {
                            rank = "§7Iron-3";
                            NextRank = 36100;
                        } else if (point < 66100) {
                            rank = "§6Gold-1";
                            NextRank = 66100;
                        } else if (point < 116100) {
                            rank = "§6Gold-2";
                            NextRank = 116100;
                        } else if (point < 216100) {
                            rank = "§6Gold-3";
                            NextRank = 216100;
                        } else if (point < 416100) {
                            rank = "§bDiamond-1";
                            NextRank = 416100;
                        } else if (point < 816100) {
                            rank = "§bDiamond-2";
                            NextRank = 816100;
                        } else if (point < 1416100) {
                            rank = "§bDiamond-3";
                            NextRank = 1416100;
                        } else if (point < 2216100) {
                            rank = "§cNetherite-1";
                            NextRank = 2216100;
                        } else if (point < 3116100) {
                            rank = "§cNetherite-2";
                            NextRank = 3116100;
                        } else if (point < 4116100) {
                            rank = "§cNetherite-3";
                            NextRank = 4116100;
                        } else {
                            rank = "§eprofessional-crafter";
                            NextRank = PointYml.get().getInt("Point." + ofp.getUniqueId());
                        }
                        sender.sendMessage("§6" + ofp.getName() + "のランク情報");
                        sender.sendMessage("§bRank:" + rank);
                        sender.sendMessage("§b獲得済みポイント");
                        sender.sendMessage("§a" + point + "point");
                        sender.sendMessage("§b次のランクまでのポイント");
                        sender.sendMessage("§a" + (NextRank - point) + "point");
                    }else {
                        sender.sendMessage("§b[§aspl§b]§r §cアカウントが存在しません。");
                    }
                }
            return true;
            }else {
                sender.sendMessage("§b[§aspl§b]§r §c/rank [player]");
                return true;
            }
        }
        return false;

         */
    }

}