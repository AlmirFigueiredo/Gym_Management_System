package com.josealmir.gymmanagementsystem.model.groupfitclasses;
import java.time.*;
import com.josealmir.gymmanagementsystem.model.person.Trainer;

public class GroupFitClass {
    private String classId;
    private String className;
    private Integer maxCapacity;
    private LocalDate classDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Trainer trainer;

    public GroupFitClass() {}

    public String getClassId() {
        return classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public Integer getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public LocalDate getClassDate() {
        return classDate;
    }
    public void setClassDate(LocalDate classDate) {
        this.classDate = classDate;
    }
    public LocalTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    

}
