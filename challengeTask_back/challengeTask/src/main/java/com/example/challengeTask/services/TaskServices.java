package com.example.challengeTask.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.challengeTask.models.Task;
import com.example.challengeTask.util.Constants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class TaskServices {

	
	private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Task> getAllTask() {
        try {
            File file = new File(Constants.FILE_PATH);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Task>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
    
    public Boolean deleteAllTask(String id) {
    	  List<Task> dataList = getAllTask();
          boolean isRemoved = dataList.removeIf(data -> data.getId().equals(id));
          if (isRemoved) {
              saveTask(dataList);
          }
          return isRemoved;
    }

    public void saveTask(List<Task> data) {
        try {
            objectMapper.writeValue(new File(Constants.FILE_PATH), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
