package dev.temez.commander.commons.command.registry;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.exception.FormattedException;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public interface CommandRegistry {

  void register(@NotNull Object commandExecutor) throws FormattedException;

  @NotNull RegisteredCommand get(@NotNull String name) throws FormattedException;

  @NotNull @Unmodifiable List<RegisteredCommand> getRegisteredCommands();
}
