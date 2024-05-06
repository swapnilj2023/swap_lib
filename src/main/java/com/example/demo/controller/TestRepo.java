package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepo {
		private JdbcTemplate jdbcTemplate;
		
	    private static final String SQL_CREATE_TABLE = ""
	            + " CREATE TABLE TEST"
	            + " ("
	            + " ID BIGINT PRIMARY KEY,"
	            + " NAME VARCHAR(100) NOT NULL,"
	            + " PRICE NUMERIC(15, 2) NOT NULL"
	            + " )";

	    @Autowired 
	    public void YourRepository(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	    
	    public void start() {
	        createTestData(true);
	    }

	    void createTestData(boolean dropTable) {

	        if (dropTable) {
	            jdbcTemplate.execute("DROP TABLE TEST");
	        }
	        jdbcTemplate.execute(SQL_CREATE_TABLE);
	    }
}
