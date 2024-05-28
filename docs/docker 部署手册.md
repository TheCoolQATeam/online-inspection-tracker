# 部署手册

## 1、极速启动

如果您不想修改任何配置，只想看看巡检系统有啥功能，下载完代码后，在 **当前工程下的docker文件夹** 下，执行如下命令：

# arm架构下
docker-compose -f docker-compose-arm64.yml up
```

这需要您保留本机的3306、5173、9091端口号，用于映射巡检系统MySQL、前端、服务端的端口。

看到终端日志中输出了如下日志，说明环境已经准备成功：

```log
inspection-server  | 
inspection-server  |   .   ____          _            __ _ _
inspection-server  |  /\\ / ___'___ __ _ ___(___)_ __  __ _ \ \ \ \
inspection-server  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
inspection-server  |  \\/  ___)| |___)| | | | | || (_| |  ) ) ) )
inspection-server  |   '  |____| .__|_______| |_____|___| |_\__, | / / / /
inspection-server  |  =========|_|==============|___/=/___/_/_/
inspection-server  |  :: Spring Boot ::               (v2.7.15)
inspection-server  | 
inspection-server  | 2024-05-14 02:22:31.472  INFO 7 --- [           main] com.onlines.OnlinesApplication           : Starting OnlinesApplication v0.0.1-SNAPSHOT using Java 1.8.0_342 on c2db6ea6c67c with PID 7 (/inspection/onlineInspect.jar started by root in /)
inspection-server  | 2024-05-14 02:22:31.483  INFO 7 --- [           main] com.onlines.OnlinesApplication           : No active profile set, falling back to 1 default profile: "default"
inspection-server  | 2024-05-14 02:22:33.483  INFO 7 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 9091 (http)
inspection-server  | 2024-05-14 02:22:33.496  INFO 7 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
inspection-server  | 2024-05-14 02:22:33.496  INFO 7 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.79]
inspection-server  | 2024-05-14 02:22:33.572  INFO 7 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
inspection-server  | 2024-05-14 02:22:33.572  INFO 7 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1896 ms
inspection-server  | Logging initialized using 'class org.apache.ibatis.logging.stdout.StdOutImpl' adapter.
inspection-server  | 2024-05-14 02:22:35.005  INFO 7 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 9091 (http) with context path ''
inspection-server  | 2024-05-14 02:22:35.027  INFO 7 --- [           main] com.onlines.OnlinesApplication           : Started OnlinesApplication in 4.344 seconds (JVM running for 5.27)
```

启动后，在浏览器输入 http://127.0.0.1:5173/ ，即可访问巡检系统平台。

接下来还有一点需要注意的：

* 若部署到服务器，需要其他机器访问，需要将docker-->web目录下default.conf文件server_name配置的127.0.0.1替换成服务器IP，启动后使用http://服务器IP:5173/ 访问即可。