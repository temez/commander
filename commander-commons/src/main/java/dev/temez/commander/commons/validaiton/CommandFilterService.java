package dev.temez.commander.commons.validaiton;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.exception.ValidationException;
import dev.temez.commander.commons.sender.Sender;
import org.jetbrains.annotations.NotNull;

public interface CommandFilterService {

  boolean isAccessible(@NotNull Sender<?> sender, @NotNull RegisteredCommand command);

  void validate(
      @NotNull RegisteredCommand command,
      @NotNull Sender<?> sender
  ) throws ValidationException;
}
