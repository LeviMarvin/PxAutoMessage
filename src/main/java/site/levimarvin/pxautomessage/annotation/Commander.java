package site.levimarvin.pxautomessage.annotation;

import java.lang.annotation.*;

/**
 * @author Levi Marvin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Commander {
    String only() default "everyone";
}
