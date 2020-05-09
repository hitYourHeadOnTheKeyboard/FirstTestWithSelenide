package pages.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Page {
    String title();

    String url() default "https://dev.n7lanit.ru";
}
