package com.openshift.coursecatalogue.repositories;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.schema.JsonSchemaObject.Type.BsonType;
import org.springframework.stereotype.Repository;

import com.openshift.coursecatalogue.model.Courses;
import com.openshift.coursecatalogue.model.Enrollments;

/**
 * @author kaleembasha.akbar
 *
 * Enrollment Repository File. Custom repository methods can be added
 */
@Repository
public class EnrollmentRepo{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Enrollments> findAll(){
		return mongoTemplate.findAll(Enrollments.class);
	};

	public Enrollments findOne(ObjectId objId) {
		// TODO Auto-generated method stub
		//System.out.println("-----"+objectId);
		//LOG.info("courseId"+courseId)
		//Query query = new Query();
		//objId.toString()
		
		//query.addCriteria(Criteria.where("course_id").is(new MongoId(5f0458b7545012caccdd0872')));
			//	.ObjectId("34234234234234234234")));
		//mongoTemplate.findById(query, Enrollment.class);
		//return mongoTemplate.findAll(Enrollment.class);
		Enrollments enrollVal=new Enrollments();
		List<Enrollments> enroll=new ArrayList<>();
		System.out.println(mongoTemplate.findById(objId.toString(), Enrollments.class));
		//enroll=mongoTemplate.findById(objId.toString(), Enrollments.class);
		enroll=mongoTemplate.findAll(Enrollments.class);
		for(Enrollments en:enroll) {
			if(en.getUserId().equals(objId.toString())) {
				enrollVal.setUserId(en.getUserId());
				enrollVal.setStartDate(en.getStartDate());
				enrollVal.setCourseId(en.getCourseId());
				enrollVal.setEndDate(en.getEndDate());
				enrollVal.setState(en.getState());
			}
		}
		return enrollVal; 
			//((Object) mongoTemplate).findBy_course_id(objId);
//mongoTemplate.getMongoDbFactory().g
	//	return mongoTemplate.findById(objId, Enrollments.class);
	}

	private Object newO(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
