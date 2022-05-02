package com.dutianze.lambda.theroy;

import java.util.HashMap;
import java.util.Map;

/**
 * cn: <a href="http://it.deepinmind.com/jvm/2019/07/19/jvm-method-invocation-invokedynamic.html">jvm-method-invocation-invokedynamic</a>
 * <br/>
 * en: <a href="https://blogs.oracle.com/javamagazine/post/mastering-the-mechanics-of-java-method-invocation">mastering-the-mechanics-of-java-method-invocation</a>
 *
 * @author dutianze
 * @date 2022/5/2
 */
public class InvokeExample {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        HashMap<String, String> hm = new HashMap<>();
        hm.put("now", "bar");
        Map<String, String> m = hm;
        m.put("foo", "baz");
    }
}
