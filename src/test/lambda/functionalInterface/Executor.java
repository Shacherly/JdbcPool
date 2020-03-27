package test.lambda.functionalInterface;

/**
 * @auther shiZehao
 * @date 20:04 01/29/2020
 * @class Executor
 * @description 对应Consumer接口的accept
 */
@FunctionalInterface
public interface Executor<T> {
    void execute(T t);
}
