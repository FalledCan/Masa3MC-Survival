package masa3mc.survivalplugin;

import fr.mrmicky.fastboard.FastBoard;
import masa3mc.survivalplugin.Commands.Fly.FlyCmd;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Run {
    public void crun(){
        BukkitRunnable task = new BukkitRunnable() {

            boolean save = true;
            Scoreboards scoreboards = new Scoreboards();
            @Override
            public void run() {

                for(FastBoard board : SurvivalPlugin.boards.values()) {
                    scoreboards.onDisplay(board);
                }

                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("mm:ss");
                if(df.format(date).equals("00:00") || df.format(date).equals("30:00")){
                    if(save) {
                        DBcontrol dBcontrol = new DBcontrol();
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            dBcontrol.update(player.getUniqueId(), String.valueOf(Events.point.get(player.getName())),null);
                            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + player.getName() + "のランクポイントを保存しましたぞい!");
                        }
                        save = false;
                    }
                }else if(!save){
                    save = true;
                }

                //get online Players
                for(Player player: Bukkit.getOnlinePlayers()){
                    //fly
                    if(FlyCmd.fly.get(player.getName()) != null) {
                        FlyCmd.fly.put(player.getName(), FlyCmd.fly.get(player.getName()) - 1);
                        if (FlyCmd.fly.get(player.getName()) == 200) {
                            player.sendMessage("§b[§aspl§b]§6flyモードが１０秒後にoffになります");
                        }
                        if (FlyCmd.fly.get(player.getName()) == 0) {
                            player.setAllowFlight(false);
                            player.sendMessage("§b[§aspl§b]§6flyモード off");
                            FlyCmd.fly.remove(player.getName());
                        }
                    }

                }

            }
        };
        task.runTaskTimer(SurvivalPlugin.getPlugin(), 0L, 2L);
    }
}
