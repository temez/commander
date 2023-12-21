package dev.temez.commander.commons.execution.preprocessor;

import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.execution.CommandExecution;
import org.jetbrains.annotations.NotNull;

public interface ExecutionPreprocessor {

  void process(@NotNull CommandExecution execution) throws ConformableException;
}
