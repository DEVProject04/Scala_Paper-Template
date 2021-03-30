package org.projecttl.plugin.example.commands

import org.bukkit.command.{Command, CommandExecutor, CommandSender}
import org.bukkit.entity.Player

class ExampleCommand extends CommandExecutor {

  override def onCommand(sender: CommandSender, command: Command, label: String, args: Array[String]): Boolean = {
    if (!sender.isInstanceOf[Player]) {
      return false
    } else {
      val player: Player = sender.asInstanceOf[Player]

      if (command.getName.equalsIgnoreCase("example")) {
        if (args.length == 0) {
          player.sendMessage("Example Test!")
          return true
        } else if (args.length > 0) {
            if (args(0).equalsIgnoreCase("test")) {
              player.sendMessage(s"Hello, ${player.getName}!")
              return true
            }
        }
      }
    }

    false
  }
}
