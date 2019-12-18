package es.catalog.courses.web;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.catalog.courses.service.CourseService;
import es.catalog.courses.web.dto.CourseDTO;

@RestController //Replace @Controller and @ResponseBody
public class CourseController {

	@Autowired
	private final CourseService courseService;
		
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	//courses -> sustantivo, plural 
	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public CourseDTO add(@RequestBody CourseDTO course) {
		return courseService.add(course);
	}


	@RequestMapping(value = "/courses", method=RequestMethod.GET)
	public Page<CourseDTO> findAll(@QueryParam("page") Integer page, @QueryParam("page")Integer size, 
								   @QueryParam("active") Boolean active) {
		return courseService.findAll(page, size, active);
	}
}
