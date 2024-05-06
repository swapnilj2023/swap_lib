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

	    public void start() {
	        createTestData(true);
	    }

	    public void createTestData(boolean dropTable) {
	    	 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	         dataSource.setDriverClassName("org.postgresql.Driver");
	         dataSource.setUrl("jdbc:postgresql://localhost:5432/crm_db?currentSchema=lib");
	         dataSource.setUsername("postgres");
	         dataSource.setPassword("root");

	    	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	        if (dropTable) {
	            jdbcTemplate.execute("DROP TABLE TEST");
	        }
	        jdbcTemplate.execute(SQL_CREATE_TABLE);
	    }
}
