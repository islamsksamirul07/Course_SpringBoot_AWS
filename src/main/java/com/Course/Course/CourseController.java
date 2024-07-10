package com.Course.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
//@CrossOrigin(origins = "http://13.49.167.242:3000")
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@GetMapping("/allcourses")
	public List<Course> view(){
		return courseService.viewCourse();
	}
	@PostMapping("/courses")
	public String addCourse(@RequestBody Course course) {
		courseService.addCourse(course.getId(), course.getTitle(), course.getDescription());
		return "course added successfully";
	}
	
	@PostMapping("/delete")
//	public String deleteCourse(@RequestParam long id) {
		public String deleteCourse(@RequestParam long id) {
		courseService.deleteCourse(id);
		return "Deleted";
	}
	
	@PostMapping("/update")
	public String updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course.getId(), course.getTitle(), course.getDescription());
		return "updeted";
	}
	

}
