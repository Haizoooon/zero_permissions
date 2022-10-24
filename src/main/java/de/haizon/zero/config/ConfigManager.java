package de.haizon.zero.config;
/*

  » eu.kyro.citybuild.utils.config

  » Methode/Class coded by Haizoooon#6495
  » This Class/Source cannot be modified without permission.
  » Please refrain from recoding
  » Questions may be asked in Discord
  
  » Package coded at: 06.03.2021 / 14:50
  
 */

import org.bukkit.plugin.Plugin;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigManager extends IConfig{

    private String content;

    public ConfigManager(String resourceName, Plugin plugin) {
        super(resourceName, plugin);

        try {
            content = new String(Files.readAllBytes(Paths.get(file.toURI())), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public String getString(String property) {
        JSONObject jsonObject = new JSONObject(content);
        return jsonObject.getString(property);
    }

    public String getString(String array, String property){
        JSONObject jsonObject = new JSONObject(content);
        JSONObject propertyObject = jsonObject.getJSONObject(array);
        return propertyObject.getString(property);
    }

}
