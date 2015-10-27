package org.lemonPig.os;

import org.junit.Test;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.ClassUtils;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.jhlabs.math.Function1D;
import com.mysql.jdbc.log.Log;

public class Test1 {
	public class Person {
		public Person(){System.out.println(1);}
		public Person(int a){System.out.println(2);}
	}
	@Test
	public void test() {
		Person p=new Person(1);
	}
}
