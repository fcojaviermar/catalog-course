package es.catalog.courses.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.catalog.courses.entity.Course;

//@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Page<Course> findAllByActive(Pageable pageRequest, boolean active);
}
