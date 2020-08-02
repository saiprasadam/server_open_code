package com.openshift.coursecatalogue.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openshift.coursecatalogue.model.Courses;
import com.openshift.coursecatalogue.model.Enrollments;
import com.openshift.coursecatalogue.repositories.CourseRepo;
import com.openshift.coursecatalogue.repositories.EnrollmentRepo;

/**
 * @author kaleembasha.akbar
 *
 * Service class for Course related stuffs.
 */
@Service
public class CourseService {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CourseRepo courseRepo;

	@Autowired
	private EnrollmentRepo  enrollmentRepo;
	
	public List<Courses> findAll(){
		return courseRepo.findAll();
	}


	public Courses findOne(String courseId) {
		// TODO Auto-generated method stub
		return courseRepo.findOne(courseId);
	}


	public Enrollments findEnrollCourse(ObjectId objectId) {
		// TODO Auto-generated method stub
			Enrollments enroll= new Enrollments();
		
		 Enrollments lst=enrollmentRepo.findOne(objectId);
		/* for(Enrollment en:lst) {
			 if(en.getCourse_id().equals(objectId)) {
				 enroll.setCourse_id(en.getCourse_id());
				 enroll.setStart_date(en.getStart_date());
				 enroll.setEnd_date(en.getEnd_date());
				 enroll.setStatus(en.getStatus());
				 
				 
			 }*/
	//	 }
		 return lst;
			//	findOne(courseId);
	}
}
