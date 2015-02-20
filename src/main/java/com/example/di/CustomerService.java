package com.example.di;

import javax.sql.DataSource;

public class CustomerService {

	private DataSource dataSource;

	public Object findCustomers() {
		return null;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
