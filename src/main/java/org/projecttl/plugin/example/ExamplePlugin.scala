package org.projecttl.plugin.example

import org.bukkit.configuration.file.{FileConfiguration, YamlConfiguration}
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.example.commands.ExampleCommand
import org.projecttl.plugin.example.listeners.ExampleListener

import java.io.File

class ExamplePlugin extends JavaPlugin {

  private var configFile: File = _
  private var configuration: FileConfiguration = _
  private val manager: PluginManager = getServer.getPluginManager

  override def onEnable(): Unit = {
    load()
    getLogger.info("Plugin enabled")

    getCommand("example").setExecutor(new ExampleCommand)
    manager.registerEvents(new ExampleListener, this)
  }

  override def onDisable(): Unit = {
    save()
    getLogger.info("Plugin disabled")
  }

  private def load(): Unit = {
    configFile = new File(getDataFolder, "config.yml")
    configuration = YamlConfiguration.loadConfiguration(configFile)

    try {
      if (!configFile.exists()) {
        configuration.save(configFile)
      }

      configuration.load(configFile)
    } catch {
      case exception: Exception => exception.printStackTrace()
    }
  }

  private def save(): Unit = {
    try {
      configuration.save(configFile)
    } catch {
      case exception: Exception => exception.printStackTrace()
    }
  }

  def getExampleConfig: FileConfiguration = {
    configuration
  }
}
