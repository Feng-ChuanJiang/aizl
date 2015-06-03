package org.lemonPig.os;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {
		"classpath:plugins/spring/spring-beans.xml",
		"classpath:plugins/spring/spring-task.xml",
		"classpath:plugins/shiro/spring-shiro.xml",
		"classpath:plugins/mybatis/spring-mybatis.xml",
		"classpath:plugins/memcached/spring-memcached.xml",
		"classpath:plugins/jdbc/spring-jdbc.xml",
		"classpath:plugins/ehcache/spring-ehcache.xml",
		"classpath:plugins/spring/spring-mvc.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class BaseControllerTest extends
		AbstractTransactionalJUnit4SpringContextTests {

}