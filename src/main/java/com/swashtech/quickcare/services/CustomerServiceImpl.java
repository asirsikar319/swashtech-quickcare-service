package com.swashtech.quickcare.services;

import org.bson.Document;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public JSONObject registerCustomer(JSONObject jInput) {
		JSONObject jsonObject = new JSONObject();
		try {
			Document document = Document.parse(jInput.toString());
			document = mongoTemplate.save(document, "customer");
			logger.debug(document.toJson());
			jsonObject.put("status", "Success");
		} catch (Exception e) {
			jsonObject.put("status", "Error");
			jsonObject.put("message", e.getMessage());
		}
		return jsonObject;
	}

}
