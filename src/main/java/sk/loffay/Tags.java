package sk.loffay;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Pavol Loffay
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface Tags {
    String[] value();
}
