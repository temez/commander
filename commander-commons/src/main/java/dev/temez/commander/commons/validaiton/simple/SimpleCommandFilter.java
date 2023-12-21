package dev.temez.commander.commons.validaiton.simple;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.sender.Sender;
import org.jetbrains.annotations.NotNull;

public interface SimpleCommandFilter {

  void filter(
      @NotNull RegisteredCommand command,
      @NotNull Sender<?> sender
  ) throws ConformableException;
}
