package dev.temez.commander.commons.execution.preprocessor.chain;

import dev.temez.commander.commons.exception.ConformableException;
import dev.temez.commander.commons.execution.CommandExecution;
import dev.temez.commander.commons.execution.preprocessor.ExecutionPreprocessor;
import org.jetbrains.annotations.NotNull;

public interface ExecutionPreprocessorChain {

  void register(@NotNull ExecutionPreprocessor executionPreprocessor);

  void process(@NotNull CommandExecution execution) throws ConformableException;
}
