package dev.temez.commander.commons.exception.handler;

import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.execution.CommandExecution;
import org.jetbrains.annotations.NotNull;

public interface CommanderExceptionHandler {

  void handle(@NotNull CommandExecution execution, @NotNull ConformableException exception);
}
