package test.lambda.functionalInterface;

/**
 * @auther shiZehao
 * @date 20:04 01/29/2020
 * @class Executor
 * @description 对应Consumer接口
 */
@FunctionalInterface
public interface Executor<T> {
    void execute(T t);
}
