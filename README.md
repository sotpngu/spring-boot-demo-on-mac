https://github.com/wuyouzhuguli/SpringAll

https://docs.spring.io/spring-boot/docs/current/reference/html/

Mac终端启动redis命令：redis-server

Mac终端进入redis操作：redis-cli

Swagger常用注解：

@Api：修饰整个类，描述Controller的作用；

@ApiOperation：描述一个类的一个方法，或者说一个接口；

@ApiParam：单个参数描述；

@ApiModel：用对象来接收参数；

@ApiProperty：用对象接收参数时，描述对象的一个字段；

@ApiResponse：HTTP响应其中1个描述；

@ApiResponses：HTTP响应整体描述；

@ApiIgnore：使用该注解忽略这个API；

@ApiError ：发生错误返回的信息；

@ApiImplicitParam：一个请求参数；

@ApiImplicitParams：多个请求参数。

启动项目，访问 http://127.0.0.1:8088/swagger-ui.html 即可看到Swagger给我们生成的API页面

actuator:

https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready