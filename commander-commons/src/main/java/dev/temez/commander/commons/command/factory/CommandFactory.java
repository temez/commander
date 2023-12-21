package dev.temez.commander.commons.command.factory;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.exception.FormattedException;
import org.jetbrains.annotations.NotNull;

public interface CommandFactory {

  @NotNull RegisteredCommand get(@NotNull Object command) throws FormattedException;
}
