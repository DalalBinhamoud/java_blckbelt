package com.dalal.taskManager.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tasks")
//public class Task implements Comparable< Task >{
public class Task{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @NotNull
    private String title;
    private String creator;
    private String priority;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    public Task() {
        
    }
    
    public Long getId(){
    	return this.id;
    }
    
    public String getTitle() {
    	return this.title;
    }
    public String getCreator() {
    	return this.creator;
    }
    public String getPriority() {
    	return this.priority;
    }
    public User getUser() {
    	return this.user ;
    }
    
    
    public void setId(Long id) {
   	 this.id =id;
   }
    
    public void setTitle(String title) {
    	 this.title =title;
    }
    public void setCreator(String creator) {
    	 this.creator=creator;
    }
    public void setPriority(String priority) {
    	 this.priority =priority;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
//    @Override
//    public int compareTo(Task t) {
//        return this.getPriority().compareTo(t.getPriority());
//    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}