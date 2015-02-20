package com.example.di;

import javax.sql.DataSource;

public abstract class ConfigurationService {

	private static ConfigurationService instance = new ConfigurationServicePlain();

	public static synchronized ConfigurationService getInstance() {
		return instance;
	}

	public static synchronized void setInstance(ConfigurationService service) {
		ConfigurationService.instance = service;
	}
	
	public static synchronized void reset() {
		ConfigurationService.instance = new ConfigurationServicePlain();
	}

	public abstract CustomerService getCustomerService();

	public abstract NetworkAddrService getNetworkAddrService();

	public abstract SecurityService getSecurityService();

	public abstract DistributionEngine getDistributionEngine();

	public abstract MyValidator getMyValidator();

	public abstract MyStatelessWorkerBean getWorker();

	public abstract DataSource getRegionalDataSource();

	public abstract DataSource getGlobalDataSource();

	public abstract RequestMessageLogService getRequestMessageLogService();

}
