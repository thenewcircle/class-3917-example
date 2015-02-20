package com.example.di;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationServiceSpringXMLTest {

	@Test
	public void testConfiguration() {
		ConfigurationServiceSpringXML.install();
		ConfigurationService config = ConfigurationService.getInstance();
		
		Assert.assertNotNull(config.getCustomerService());
		Assert.assertNotNull(config.getCustomerService());
		Assert.assertNotNull(config.getNetworkAddrService());
		Assert.assertNotNull(config.getSecurityService());
		Assert.assertNotNull(config.getDistributionEngine());
		Assert.assertNotNull(config.getMyValidator());
		Assert.assertNotNull(config.getWorker());
		Assert.assertNotNull(config.getRegionalDataSource());
		Assert.assertNotNull(config.getGlobalDataSource());
		Assert.assertNotNull(config.getRequestMessageLogService());
	}

}
