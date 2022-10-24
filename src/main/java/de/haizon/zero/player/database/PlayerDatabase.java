package de.haizon.zero.player.database;

import de.haizon.zero.ZeroPermissions;
import de.haizon.zero.database.DatabaseHandler;
import de.haizon.zero.database.DatabaseType;
import org.bukkit.Bukkit;

import java.util.Arrays;

/**
 * JavaDoc this file!
 * Created: 24.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public class PlayerDatabase {

    private DatabaseHandler databaseHandler;

    public PlayerDatabase( ) {
        this.databaseHandler = ZeroPermissions.getInstance().getDatabaseHandler();
        databaseHandler.createTable("module_players", databaseHandler.getTableInformation(new String[]{"uniqueId", "group", "permissions"}, new DatabaseType[]{DatabaseType.VARCHAR, DatabaseType.VARCHAR, DatabaseType.TEXT}));

    }
}
