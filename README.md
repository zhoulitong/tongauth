#说明
 该项目是采用Spring Security做的一个权限认证和授权的过程<br>
 * 根据给出的数据库脚本（tongauth.sql）建立数据库
 * 启动TongauthApplication.java
 * 输入http://localhost/login进行登录
 * 初始用户名和密码为admin和admin<br>
 
 需要注意
 * 角色名称必须以ROLE_开头<br>
 
参考资料：
* https://blog.csdn.net/u012373815/article/details/54633046
* https://github.com/527515025/springBoot

流程图：

* 登录认证
![输入图片说明](https://gitee.com/uploads/images/2018/0419/115058_d6417447_1224684.png "2.png")
* 登录授权
![输入图片说明](https://gitee.com/uploads/images/2018/0419/115253_4547b1d8_1224684.png "1.png")
* 登录认证思维导图
![输入图片说明](https://gitee.com/uploads/images/2018/0419/115120_a60ee04d_1224684.jpeg "认证.jpg")
