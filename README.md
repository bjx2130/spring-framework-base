# spring-framework-base
快速搭建spring-boot项目，只需引入sino-framework 就会引入一些常用配置


## sino_framework是核心配置
   参数处理器：@RequstParam LocalDateTime
              @RequstParam LocalDate
              @RequstParam LocalTime
              @RequestListParam List<String>
              @RequestListParam List<Integer>
  ObjectMapper类日期序列化模块：【jdk1.8 时间】序列化模块 SimpleModule
  全局返回值处理：ResponseControllerAdvice
  全局异常处理：SinoGlobalExceptionHandler
  RestTemplate配置：
              开启restTemplate负载均衡，支持ip、域名、服务名 调用
              替换StringHttpMessageConverter编码为utf-8
   添加ThreadLocal类实现：ContextHolder【ContextHolder设置值后，线程执行完成后ClearContextHolderInterceptor会清除变量】     
   fegin调用全局异常处理：FeginExceptionErrorDecoder
   bean包下定义了rest接口返回数据的包装类
   Mybatis配置：驼峰命名规则自动转换
   MyBatis-Plus： 分页插件           
   
   
## sino_common是多个模块共同VO类
## sino_gateway微服务网关
## sino_model 新建微服务demo模块【复制一个模块就可以】
