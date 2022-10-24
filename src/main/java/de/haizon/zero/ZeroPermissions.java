package de.haizon.zero;

import de.haizon.zero.database.DatabaseHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * JavaDoc this file!
 * Created: 23.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public class ZeroPermissions extends JavaPlugin {

    private static ZeroPermissions instance;

    private DatabaseHandler databaseHandler;

    @Override
    public void onEnable() {
        instance = this;

        databaseHandler = new DatabaseHandler();

    }

    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }

    public static ZeroPermissions getInstance() {
        return instance;
    }
}
