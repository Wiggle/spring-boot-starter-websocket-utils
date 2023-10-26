package org.wiggle.websocket.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.wiggle.websocket.annotation.WebSocketMapping;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private ApplicationContext context;

//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        String[] beanNames = context.getBeanNamesForAnnotation(WebSocketMapping.class);
//        for (String beanName : beanNames) {
//            Object bean = context.getBean(beanName);
//            if (bean instanceof TextWebSocketHandler) {
//                WebSocketMapping mapping = bean.getClass().getAnnotation(WebSocketMapping.class);
//                registry.addHandler((TextWebSocketHandler) bean, mapping.value());
//            }
//        }
//    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        String[] beanNames = context.getBeanNamesForAnnotation(WebSocketMapping.class);
        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);

            if (!(bean instanceof WebSocketHandler)) {
                throw new IllegalStateException(
                        "The WebSocketMapping annotation can only be applied to beans of type WebSocketHandler or its subclasses.");
            }

            WebSocketMapping mapping = bean.getClass().getAnnotation(WebSocketMapping.class);
            registry.addHandler((WebSocketHandler) bean, mapping.value());
        }
    }

}

