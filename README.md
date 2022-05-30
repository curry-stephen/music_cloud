# music_cloud

### 介绍
基于前后端分离的音乐网站，主要用于练习springboot项目实践之用，前端vue部分由于本人对前端基础不扎实，所以引用了其他开源项目的前端.根据前端接口来构造后端数据。
### 技术栈
- 后端：Springboot2.6.4 +mybatis-plus
- 前端：Vue.js+ElementUI

### 软件架构
软件架构说明


### 安装教程

- 启动前，请配置好 [application.properties](https://github.com/curry-stephen/music_cloud/tree/master/music/src/main/resources/application.properties) 中连接数据库的用户名和密码，以及Redis服务器的地址和端口信息。

- 启动前，请创建数据库`tp_music`，建表SQL语句放在：[/sql/tp_music.sql](https://github.com/curry-stephen/music_cloud/tree/master/sql/tp_music.sql) 中连接数据库的用户名和密码，以及Redis服务器的地址和端口信息。


- 配置完成后，运行位于 `src/main/com/yy/`下的SpringbootApplication中的main方法，访问 `http://localhost:8081/` 进行API测试。)。具体的建表和建库语句请仔细看SQL文件。

### 准备
#### 使用前你需要掌握的知识点
## Spring Boot应用启动器

Spring Boot提供了很多应用启动器，分别用来支持不同的功能，说白了就是`pom.xml`中的依赖配置，因为Spring Boot的自动化配置特性，我们并不需再考虑项目依赖版本问题，使用Spring Boot的应用启动器，它能自动帮我们将相关的依赖全部导入到项目中。

我们这里介绍几个常见的应用启动器：

* `spring-boot-starter`: Spring Boot的核心启动器，包含了自动配置、日志和YAML
* `spring-boot-starter-aop`: 支持AOP面向切面编程的功能，包括spring-aop和AspecJ
* `spring-boot-starter-cache`: 支持Spring的Cache抽象
* `spring-boot-starter-artermis`: 通过Apache Artemis支持JMS（Java Message Service）的API
* `spring-boot-starter-data-jpa`: 支持JPA
* `spring-boot-starter-data-solr`: 支持Apache Solr搜索平台，包括spring-data-solr
* `spring-boot-starter-freemarker`: 支持FreeMarker模板引擎
* `spring-boot-starter-jdbc`: 支持JDBC数据库
* `spring-boot-starter-Redis`: 支持Redis键值储存数据库，包括spring-redis
* `spring-boot-starter-security`: 支持spring-security
* `spring-boot-starter-thymeleaf`: 支持Thymeleaf模板引擎，包括与Spring的集成
* `spring-boot-starter-web`: 支持全栈式web开发，包括tomcat和Spring-WebMVC
* `spring-boot-starter-log4j`: 支持Log4J日志框架
* `spring-boot-starter-logging`: 引入Spring Boot默认的日志框架Logback

## Spring Boot项目结构设计

Spring Boot项目（即Maven项目），当然拥有最基础的Maven项目结构。除此之外：

1. Spring Boot项目中不包含webapp(webroot)目录。
2. Spring Boot默认提供的静态资源目录需要置于classpath下，且其下的目录名称要符合一定规定。
3. Spring Boot默认不提倡用XML配置文件，主张使用YML作为配置文件格式，YML有更简洁的语法。当然也可以使用.properties作为配置文件格式。
4. Spring Boot官方推荐使用Thymeleaf作为前端模板引擎，并且Thymeleaf默认将templates作为静态页面的存放目录（由配置文件指定）。
5. Spring Boot默认将`resources`作为静态资源的存放目录，存放前端静态文件、项目配置文件。

6. Spring Boot规定`resources`下的子级目录名要符合一定规则，一般我们设置`resources/static`为前端静态（JS,CSS）的存放目录；设置`resources/templates`作为HTML页面的存放目录。

7. Spring Boot指定的Thymeleaf模板引擎文件目录`/resources/templates`是受保护的目录，这与之前的WEB项目的WEB-INF文件夹和类似，特点就是里面的静态资源不能直接访问，一般我们通过Controller映射访问。

8. 建议将Mybatis-Mapper的XML映射文件放于`resources/`目录下，我这里设为`resources/mapper`目录，且`src/main/java/Mapper`下的Mapper层接口要使用`@Mapper`注解标识，不然mybatis找不到接口对应的XML映射文件。

9. `SpringBootApplication.java`为项目的启动器类，项目不需要部署到Tomcat上，由SpringBoot提供的服务器部署项目（运行启动器类即可）；且SpringBoot会自动扫描该启动器同级和子级下用注解标识的Bean，也就是之前我们配置的`<context:component-scan>`在SpringBoot中是完全不需类似的配置的。

10. Spring Boot不建议使用JSP页面，如果想使用，请自行百度解决办法。我们常用HTML页面+Thymeleaf模板引擎。Thyemeleaf模板引擎提供了很多内置语法，比如：可以通过`<div th:text="${xx}">`取出来后端存放在域对象中的数据。

11. 上面说了Spring Boot提供的存放HTML静态页面的目录`resources/templates`是受保护的目录，访问其中的HTML页面要通过Controller映射，这就间接规定了你需要配置Spring的视图解析器，且Controller类不能使用`@RestController`标识。

# 起步

*首先：*  **我想特殊强调的是：SpringBoot不是对Spring功能上的增强，而是提供了一种快速使用Spring的方式**。一定要切记这一点。

学习SpringBoot框架，只是为了更简便的使用Spring框架，我们在SSM阶段学习的知识现在放在Spring Boot框架上开发是完全适用的，我们学习的大多数是SpringBoot的自动化配置方式。

因为Spring Boot框架的一大优势就是自动化配置，从pom.xml的配置中就能明显感受到。
## 项目依赖

本项目的依赖文件请看GitHub仓库：[music/pom.xml](https://github.com/curry-stephen/music_cloud/tree/master/music/pom.xml)

## 初始化数据库

本项目数据库表设计请看GitHub仓库：[music/sql/][(https://github.com/curry-stephen/music_cloud/sql/tp_music.sql)

请运行项目前，先把数据库表结构建好

## SpringBoot整合Mybatis

之前已经说过：**SpringBoot框架不是对Spring功能上的增强，而是提供了一种快速使用Spring的方式**

所以说，SpringBoot整合Mybatis的思想和Spring整合Mybatis的思想基本相同，不同之处有两点：

* 1.Mapper接口的XML配置文件变化。之前我们使用Mybatis接口代理开发，规定Mapper映射文件要和接口在一个目录下；而这里Mapper映射文件置于`resources/mapper/`下，且置于`src/main/java/`下的Mapper接口需要用`@Mapper`注解标识，不然映射文件与接口无法匹配。或者当数据访问层的Mapper接口过多时，可以在启动类上添加@MapperScan注解直接扫描所有对应的Mapper文件。

* 2.SpringBoot建议使用YAML作为配置文件，它有更简便的配置方式。所以整合Mybatis在配置文件上有一定的区别，但最终都是那几个参数的配置。但是本项目里并没有使用yml作为配置文件，仍然是properties。

关于YAML的语法请自行百度，我这里也仅仅是满足基本的配置需求，不涉及那种不易理解的语法。
### 整合配置文件

本例详细代码请看GitHub仓库：[resources/application.properties](https://github.com/curry-stephen/music_cloud/tree/master/music/src/main/resources/application.properties)

在Spring阶段用XML配置mybatis无非就是配置：1.连接池；2.数据库url连接；3.mysql驱动；4.其他初始化配置

```
spring.datasource.url=jdbc:mysql://localhost:3306/tp_music?serverTimezone=UTC&useSSL=true&useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#swagger需要配置，不然容易空指针   3.0访问请求界面swagger-ui/index.html
spring.mvc.pathmatch.matching-strategy= ANT_PATH_MATCHER
mybatis-plus.typeAliasesPackage=com.yy.pojo
mybatis-plus.mapperLocations=classpath:mapper/*.xml

spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
spring.jackson.time-zone=GMT+8

spring.server.MaxFileSize=50MB
spring.server.MaxRequestSize=50MB
server.port=8081

#热部署生效
spring.devtools.restart.enabled=true

#设置重启的目录
spring.devtools.restart.additional-paths=src/main/java

#spring.mvc.static-path-pattern=/**
#classpath目录下的WEB-INF文件夹内容修改不重启
spring.devtools.restart.exclude=WEB-INF/**

# 关闭CONDITIONS EVALUATION REPORT及自动配置内容向控制台的输出
logging.level.org.springframework.boot.autoconfigure=ERROR
```
**注意：空格代表节点层次；注释部分用`#`标记**

**解释**

1. 我们实现的是spring-mybatis的整合，包含mybatis的配置以及datasource数据源的配置当然属于spring配置中的一部分，所以需要在`spring:`下。

2. `mapper-locations`相当于XML中的`<property name="mapperLocations">`用来扫描Mapper层的配置文件，由于我们的配置文件在`resources`下，所以需要指定`classpath:`。

3. `type-aliases-package`相当与XML中`<property name="typeAliasesPackase">`别名配置，一般取其下实体类类名作为别名。

4. `datasource`数据源的配置，`name`表示当前数据源的名称，类似于之前的`<bean id="dataSource">`id属性，这里可以任意指定，因为我们无需关注Spring是怎么注入这个Bean对象的。

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request


