package com.example.di;

import javax.sql.DataSource;

public class SecurityService {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}
