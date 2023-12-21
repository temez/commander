package dev.temez.commander.commons.help;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.sender.Sender;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public interface CommandHelpMessageFactory {

  @NotNull List<String> getHelpMessage(
      @NotNull Sender<?> sender,
      @NotNull RegisteredCommand command
  );
}
