package com.linus.restprac.model.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic("Spring",1001,"Spring tutorial"),
			new Topic("Apache Camel",1002, "Camel Tutorial"),
			new Topic("ActiveMQ",1003,"Apache Active MQ tutorial")				
			));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(int id) {
		return getAllTopics().stream().filter(t -> t.getId() == id).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(int id, Topic topic) {
		for(int i=0; i<topics.size(); i++) {
			if(topics.get(i).getId() == id)
				topics.set(i, topic);
		}
	}
	
	public void deleteTopic(int id) {
		getAllTopics().removeIf(t -> t.getId() == id);	
	}
	
}    //TopicService
