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

