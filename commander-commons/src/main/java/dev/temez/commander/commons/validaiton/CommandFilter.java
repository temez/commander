package dev.temez.commander.commons.validaiton;

import dev.temez.commander.commons.exception.ValidationException;
import dev.temez.commander.commons.sender.Sender;
import java.lang.annotation.Annotation;
import org.jetbrains.annotations.NotNull;

public interface CommandFilter<A extends Annotation> {


  @NotNull Class<A> getFilterAnnotationType();

  void filter(@NotNull Sender<?> sender, @NotNull A annotation) throws ValidationException;

}
