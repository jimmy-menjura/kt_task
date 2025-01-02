package com.example.challengeTask.models;

import java.util.Objects;
import java.util.UUID;

public class Task {

	private String id;
	private String title;
    private String description;
    
    public Task() {
        this.id = UUID.randomUUID().toString();
    }
    
    public String getId() {
    	return id;
    }
    public void setId(String id) {
    	this.id = id;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, title);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(description, other.description) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Task [id=" + id + " title=" + title + ", description=" + description + "]";
	}

    
    
}
