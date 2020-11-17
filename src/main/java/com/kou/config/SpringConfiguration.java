package com.kou.config;

import org.springframework.context.annotation.*;



/**
 * @author JIAJUN KOU
 *
 * 改类是一个配置类，其作用和bean.xml作用差不多
 * spring的新注解
 * @configuration :表明该类是一个配置类
 *
 * @ComponentScan:作用是创建容器时要扫描的包
 *      相当于是bean.xml中配置了：    <context:component-scan base-package="com.kou"></context:component-scan>
 *
 * @Bean:作用就是，把当前方法的返回值存入springIOc的容器中
 *      属性：name:用于指定bean的id，默认值是当前方法的名称
 *
 * @Import :作用是导入其他配置类
 *
 * @PropertySource : 用于指定properties文件的位置
 */

@Configuration
@ComponentScan(basePackages = "com.kou")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
