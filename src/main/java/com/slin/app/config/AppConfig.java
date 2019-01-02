package com.slin.app.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.slin.app.service.StudentService;
import com.slin.app.service.internal.StudentServiceImpl;



@Configuration
@EnableCaching(mode = AdviceMode.ASPECTJ)
public class AppConfig {
	@Bean
	public CacheManager cacheManager () {
		return new EhCacheCacheManager(ehCacheCacheManager().getObject());
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehCacheCacheManager() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		return cmfb;
	} 
	
	@Bean
	public StudentService getStudentService () {
		return new StudentServiceImpl();
	}
}
