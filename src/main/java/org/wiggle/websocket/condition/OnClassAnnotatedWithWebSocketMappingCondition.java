package org.wiggle.websocket.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.wiggle.websocket.annotation.WebSocketMapping;

public class OnClassAnnotatedWithWebSocketMappingCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String[] beanNames = context.getBeanFactory().getBeanNamesForAnnotation(WebSocketMapping.class);
        return beanNames.length > 0;  // 当找到使用WebSocketMapping注解的bean时返回true
    }
}
