package net.rmplugins.rmautomessage.annotation;

import java.lang.annotation.*;

/**
 * @author Levi Marvin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    String permission() default "pxam.default";
}
