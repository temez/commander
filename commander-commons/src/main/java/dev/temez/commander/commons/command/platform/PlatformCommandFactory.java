package dev.temez.commander.commons.command.platform;

import dev.temez.commander.commons.command.RegisteredCommand;
import org.jetbrains.annotations.NotNull;

public interface PlatformCommandFactory {

  @NotNull PlatformCommand create(@NotNull RegisteredCommand registeredCommand);
}
