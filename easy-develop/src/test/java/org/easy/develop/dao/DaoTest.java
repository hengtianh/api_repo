package org.easy.develop.dao;

import java.util.Date;

import org.easy.develop.common.domain.DevApi;
import org.easy.develop.config.RootConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DaoTest {
	
	private DevApiMapper mapper;
	
	@Before
	public void init() {
		ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
		mapper = context.getBean(DevApiMapper.class);
	}
	
	@Test
	public void testSqlSession() {
		DevApi devApi = new DevApi();
		devApi.setId(1L);
		devApi.setApiName("listApi");
		devApi.setReturnType("WebModel");
		devApi.setParams(Long.toString(1));
		devApi.setDescription("返回所api列表");
		devApi.setAuthor("administrator");
		devApi.setGmtCreate(new Date());
		devApi.setIsEnabled((byte) 1);
		
		mapper.insert(devApi);
	}
}
