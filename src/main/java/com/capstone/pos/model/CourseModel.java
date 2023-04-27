package com.capstone.pos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class CourseModel {
 
 
    @Id
    private String courseId;
    private String courseName;
    private boolean isGraduateLevel;
    private int courseLevel;
    private int maxCredits;
    private int minCredits;
    private String departmentCode;

 

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isGraduateLevel() {
        return isGraduateLevel;
    }

    public void setGraduateLevel(boolean isGraduateLevel) {
        this.isGraduateLevel = isGraduateLevel;
    }

    public int getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(int courseLevel) {
        this.courseLevel = courseLevel;
    }

    public int getMaxCredits() {
        return maxCredits;
    }

    public void setMaxCredits(int maxCredits) {
        this.maxCredits = maxCredits;
    }

    public int getMinCredits() {
        return minCredits;
    }

    public void setMinCredits(int minCredits) {
        this.minCredits = minCredits;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    

}
