package de.haizon.zero.config;
/*

  » eu.kyro.citybuild.utils.config

  » Methode/Class coded by Haizoooon#6495
  » This Class/Source cannot be modified without permission.
  » Please refrain from recoding
  » Questions may be asked in Discord
  
  » Package coded at: 06.03.2021 / 14:50
  
 */

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.*;

public abstract class IConfig {

    public File file;
    private String resourceName;
    private Plugin plugin;
    private FileConfiguration fileConfiguration;

    public IConfig(String resourceName, Plugin plugin) {
        this.resourceName = resourceName;
        this.plugin = plugin;
        create();
    }

    public void create(){
        try {
            file = new File(plugin.getDataFolder(), resourceName);
            fileConfiguration = new YamlConfiguration();
            if(!file.canExecute()){
                file.getParentFile().mkdirs();
                copy(plugin.getResource(resourceName));
            }
            fileConfiguration.load(file);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    private void copy(InputStream inputStream){
        try {
            OutputStream outputStream = new FileOutputStream(file);
            byte[] buf = new byte[1024];
            int length;
            while ((length = inputStream.read(buf)) > 0){
                outputStream.write(buf, 0, length);
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
