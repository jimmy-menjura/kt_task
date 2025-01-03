package com.example.challengeTask;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.challengeTask.models.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
class TaskControllerTest {
	private final static String URL_BASE = "/api";

	MockMvc mockmvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	@BeforeEach
	void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
				
	}
	@Test
	void getTask() throws Exception{
		MvcResult mvcResult= mockmvc.perform(MockMvcRequestBuilders.get(URL_BASE)
		.accept(MediaType.APPLICATION_JSON))
		.andReturn();
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	@Test
	void create() throws Exception{
		Task task = buildTask();
		MvcResult result = mockmvc.perform(MockMvcRequestBuilders.get(URL_BASE)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(convertToJson(task)))
				.andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}
	private Task buildTask() {
		Task task = new Task();
		task.setId(null);
		task.setTitle("prueba");
		task.setDescription("probandito");
		return task;
	}
	
	private String convertToJson(Object object) throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(object);
	}
}
