# 一、简介

> 总共68集，共15个小时。快速入门SpringCloudNetflix和SpringCloudAlibaba

学习计划：2022/10/10 - 2022/10/17（共8天时间）

- [视频链接](【SpringCloud 教程 已完结（IDEA 2022.1最新版）4K蓝光画质 微服务开发】 https://www.bilibili.com/video/BV1AL4y1j7RY?p=2&share_source=copy_web&vd_source=e4d2dda1a0a113dcff0b77095733b76e)
- [视频配套笔记链接](https://www.yuque.com/qingkongxiaguang/spring/oo0kth)

# 1、SpringCloudNetflix

SpringCloudNetflix分布式框架下的开源分布式解决方案提供的组件：

| 组件名       | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| Eureka       | 实现服务治理（服务注册与发现），我们可以对所有的微服务进行集中管理，包括他们的运行状态、信息等。 |
| Ribbon(淘汰) | 为服务之间相互调用提供负载均衡算法（现在被SpringCloudLoadBalancer取代） |
| Hystrix      | 断路器，保护系统，控制故障范围。暂时可以跟家里电闸的保险丝类比，当触电危险发生时能够防止进一步的发展。 |
| Zuul（淘汰） | api网关，路由，负载均衡等多种作用，就像我们的路由器，可能有很多个设备都连接了路由器，但是数据包要转发给谁则是由路由器在进行（已经被SpringCloudGateway取代） |
| Config       | 配置管理，可以实现配置文件集中管理                           |

## 1. 初始化微服务项目



## 2. Eureka 注册中心

- [官方文档](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/)

Eureka能够自动注册并发现服务，然后对服务的状态、信息进行集中管理，这样当我们需要获取其他服务的信息时，我们只需要向Eureka进行查询就可以了。



### 如何做到高可用

存在多个Eureka服务器，搭建Eureka集群。

两个Eureka服务器配置文件：

application1.yml

```yaml
server:
  port: 8801
spring:
  application:
    name: eurekaserver
eureka:
  instance:
  	# 由于不支持多个localhost的Eureka服务器，但是又只有本地测试环境，所以就只能自定义主机名称了
  	# 主机名称改为eureka01
    hostname: eureka01
  client:
    fetch-registry: false
    # 去掉register-with-eureka选项，让Eureka服务器自己注册到其他Eureka服务器，这样才能相互启用
    service-url:
    	# 注意这里填写其他Eureka服务器的地址，不用写自己的
      defaultZone: http://eureka01:8801/eureka
```

application2.yml

```yaml
server:
  port: 8802
spring:
  application:
    name: eurekaserver
eureka:
  instance:
    hostname: eureka02
  client:
    fetch-registry: false
    service-url:
      defaultZone: http://eureka01:8801/eureka
```

修改host文件

这里由于我们修改成自定义的地址，需要在hosts文件中将其解析到172.0.0.1才能回到localhost，Mac下文件路径为`/etc/hosts`，Windows下为`C:\Windows\system32\drivers\etc\hosts`：

```
127.0.0.1 eureka01
127.0.0.1 eureka02
```

需要修改一下我们的微服务配置

```yaml
eureka:
  client:
    service-url:
    	# 将两个Eureka的地址都加入，这样就算有一个Eureka挂掉，也能完成注册
      defaultZone: http://localhost:8801/eureka, http://localhost:8802/eureka
```

## 3. LoadBalancer 负载均衡

2020年之前的SpringCloud版本是采用了Ribbon作为负载均衡实现，但是2020年之后的版本SpringCloud把Ribbon移除了，进而使用自己编写的LoadBalancer替代。

### 负载均衡







