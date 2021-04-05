package site.levimarvin.pxautomessage.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Permission {
    String permission() default "pxam.default";
}
