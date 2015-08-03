package org.lemonPig.os;

import org.junit.Test;

import com.jhlabs.math.Function1D;

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
