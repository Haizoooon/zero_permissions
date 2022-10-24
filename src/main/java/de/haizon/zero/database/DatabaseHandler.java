package de.haizon.zero.database;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * JavaDoc this file!
 * Created: 07.10.2022
 *
 * @author Haizoooon (maxhewa@gmail.com)
 */
public class DatabaseHandler {

    private final Connection connection;

    public DatabaseHandler() {

        String host = "";
        String port = "";
        String database = "";
        String username = "";
        String password = "";

        try {
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?enabledTLSProtocols=TLSv1.2", username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    
    public void update(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Object> getListFromTable(String table, String column, String value, String neededValue) {
        List<Object> list = Lists.newArrayList();
        try {
            ResultSet resultSet = query("SELECT * FROM " + table + " WHERE " + column + "='" + value + "'");
            while (resultSet.next()){
                list.add(resultSet.getString(neededValue));
            }
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Object> getListFromTable(String table, String neededValue) {
        List<Object> list = Lists.newArrayList();
        try {
            ResultSet resultSet = query("SELECT * FROM " + table);
            while (resultSet.next()){
                list.add(resultSet.getString(neededValue));
            }
            resultSet.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ResultSet query(String query) {
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public boolean existsInTable(String table, String key, String value) {
        try {
            return query("SELECT * FROM " + table + " WHERE " + key + "='" + value + "'").next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createTable(String table, Map<String, DatabaseType> content) {
        StringBuilder update = new StringBuilder("CREATE TABLE IF NOT EXISTS `").append(table).append("` (`");
        int count = 0;
        for (String key : content.keySet()) {
            update.append(key).append("` ").append(content.get(key).getDisplay()).append(count + 1 >= content.size() ? ")" : ", `");
            count++;
        }
        update(update.toString());
    }

    public Map<String, DatabaseType> getTableInformation(String[] keys, DatabaseType[] types) {
        Map<String, DatabaseType> content = Maps.newConcurrentMap();
        for(int i = 0; i < keys.length; i++) content.put(keys[i], types[i]);
        return content;
    }

    public void addMoreInTable(String table, List<String> types, List<Object> list) {
        StringBuilder upload = new StringBuilder("INSERT INTO " + table + "(" + types.get(0));
        for (int i = 1; i < types.size(); i++) upload.append(", ").append(types.get(i));
        upload.append(") VALUES ('").append(list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++) upload.append(", '").append(list.get(i)).append("'");
        upload.append(");");
        update(upload.toString());
    }
    
    public void updateInTable(String table, String keyRow, String keyValue, String setRow, Object setValue) {
        update("UPDATE " + table + " SET " + setRow + "= '" + setValue + "' WHERE " + keyRow + "= '" + keyValue + "';");
    }

    public int getTablePosition(String table, String type, String key, String searchBY) {
        try {
            ResultSet resultSet = query("SELECT * FROM " + table + " ORDER BY " + searchBY + " DESC");
            while (resultSet.next()) {
                if (resultSet.getString(type).equalsIgnoreCase(key)) {
                    return resultSet.getRow();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void removeAllFromTable(String table, String column, String value) {
        update("DELETE FROM " + table + " WHERE " + column + "='" + value + "';");
    }


    public Object getFromTable(String table, String column, String value, String neededColumn) {
        try {
            ResultSet resultSet = query("SELECT * FROM " + table + " WHERE " + column + "='" + value + "'");
            if(resultSet.next()){
                return resultSet.getString(neededColumn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
