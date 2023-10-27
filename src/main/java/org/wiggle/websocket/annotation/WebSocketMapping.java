package org.wiggle.websocket.annotation;

import org.springframework.stereotype.Component;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component  // 将此类标记为 Spring 组件
public @interface WebSocketMapping {
    String value();
    String origins() default "*";
}

