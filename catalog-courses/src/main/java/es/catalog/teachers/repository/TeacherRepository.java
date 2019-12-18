package es.catalog.teachers.repository;

import org.springframework.data.repository.CrudRepository;

import es.catalog.teachers.entity.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
