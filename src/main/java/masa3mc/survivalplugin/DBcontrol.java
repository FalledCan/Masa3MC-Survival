package masa3mc.survivalplugin;


import org.bukkit.Bukkit;

import java.sql.*;
import java.util.UUID;

public class DBcontrol {

    public static Statement stmt = null;

    public void loadDB(){

        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + Bukkit.getServer().getPluginManager().getPlugin("SurvivalPlugin").getDataFolder().getAbsolutePath() + "\\spl.db");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void insert(UUID uuid){

        try {
            stmt.executeUpdate("INSERT INTO players VALUES('" + uuid + "',0,0)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void update(UUID uuid, String rankpoint, String atm){
        if(rankpoint != null) {
            long rp = Long.parseLong(rankpoint);
            try {
                stmt.executeUpdate("update players set rankpoint = " + rp + " where uuid = '" + uuid + "'");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else {
            long atm_ = Long.parseLong(atm);
            try {
                stmt.executeUpdate("update players set atm = " + atm_ + " where uuid = '" + uuid + "'");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    public long get(UUID uuid, boolean atm){
        long rankpoint = 0; 
        long _atm = 0;
        try {
            ResultSet rs = stmt.executeQuery("select * from players where uuid = '" + uuid + "'");
            while (rs.next()){
                 rankpoint = rs.getLong("rankpoint");
                 _atm = rs.getLong("atm");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
        if (atm){
            return _atm;
        }else {
            return rankpoint;
        }
    }

}
