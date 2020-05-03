# springboot-dubbo-demo
SpringBoot + Dubbo + Zookeeper的简单Demo实现

参考：
- [Dubbo脑图](https://naotu.baidu.com/file/526898c98f147f31375a6e4e6df5f9e8)
- [Dubbo官方文档](http://dubbo.apache.org/zh-cn/docs/user/new-features-in-a-glance.html)

## 概述：
### 三个模块：
- 一、 interface模块：
<p>接口模块，被提供者和消费者所使用。
<p>建议将服务接口，服务模型，服务异常等均放在 API 包中，因为服务模型及异常也是 API 的一部分，同时，这样做也符合分包原则：重用发布等价原则(REP)，共同重用原则(CRP)。

- 二、 provider模块：
<p>服务提供者模块，主要用于实现interface模块的service服务，有可能和Consumer部署在不同服务器。
<p>它是被消费者所调用的，它需要实现公共服务接口，并通过dubbo把自己的服务暴露出来。
<p>pom文件中需导入interface模块；

- 三、 consumer模块：
<p>服务消费者模块，直接调用interface模块的service，不需要关注具体的provider模块的服务实现。
<p>pom文件中需导入interface模块；

### 核心思想：
- 1、将服务提供者Provider注册到服务中心（暴露服务）；
<p>导入dubbo依赖（2.7.3）；
<p>注册中心使用Zookeeper，引入curator客户端；
<p> provider配置文件配置：
a. 指定当前服务/应用的名字（不要和别的服务同名）；
b. 指定注册中心地址；
c. 指定通信规则（通信协议和端口）：用dubbo协议在20880端口暴露服务；
<p> > 注意：Provider和Consumer都需要配置上面的两步骤

- 2、让服务消费者Consumer去注册中心订阅服务提供者的服务地址；
- 3、

## 流程
### 运维管理中心（dubbo-admin）
参考：[Dubbo运维管理](http://dubbo.apache.org/zh-cn/docs/admin/introduction.html)
修改配置文件，web端口为8888（默认8080）
访问网页：http://localhost:8888/

### 执行：
- 进入interface目录：mvn clean install
- 进入provider目录：mvn spring-boot:run
- 进入consumer目录：mvn spring-boot:run
## 测试：
- GET接口：http://localhost:8082/user/query?id=11
