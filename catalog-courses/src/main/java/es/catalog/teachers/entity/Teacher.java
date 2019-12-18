package es.catalog.teachers.entity;

import es.catalog.teachers.web.dto.TeacherDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Teacher {

	private int id;
	private String name;
	
	public Teacher(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Teacher(TeacherDTO inputTeacher) {
		this.id = inputTeacher.getId();
		this.name = inputTeacher.getName();
	}
}
