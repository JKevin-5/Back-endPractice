## Spring Bean 作用域和生命周期
Spring提供了多种Bean的作用域，用于控制SpringBean的生命周期和作用范围。
1. Singleton：是Spring的默认作用域。在这个作用域中，Spring IoC容器只创建一个Bean实例，所有对该Bean的请求都将返回这个单一实例。这个实例在Spring IoC容器的整个生命周期中都会存在。
2. Prototype：在Prototype作用域中，每次请求一个Bean时，Spring IoC容器都将创建一个新的Bean实例。
3. Request：这是一个Web应用程序特定的作用域，在一个HTTP请求期间，一个Bean被实例化一次。每个新的HTTP请求都会有自己的Bean实例。这个作用域只在基于Web的Spring ApplicationContext情境中有效。
4. Session：这也是一个Web应用程序特定的作用域，在一个HTTP Session期间，一个Bean被实例化一次。每个新的HTTP Session都会有自己的Bean实例。这个作用域只在基于Web的Spring ApplicationContext情境中有效。
5. Application：在整个Web应用程序中，一个Bean被实例化一次。Bean的生命周期与ServletContext的生命周期相同。这个作用域只在基于Web的Spring ApplicationContext情境中有效。
6. Websocket：在一个特定的WebSocket会话中，一个Bean被实例化一次。这个作用域只在使用WebSocket通信的Spring ApplicationContext情境中有效。

## Spring Aop

## Spring IOC

## Spring 事务管理
1. 事务的基本原理：本质是数据库对事务的支持。
2. 单纯的事务实现：
    - 获取连接
    - 开启事务
    - 执行sql
    - 提交事务/回滚事务
    - 关闭连接
    目前spring事务管理已经自动完成了2和4的代码。配置文件开启注解驱动，在相关的类和方法上通过注解@Transactional标识。spring启动的时候会自动去解析生成相关的bean，并进行相关的代理。
3. Spring事务的传播属性
    - REQUIRED：默认属性，如果当前事务不存在，就新建一个事务，如果当前存在事务，就加入到当前事务中。
    - SUPPORTS：支持当前事务，如果当前没有事务，就以非事务方式执行操作。
    - MANDATORY：如果当前存在事务，就加入到当前事务中，如果当前不存在事务，就抛出异常。
    - REQUIRES_NEW：如果当前存在事务，就开启一个新的事务，如果当前不存在事务，就什么也不做。
    - NOT_SUPPORTED: 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
