package dev.temez.commander.velocity.command;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.temez.commander.commons.command.RegisteredCommand;
import dev.temez.commander.commons.command.platform.PlatformCommand;
import dev.temez.commander.commons.completer.CommandCompleter;
import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.exception.handler.CommanderExceptionHandler;
import dev.temez.commander.commons.execution.CommandExecution;
import dev.temez.commander.commons.execution.CommandExecutionFactory;
import dev.temez.commander.commons.executor.CommandExecutor;
import dev.temez.commander.commons.validaiton.CommandFilterService;
import dev.temez.commander.velocity.execution.VelocityExecutionFactory;
import dev.temez.commander.velocity.sender.VelocityCommandSender;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

@Builder
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class CommanderVelocityCommand implements SimpleCommand, PlatformCommand {

  @NotNull CommandExecutionFactory executionFactory = new VelocityExecutionFactory();

  @NotNull RegisteredCommand command;

  @NotNull CommandFilterService commandFilterService;

  @NotNull CommandCompleter commandCompleter;

  @NotNull CommandExecutor commandExecutor;

  @NotNull CommanderExceptionHandler exceptionHandler;

  @Override
  public void register(Object @NotNull ... args) {
    ((ProxyServer) args[0]).getCommandManager().register(
        command.getName(),
        this,
        command.getAlias().toArray(new String[0])
    );
  }

  @Override
  public void execute(@NotNull Invocation invocation) {
    CommandExecution execution = executionFactory.createExecution(
        command,
        invocation
    );
    try {
      commandFilterService.validate(command, execution.getCommandSender());
      commandExecutor.execute(execution);
    } catch (ConformableException exception) {
      exceptionHandler.handle(execution, exception);
    }
  }

  @Override
  public @NotNull @Unmodifiable List<String> suggest(Invocation invocation) {
    CommandExecution execution = executionFactory.createExecution(
        command,
        invocation
    );
    return commandCompleter.completeSorted(execution);
  }

  @Override
  public boolean hasPermission(@NotNull Invocation invocation) {
    return commandFilterService.isAccessible(
        new VelocityCommandSender(invocation.source()),
        command
    );
  }
}
