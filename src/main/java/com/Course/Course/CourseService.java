package com.Course.Course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CourseService {
	@Autowired
	private CourseRepo courseRepo;
	
	public List<Course> viewCourse() {
		System.out.println(courseRepo.findAll());
		return courseRepo.findAll();		
	}
	
	public void addCourse(long id,String title, String description) {
		courseRepo.save(new Course(id,title,description));
	}
	
	public void deleteCourse(long id) {
		courseRepo.deleteById(id);
	}
	
	public void updateCourse(long id,String title, String description) {
		courseRepo.deleteById(id);
		courseRepo.save(new Course(id,title,description));
	}
	
	

}
