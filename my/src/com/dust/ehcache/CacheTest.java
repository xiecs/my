package com.dust.ehcache;

import org.apache.commons.lang.builder.ToStringBuilder;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class CacheTest {

	public static void main(String[] args) {

		// 使用默认配置文件创建CacheManager
		CacheManager manager = CacheManager.create();
		// 通过manager可以生成指定名称的Cache对象
		Cache cache = manager.getCache("demoCache");

		Element element = new Element("key", new Data("dust", "1111"));
		cache.put(element);
		// 从cache中取回元素
		Element element1 = cache.get("key");
		Data data = (Data) element1.getValue();

		System.out.println(ToStringBuilder.reflectionToString(data));
		// //从Cache中移除一个元素
		// cache.remove("key");

		// 得到缓存中的对象数
		System.out.println(cache.getSize());
		// 得到缓存对象占用内存的大小
		System.out.println(cache.getMemoryStoreSize());
		// 得到缓存读取的命中次数
		System.out.println(cache.getStatistics().getCacheHits());
		// 得到缓存读取的错失次数
		System.out.println(cache.getStatistics().getCacheMisses());
	}

}
