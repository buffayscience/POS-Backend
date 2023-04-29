package com.capstone.pos.model;

import java.util.List;

public class ProgramOfStudy {
    List<StudentCourseModel> courses;

    public List<StudentCourseModel> getCourses() {
        return courses;
    }

    public void setCourses(List<StudentCourseModel> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "ProgramOfStudy [courses=" + courses + "]";
    }

    

    
}
