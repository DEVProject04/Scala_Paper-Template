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
        args.length match {
          case 0 =>
            player.sendMessage("Example Test!")

          case 1 =>
            if (args(0).equalsIgnoreCase("test")) {
              player.sendMessage(s"Hello, ${player.getName}!")
            }
        }
      }
    }

    false
  }
}
