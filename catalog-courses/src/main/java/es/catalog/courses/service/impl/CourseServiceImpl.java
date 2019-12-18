package es.catalog.courses.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import es.catalog.courses.entity.Course;
import es.catalog.courses.repository.CourseRepository;
import es.catalog.courses.service.CourseService;
import es.catalog.courses.web.dto.CourseDTO;



@Service
public class CourseServiceImpl implements CourseService {

	private final int page;
	private final int size;
	
	private final CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository courseRepository,
							 @Value("{page}")Integer page, @Value("${size}")Integer size) {
		super();
		this.courseRepository = courseRepository; 
		this.page = page;
		this.size = size;
	}



	public CourseDTO add(CourseDTO courseDto) {
		Course course = courseRepository.save(new Course(courseDto));
		return new CourseDTO(course);
	}

	
	
	public Page<CourseDTO> findAll(Integer page, Integer size, Boolean active) {
		Page<Course> listCourses = null;
		
		Pageable pageRequest = page(page, size);
		
		if (null != active) {
			listCourses = courseRepository.findAllByActive(pageRequest, active);
		} else {
			listCourses = courseRepository.findAll(pageRequest);
		}
	
		List<CourseDTO> result = listCourses.stream().map(course -> new CourseDTO(course)).collect(Collectors.toList());
	
		return new PageImpl<CourseDTO>(result, listCourses.getPageable(), listCourses.getTotalElements());
	}
	
	
	private Pageable page(Integer page, Integer size) {
		if  (null == page) {
			return  PageRequest.of(this.page, this.size);
		}
		return  PageRequest.of(page, size);
	}
}
