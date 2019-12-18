package es.catalog.teachers.service.impl;

import org.springframework.stereotype.Service;

import es.catalog.teachers.entity.Teacher;
import es.catalog.teachers.repository.TeacherRepository;
import es.catalog.teachers.service.TeacherService;
import es.catalog.teachers.web.dto.TeacherDTO;

@Service
public class TeacherServiceImpl implements TeacherService {

	private final TeacherRepository teacherRepository;
	
	//Dependency injection with constructor.
	public TeacherServiceImpl(TeacherRepository teacherRepository) {
		super();
		this.teacherRepository = teacherRepository;
	}



	public TeacherDTO add(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher(teacherDTO);

		teacher = teacherRepository.save(teacher);
		return new TeacherDTO(teacher);
	}

}
