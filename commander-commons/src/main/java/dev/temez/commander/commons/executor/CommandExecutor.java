package dev.temez.commander.commons.executor;

import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.execution.CommandExecution;
import org.jetbrains.annotations.NotNull;

public interface CommandExecutor {

  void execute(@NotNull CommandExecution commandExecution) throws ConformableException;

}
