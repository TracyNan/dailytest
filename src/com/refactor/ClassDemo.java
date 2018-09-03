package com.refactor;

import java.lang.reflect.Method;

public class ClassDemo {

	public static void main(String[] args) {

		try {
			Class c = Class.forName(args[0]);
			System.out.println("类名称：" + c.getName());
			System.out.println("是否为接口：" + c.isInterface());
			System.out.println("是否为基本类型：" + c.isPrimitive());
			System.out.println("是否为数组：" + c.isArray());
			System.out.println("父类：" + c.getSuperclass().getName());
			Method[] methods = c.getMethods();
			for (Method method : methods) {
				if ("getTeString".equals(method.getName())) {
					
					System.out.println("method name = " + method.getName()+",method para:"+method.getParameterTypes()+""+method.getParameterCount()+method.getParameters());
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("没有指定类名称");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到指定的类");
		}
	}
}
