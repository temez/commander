package dev.temez.commander.commons.initializer;

import dev.temez.commander.commons.validaiton.CommandFilter;
import dev.temez.commander.commons.validaiton.registry.CommandFilterRegistry;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public final class CommandFilterInitializer implements BeanPostProcessor {

  @NotNull CommandFilterRegistry commandFilterRegistry;

  @Lazy
  public CommandFilterInitializer(@NotNull CommandFilterRegistry commandFilterRegistry) {
    this.commandFilterRegistry = commandFilterRegistry;
  }

  @Override
  public @NotNull Object postProcessAfterInitialization(@NotNull Object bean,
                                                        @NotNull String beanName) {
    if (bean instanceof CommandFilter<?> commandFilter) {
      commandFilterRegistry.register(commandFilter);
    }
    return bean;
  }
}
