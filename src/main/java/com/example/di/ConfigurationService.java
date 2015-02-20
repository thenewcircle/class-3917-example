package com.example.di;

import javax.sql.DataSource;

public class ConfigurationService {

	private static ConfigurationService instance = new ConfigurationService();

	private CustomerService customerService;
	private NetworkAddrService networkAddrService;
	private SecurityService securityService;
	private RequestMessageLogService requestMessageLogService;
	private DistributionEngine distributionEngine;
	private MyValidator myValidator;
	private MyStatelessWorkerBean worker;
	private DataSource regionalDataSource;
	private DataSource globalDataSource;

	public static ConfigurationService getInstance() {
		return instance;
	}

	public ConfigurationService() {
		reset();
	}

	public void reset() {
		regionalDataSource = jndiLookup("/jdbc/RegionalDS", DataSource.class);
		globalDataSource = jndiLookup("/jdbc/GlobalDS", DataSource.class);
		worker = jndiLookup("myWorker", MyStatelessWorkerBean.class);
		customerService = new CustomerService();
		customerService.setDataSource(regionalDataSource);
		networkAddrService = new NetworkAddrService();
		networkAddrService.setDataSource(regionalDataSource);
		securityService = new SecurityService();
		securityService.setDataSource(globalDataSource);
		requestMessageLogService = new RequestMessageLogService();
		requestMessageLogService.setDatasource(regionalDataSource);
		myValidator = new MyValidator();
		myValidator.setCustomerService(customerService);
		distributionEngine = new DistributionEngine();
		distributionEngine.setCustomerService(customerService);
		distributionEngine.setNetworkAddrService(networkAddrService);
	}

	private <T> T jndiLookup(String string, Class<T> type) {
		Object obj = null; // Do lookup
		T result = type.cast(obj);
		return result;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public NetworkAddrService getNetworkAddrService() {
		return networkAddrService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setNetworkAddrService(NetworkAddrService networkAddrService) {
		this.networkAddrService = networkAddrService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	public DistributionEngine getDistributionEngine() {
		return distributionEngine;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setDistributionEngine(DistributionEngine distributionEngine) {
		this.distributionEngine = distributionEngine;
	}

	public MyValidator getMyValidator() {
		return myValidator;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setMyValidator(MyValidator myValidator) {
		this.myValidator = myValidator;
	}

	public MyStatelessWorkerBean getWorker() {
		return worker;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setWorker(MyStatelessWorkerBean worker) {
		this.worker = worker;
	}

	public DataSource getRegionalDataSource() {
		return regionalDataSource;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setRegionalDataSource(DataSource regionalDataSource) {
		this.regionalDataSource = regionalDataSource;
	}

	public DataSource getGlobalDataSource() {
		return globalDataSource;
	}

	/**
	 * Never call this. Only call this in test cases when injecting a mock. That
	 * test should then call reset() afterwards to clean back up this state.
	 */
	public void setGlobalDataSource(DataSource globalDataSource) {
		this.globalDataSource = globalDataSource;
	}

}
