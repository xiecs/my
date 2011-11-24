package com.dust.demo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

class Bean {
	String name;
	String age;

	public Bean() {

	}

	public Bean(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}

public class ConvertBean {
	public static <T> T form(Class<T> beanClass, Map<String, Object> map) throws Exception {
		T bean = beanClass.newInstance();
		BeanUtils.populate(bean, map);
		return bean;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "dust");
		map.put("age", "11");
		// map.put("test", "22222");

		System.out.println(ToStringBuilder.reflectionToString(form(new Bean().getClass(), map),
				ToStringStyle.DEFAULT_STYLE));

	}

}
