package test.lambda.functionalInterface;

import java.util.function.Predicate;

/**
 * @auther shiZehao
 * @date 20:00 01/29/2020
 * @class NameChecker
 * @description 对应Predicate接口的test
 */
@FunctionalInterface
public interface NameChecker<T> {
    boolean check(T t);
    // Predicate
}
