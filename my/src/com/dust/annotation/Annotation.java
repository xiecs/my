package com.dust.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 系统所有注释的容器
 * @author Winter Lau
 */
public class Annotation {
	/**
	 * 用户权限注释
	 * @author liudong
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface UserRoleRequired {

		/**
		 * 用户的角色
		 * @return
		 */
//		public byte role() default IUser.ROLE_GENERAL ;
		
	}

	/**
	 * 只允许使用POST方式执行的Action方法
	 * @author liudong
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public static @interface PostMethod {

	}
	
	/**
	 * 输出JSON格式的提示信息
	 * @author liudong
	 */
	@Target(ElementType.METHOD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface JSONOutputEnabled {

	}
}