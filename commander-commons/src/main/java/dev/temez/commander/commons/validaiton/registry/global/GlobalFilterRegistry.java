package dev.temez.commander.commons.validaiton.registry.global;

import dev.temez.commander.commons.exception.FormattedException;
import dev.temez.commander.commons.validaiton.simple.SimpleCommandFilter;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

public interface GlobalFilterRegistry {

  @NotNull @Unmodifiable List<SimpleCommandFilter> getRegisteredFilters();

  void register(@NotNull SimpleCommandFilter filter) throws FormattedException;
}
