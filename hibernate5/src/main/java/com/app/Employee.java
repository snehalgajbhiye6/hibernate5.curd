package com.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
	private String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
