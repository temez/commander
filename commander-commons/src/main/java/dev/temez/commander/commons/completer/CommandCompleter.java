package dev.temez.commander.commons.completer;

import dev.temez.commander.commons.execution.CommandExecution;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public interface CommandCompleter {

  @NotNull @Unmodifiable List<String> complete(
      @NotNull CommandExecution commandExecution
  );

  @NotNull @Unmodifiable List<String> completeSorted(
      @NotNull CommandExecution commandExecution
  );
}
