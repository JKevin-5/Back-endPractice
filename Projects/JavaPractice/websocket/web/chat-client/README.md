# chat-client

## websocket聊天室

### Features

1. 支持多房间
2. 支持房间聊天记录限时保留
3. 支持短线重连
4. 支持并发广播
5. 使用session或者是用户名进行登陆



多房间使用ConcurrentHashMap进行管理，key+value的形式



创建房子：

```java
// 房子中的set是用于存储房间中的用户信息
Map<String,Set> map = new ConcurrentHashMap<>();
// Set需要使用线程安全的集合
Set<String> synSet = Collections.synchronizedSet(new HashSet<>());
Set<String> copySet = new CopyOnWriteArraySet<>();
```

