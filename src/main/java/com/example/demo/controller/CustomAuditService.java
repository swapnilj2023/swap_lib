package com.example.demo.controller;

import java.lang.reflect.Field;

import org.springframework.web.bind.annotation.Mapping;

public class CustomAuditService {
	
	public String compareTo(Object o, Object n) {
	    StringBuilder result = new StringBuilder();
	    try {
	        Field[] fields = o.getClass().getDeclaredFields();
	        for (Field field : fields) {
	            if (!field.isAnnotationPresent(Mapping.class)) {
	                String fieldName = field.getName();
	                field.setAccessible(true);
	                Object oldFieldValue = field.get(o);
	                Object newFieldValue = field.get(n);
	                if (ConditionCheck.checkValues(oldFieldValue, newFieldValue)) {
	                    result.append(fieldName)
	                          .append("--->")
	                          .append(newFieldValue)
	                          .append("--->")
	                          .append(oldFieldValue)
	                          .append("::::");
	                }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    return result.toString();
	}
}
