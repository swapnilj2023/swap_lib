package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class TestRepo {
//		private JdbcTemplate jdbcTemplate;
//
//	    @Autowired 
//	    public void YourRepository(JdbcTemplate jdbcTemplate) {
//	        this.jdbcTemplate = jdbcTemplate;
//	    }
	    
	    private static final String SQL_CREATE_TABLE = ""
	            + " CREATE TABLE TEST"
	            + " ("
	            + " ID BIGINT PRIMARY KEY,"
	            + " NAME VARCHAR(100) NOT NULL,"
	            + " PRICE NUMERIC(15, 2) NOT NULL"
	            + " )";


	    public void createTestData(boolean dropTable,String url,String username,String password) {
	    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	         dataSource.setDriverClassName("org.postgresql.Driver");
	         dataSource.setUrl(url);
	         dataSource.setUsername(username);
	         dataSource.setPassword(password);

	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        if (dropTable) {
	            jdbcTemplate.execute("DROP TABLE TEST");
	        }
	        jdbcTemplate.execute(SQL_CREATE_TABLE);
	    }
}
