package com.demo.annotation;

import java.lang.annotation.*;

/**
 * @author wanghj
 * @description 参数检查注解
 * @createTime 2021/11/09 11:09
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamCheckAnnotation {
}
