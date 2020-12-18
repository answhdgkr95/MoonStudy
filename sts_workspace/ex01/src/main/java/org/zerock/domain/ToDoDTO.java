package org.zerock.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ToDoDTO {
	private String title;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dueDate;

}
