# Spring Boot WebSocket 工具模块 (Spring Boot WebSocket Utils)

这个工具模块为Spring Boot应用程序提供了一种优雅的方式，使用注解来处理WebSocket端点，与Java EE中的`@ServerEndpoint`相似。

This utility module provides an elegant way to handle WebSocket endpoints in Spring Boot applications by using annotations, similar to the `@ServerEndpoint` in Java EE.

## 功能 (Features)

- **基于注解的WebSocket端点** (Annotation-based WebSocket Endpoint): 使用`@WebSocketMapping`注解声明WebSocket端点。
- **自动配置** (Automatic Configuration): 一旦在项目中包含了此模块并满足必要的条件，WebSocket配置将自动设置。

## 使用要求 (Requirements)

- Java 8 或更高版本 (Java 8 or higher)
- 带有`spring-boot-starter-websocket`依赖的Spring Boot

## 开始使用 (Getting Started)

### 1. 添加依赖 (Add Dependency)



**Step 1.** Add the JitPack repository to your build file



```markup
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

**Step 2.** Add the dependency

```markup
	<dependency>
	    <groupId>com.github.Wiggle</groupId>
	    <artifactId>spring-boot-starter-websocket-utils</artifactId>
	    <version>1.0.1-15f6fdd465-1</version>
	</dependency>
	
	<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-websocket</artifactId>
</dependency>

```

### 2. 创建WebSocket处理器 (Create WebSocket Handler)

通过继承`TextWebSocketHandler`并使用`@WebSocketMapping`注解来指定端点，创建一个处理器。

Create a handler by extending `TextWebSocketHandler` and use the `@WebSocketMapping` annotation to specify the endpoint.

```
javaCopy code
import org.wiggle.websocket.annotation.WebSocketMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@WebSocketMapping("/my-websocket-endpoint")
public class MyWebSocketHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 你的处理逻辑 (Your handling logic)
    }
}
```

### 3. 运行你的Spring Boot应用程序 (Run Your Spring Boot Application)

运行你的Spring Boot应用程序后，WebSocket端点将在`/my-websocket-endpoint`处可用。

Once you run your Spring Boot application, the WebSocket endpoint will be available at `/my-websocket-endpoint`.

## 贡献 (Contribution)

欢迎提供贡献、问题和功能请求！

Contributions, issues, and feature requests are welcome! 