package net.omegaloader.config.annotations.metadata;

import java.lang.annotation.*;

/**
 * Attached commands on the config field
 *
 * <p>Value or i18n cannot be both empty, requires one definition of them</p>
 */
@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Comment.Comments.class)
public @interface Comment {
    /**
     * Can be placed in one annotation as an array or using multiple ones.
     * Ordering is up-to-down
     *
     * @return Comments for a field.
     */
    String[] value() default "";

    /**
     * Can be placed in one annotation as an array or using multiple ones.
     * Ordering is up-to-down
     *
     * @return Comments i18n for a field, empty by default.
     */
    String[] i18n() default "";

    /**
     * Helper annotation to use multiple Comment annotations
     * If you want to use it... what is wrong with you?
     */
    @Documented
    @Target({ElementType.FIELD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface Comments {
        Comment[] value();
    }
}