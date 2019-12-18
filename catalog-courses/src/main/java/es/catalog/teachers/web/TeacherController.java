package es.catalog.teachers.web;

import es.catalog.teachers.service.TeacherService;
import es.catalog.teachers.web.dto.TeacherDTO;

public class TeacherController {
	
	private final TeacherService teacherService;
	
	public TeacherController(TeacherService teacherService) {
		super();
		this.teacherService = teacherService;
	}



	public TeacherDTO add(TeacherDTO teacher) {
		return teacherService.add(teacher);
	}
}
