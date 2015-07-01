package org.os.core;



public class Test {
	@org.junit.Test
	public void name() {
		Abc abc1=new Test.Abc();
		Abc abc2=new Test.Abc();
		System.out.println(abc1);
		System.out.println(abc2);
	}
	public static class Abc{
		private String a;

		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}
		
	}
}
