package com.example.demo.controller;

import java.util.EnumSet;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

public class DataBaseInitializer {
	
//    private final String schemaName;
//
//    public DataBaseInitializer(String schemaName) {
//        this.schemaName = schemaName;
//    }

    public void createTables(String schemaName) {
        // Create a Hibernate service registry
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        
        // Create metadata sources using your entity classes
        MetadataSources metadataSources = new MetadataSources(serviceRegistry);
        metadataSources.addAnnotatedClass(com.example.demo.entity.Test.class);

        // Build the metadata
        metadataSources.buildMetadata();

        // Generate the database schema with the specified schema name
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setDelimiter(";");
        schemaExport.setOutputFile("schema.sql");
        schemaExport.createOnly(EnumSet.of(TargetType.DATABASE), metadataSources.buildMetadata());
        
        // Close the service registry
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }
}

