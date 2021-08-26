# e_commerce
青软实训项目—在线商城。
项目源自于某培训机构，重新利用IDEA实现。

##项目特点：

后台聚合工程搭建，ssm框架整合;

上传图像服务器，Nginx反向代理负载均衡。

首页大广告位的展示：Cms系统实现、redis缓存（集群）首页大广告位展示；

搜索功能的实现，使用solr实现（solr集群）；
 
单点登录系统实现，session共享；
 
Quartz任务调度框架；

##技术选型：

1. 数据库：mysql
2. Dao层：mybatis、数据库连接池（德鲁伊druid）
3. 缓存：redis
4. 搜索：solr
5. Service层：spring
6. 表现层：springmvc、jstl、EasyUI、jsp、freemaker
7. 图片服务器：FastDFS（分布式文件系统），也可vsftpd。
8. 反向代理服务器：nginx
9. 定时器：Quartz
10. Web服务器：tomcat
11. 工程管理：maven
