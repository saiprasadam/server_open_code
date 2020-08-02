package com.openshift.coursecatalogue.repositories;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.openshift.coursecatalogue.model.Users;
import com.openshift.coursecatalogue.util.MailServices;

/**
 * @author kaleembasha.akbar
 *
 *         User Repository File. Custom repository methods can be added
 */
@Repository
public class UserRepo {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	public ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MailServices mailServices;

	public List<Users> findAll() {
		return mongoTemplate.findAll(Users.class);
	}

	public Users findOne(String userid) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userid));
		return mongoTemplate.findOne(query, Users.class);
	}

	public Users findByName(String name) {
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		return mongoTemplate.findOne(query, Users.class);
	}

	public String insertUsers(Users userData) {
		try {
			JsonNode userNode = mapper.createObjectNode();
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(userData.getName()));
			Users exitUser = mongoTemplate.findOne(query, Users.class);
			if (exitUser != null) {
				((ObjectNode) userNode).put("subject", "Welcome Online Course");
				((ObjectNode) userNode).put("message", "Hi " + userData.getName()
						+ ",  \n\n Welcome to PERFICIENT online courses. Your user name is already exits. \n\n Please change your user name");
				((ObjectNode) userNode).put("to", userData.getEmail());
				mailServices.sendMail(userNode);
				return "User is exited already";

			} else {
				Users user1 = mongoTemplate.save(userData, "Users");
				((ObjectNode) userNode).put("subject", "Welcome Online Course");
				((ObjectNode) userNode).put("message", "Hi " + userData.getName()
						+ ",  \n\n Welcome to PERFICIENT online courses. Your account has been created successfully. Your user name is "
						+ userData.getName() + " and your temporary password is " + userData.getPassword()
						+ " \n\n Please visit this link http://localhost:8080");
				((ObjectNode) userNode).put("to", userData.getEmail());
				mailServices.sendMail(userNode);
				return "User created successfully";
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public JsonNode getTemporaryPassword(String tomail, String userName) {
		JsonNode userNode = mapper.createObjectNode();
		Query query = new Query();
		try {
			query.addCriteria(Criteria.where("name").is(userName));
			Users exitUser = mongoTemplate.findOne(query, Users.class);
			if (exitUser != null) {
				((ObjectNode) userNode).put("subject", "Temporary Password");
				((ObjectNode) userNode).put("message",
						"Hi " + userName + "  \n\n Welcome to PERFICIENT online courses. Your Temporary Password is "
								+ exitUser.getPassword() + " \n\n Please visit this link http://localhost:8080");
				((ObjectNode) userNode).put("link", "Please visit this link http://localhost:8080");
				((ObjectNode) userNode).put("to", tomail);
				return userNode;
			} else {
				((ObjectNode) userNode).put("subject", "Temporary Password");
				((ObjectNode) userNode).put("message", "Hi " + userName
						+ "  \n\n Welcome to PERFICIENT online courses. You are not registered user. Please register online course. \n\n Please visit this link http://localhost:8080");
				((ObjectNode) userNode).put("link", "Please visit this link http://localhost:8080");
				((ObjectNode) userNode).put("to", tomail);
				return userNode;
			}
		}catch(NullPointerException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userNode;
		
	}

	public String sendTemporaryPassword(String toEmail, String userId) {
		mailServices.sendMail(getTemporaryPassword(toEmail, userId));
		return "Email send successfully";
	}

}
