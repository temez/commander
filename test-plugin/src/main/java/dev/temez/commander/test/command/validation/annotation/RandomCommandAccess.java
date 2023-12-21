package dev.temez.commander.test.command.validation.annotation;

import dev.temez.commander.commons.annotation.validation.ValidateWith;
import dev.temez.commander.test.command.validation.RandomCommandAccessFilter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.Order;

@ValidateWith(RandomCommandAccessFilter.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Order(1)
public @interface RandomCommandAccess {

  int value();
}
