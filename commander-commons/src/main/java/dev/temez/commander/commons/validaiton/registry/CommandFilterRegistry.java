package dev.temez.commander.commons.validaiton.registry;

import dev.temez.commander.commons.exception.FormattedException;
import dev.temez.commander.commons.validaiton.CommandFilter;
import java.lang.annotation.Annotation;
import org.jetbrains.annotations.NotNull;

public interface CommandFilterRegistry {

  @NotNull <T extends Annotation> CommandFilter<T> get(
      @NotNull Class<T> filterAnnotation
  ) throws FormattedException;

  void register(@NotNull CommandFilter<?> commandFilter) throws FormattedException;
}
