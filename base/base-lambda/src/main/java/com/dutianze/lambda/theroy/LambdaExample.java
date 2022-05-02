package com.dutianze.lambda.theroy;

/**
 * cn: <a href="http://it.deepinmind.com/jvm/2019/07/19/jvm-method-invocation-invokedynamic.html">jvm-method-invocation-invokedynamic</a>
 * <br/>
 * en: <a href="https://blogs.oracle.com/javamagazine/post/understanding-java-method-invocation-with-invokedynamic">understanding-java-method-invocation-with-invokedynamic</a>
 *
 * @author dutianze
 * @date 2022/5/2
 */
public class LambdaExample {

    private static final String HELLO = "Hello";

    public static void main(String[] args) throws Exception {
        Runnable r = () -> System.out.println(HELLO);
        Thread t = new Thread(r);
        t.start();
        t.join();
    }
}
