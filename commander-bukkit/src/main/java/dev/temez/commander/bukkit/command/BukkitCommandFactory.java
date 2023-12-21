package dev.temez.commander.bukkit.command;

import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.command.platform.PlatformCommand;
import dev.temez.commander.commons.command.platform.PlatformCommandFactory;
import dev.temez.commander.commons.completer.CommandCompleter;
import dev.temez.commander.commons.exception.handler.CommanderExceptionHandler;
import dev.temez.commander.commons.executor.CommandExecutor;
import dev.temez.commander.commons.validaiton.CommandFilterService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class BukkitCommandFactory implements PlatformCommandFactory {

  @NotNull CommandCompleter commandCompleter;

  @NotNull CommandFilterService commandFilterService;

  @NotNull CommandExecutor commandExecutor;

  @NotNull CommanderExceptionHandler exceptionHandler;

  @Override
  public @NotNull PlatformCommand create(@NotNull RegisteredCommand registeredCommand) {
    return CommanderBukkitCommand.builder()
        .command(registeredCommand)
        .exceptionHandler(exceptionHandler)
        .commandCompleter(commandCompleter)
        .commandExecutor(commandExecutor)
        .commandFilterService(commandFilterService)
        .build();
  }
}
