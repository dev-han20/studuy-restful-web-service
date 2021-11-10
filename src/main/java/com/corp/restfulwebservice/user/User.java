package com.corp.restfulwebservice.user;

import java.time.LocalDate;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;

	private String name;
	private LocalDate joinDate;
}
