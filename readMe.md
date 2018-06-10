# JPA 使用 Hibernate 作为实现方式  

JPA + Hibernate + MySQL in Spring Boot  

## 注意  
此项目使用spring-boot 1.4.0版本，不适用于spring-boot 2.0 版本；
2.0版本的项目配置可参考：https://blog.csdn.net/u013467442/article/details/63262282
  
本项目使用IDEA构建，直接导入IDEA即可运行，使用eclipse的童鞋可以把单独把文件拿出来使用eclipse新建maven项目导入；具体方法不再赘述

  
项目通过配置DBConfig这个类来配置JPA到Hibernate的结合，读者可自行将DBConfig中有关Hibernate的相关配置提取到application.properties文件中

## 框架    
- SpringBoot
- SpringMVC
- Spring data JPA
- MySQL
  

## 概述  
一个前后分离的后端简易demo，利用jpa的注解特性与Hibernate结合，在数据存储的时候使用Hibernate的sessionFactory对数据进行操作。
通过前端调用后端所给接口，对Dog进行增删改查：（可使用PostMan等前端测试工具传入json数据给这个接口进行测试，使用方法自行百度）
  
- http://localhost:8080/api/dog/create
- http://localhost:8080/api/dog/find
- http://localhost:8080/api/dog/update
- http://localhost:8080/api/dog/del
  
  
