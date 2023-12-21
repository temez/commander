package dev.temez.commander.commons.execution;

import dev.temez.commander.commons.command.RegisteredCommand;
import org.jetbrains.annotations.NotNull;

public interface CommandExecutionFactory {

  @NotNull CommandExecution createExecution(
      @NotNull RegisteredCommand registeredCommand,
      Object @NotNull ... objects
  );

}
