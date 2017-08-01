####从零开始搭建springmvc+mybatis

1. 搭建基于maven的webapp项目.
	配置web.xml 和 applicationContext.xml

	1.1  配置web.xml,加载过程是context-param >> listener  >> fileter  >> servlet
		http://blog.csdn.net/jubincn/article/details/9115205
	1.2  配置applicationContext.xml,内容包括配置component-scan ,功能为扫描下面包的注解并把
这些类注册为bean;配置视图解析器,在视图逻辑名前面加上prefix,后面加上suffix.
 
	现在创建controller层测试,@ResponseBody表示只返回字符串,不然返回视图.
	
	注意: 将applicationContext.xml等配置文件放在resource下时要在web.xml中配置
	classpath:applicationContext.xml,context-param和servlet->init-param

2. 配置数据库及mybatis等.
	
	2.1 配置数据库相关参数properties的属性

	2.2 配置数据库连接池. java目录下建mapper,model包,resource下建mapper问价夹.

	2.3 配置SqlSessionFactory对象
	
	2.4 配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中

	配置事务管理器,配置基于注解的声明式事务

3. 逆向生成文件
	
	3.1 通过在mybatis官网下载 generatorConfig.xml文件进行配置
		- http://www.mybatis.org/generator/configreference/xmlconfig.html（官方）
   		- http://www.jianshu.com/p/e09d2370b796 （网友翻译版）

	3.2 在官网上复制java自动生成代码,运行(可用maven插件 获取其它如eclipse插件等)
		- http://www.mybatis.org/generator/running/runningWithJava.html

4. 基本测试运行
	建立controller包下的文件,调用注解了 *Mapper 的接口进行数据库操作



    注意: 运行过程中可能出现乱码现象,解决方法如下

        - tomcat下的server.xml
            
            `<Connector port="8080" protocol="HTTP/1.1" connectionTimeout="20000" redirectPort="8443" URIEncoding="UTF-8"/> `
        - JSP页面设置编码
            
            `<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>`
    
    
        - 过滤器(web.xml下添加filter过滤器) 或是 Servlet中加入
            
            request.setCharacterEncoding("UTF-8");
    
            response.setCharacterEncoding("UTF-8");

