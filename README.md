# springBoot
springBoot example

基础是根据慕课网课程完成：

* [2小时学会Spring Boot](http://www.imooc.com/learn/767)
* [Spring Boot进阶之Web进阶](http://www.imooc.com/learn/810)

在此基础上增加了：

* 统一管理 enum, 方便返回值工具类的使用
* 使用 aop 完成参数验证
* 实现国际化参数验证返回值
* 引入kafka（简单）

####使用方法
#####1、修改 application.yml 
    
* 修改数据库信息
* 使用src.main.doc.springBoot.sql 生成表

#####2、配置环境 

* maven：3.3.9
* jdk：1.8

#####3、运行

注意：即使使用了 aop 处理,bindingResult依旧不能少,而且必须紧跟在被验证的参数后面

#####4、异常问题

4.1、 遇到 java.sql.SQLException: Unknown system variable 'tx_isolation'，为mysql-connector-java的版本过低，数据库的版本太高，故修改pom.xml里面的版本。

