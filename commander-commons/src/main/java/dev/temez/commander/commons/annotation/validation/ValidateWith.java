package dev.temez.commander.commons.annotation.validation;

import dev.temez.commander.commons.validaiton.CommandFilter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.ANNOTATION_TYPE)
public @interface ValidateWith {

  @NotNull Class<? extends CommandFilter<?>> value();
}
