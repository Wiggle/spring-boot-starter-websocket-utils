package org.wiggle.websocket.autoconfig;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.wiggle.websocket.config.WebSocketConfig;
import org.wiggle.websocket.condition.OnClassAnnotatedWithWebSocketMappingCondition;

@Configuration
@Conditional(OnClassAnnotatedWithWebSocketMappingCondition.class)  // 使用自定义条件
@Import(WebSocketConfig.class)
public class WebSocketAutoConfiguration {

}
