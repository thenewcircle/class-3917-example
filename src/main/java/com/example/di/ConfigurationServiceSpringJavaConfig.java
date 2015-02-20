package com.example.di;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigurationServiceSpringJavaConfig extends ConfigurationService {

	public static ConfigurationServiceSpringJavaConfig install() {
		return install("/com/example/di/spring-config-injected.xml");
	}
	
	public static ConfigurationServiceSpringJavaConfig install(String xmlFile) {
		ConfigurationServiceSpringJavaConfig config = new ConfigurationServiceSpringJavaConfig(xmlFile);
		ConfigurationService.setInstance(config);
		return config;
	}

	@Autowired
	@Qualifier("regional")
	private DataSource regionalDataSource;

	@Autowired
	@Qualifier("global")
	private DataSource globalDataSource;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private NetworkAddrService networkAddrService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private DistributionEngine distributionEngine;

	@Autowired
	private MyValidator myValidator;

	@Autowired
	private MyStatelessWorkerBean worker;

	@Autowired
	private RequestMessageLogService requestMessageLogService;

	@SuppressWarnings("deprecation")
	public ConfigurationServiceSpringJavaConfig(String xmlFile) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(xmlFile); 
		ctx.getAutowireCapableBeanFactory().autowireBean(this);
	}

	@Override
	public CustomerService getCustomerService() {
		return customerService;
	}

	@Override
	public NetworkAddrService getNetworkAddrService() {
		return networkAddrService;
	}

	@Override
	public SecurityService getSecurityService() {
		return securityService;
	}

	@Override
	public DistributionEngine getDistributionEngine() {
		return distributionEngine;
	}

	@Override
	public MyValidator getMyValidator() {
		return myValidator;
	}

	@Override
	public MyStatelessWorkerBean getWorker() {
		return worker;
	}

	@Override
	public DataSource getRegionalDataSource() {
		return regionalDataSource;
	}

	@Override
	public DataSource getGlobalDataSource() {
		return globalDataSource;
	}

	@Override
	public RequestMessageLogService getRequestMessageLogService() {
		return requestMessageLogService;
	}
	
}
