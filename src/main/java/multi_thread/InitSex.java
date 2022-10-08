package multi_thread;

import java.lang.annotation.*;

/**
 * 性别赋值
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@Inherited
public @interface InitSex {
    /**
     * sex enum
     */
    public enum SEX_TYPE{MAN,WOMAN};
    SEX_TYPE sex() default SEX_TYPE.MAN;
}
