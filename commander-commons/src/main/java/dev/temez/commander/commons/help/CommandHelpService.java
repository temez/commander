package dev.temez.commander.commons.help;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.sender.Sender;
import org.jetbrains.annotations.NotNull;

public interface CommandHelpService {

  void sendHelpMessage(@NotNull Sender<?> sender, @NotNull RegisteredCommand command);

}
