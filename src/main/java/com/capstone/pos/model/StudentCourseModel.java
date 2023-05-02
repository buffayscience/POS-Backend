package com.capstone.pos.model;

public class StudentCourseModel {

    private int area; // 1 for major // 2 for minor and 3 for math/quant
    private boolean isMastersCourse;
    private boolean isMathCourse;
    private String courseName;
    private String courseId;
    private int courseLevel;
    private boolean isUWMCourse;
    private int credits;
    private int year;
    private String term;

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isMastersCourse() {
        return isMastersCourse;
    }

    public void setMastersCourse(boolean isMastersCourse) {
        this.isMastersCourse = isMastersCourse;
    }

    public boolean isMathCourse() {
        return isMathCourse;
    }

    public void setMathCourse(boolean isMathCourse) {
        this.isMathCourse = isMathCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCourseLevel() {
        return courseLevel;
    }

    public void setCourseLevel(int courseLevel) {
        this.courseLevel = courseLevel;
    }

    public boolean isUWMCourse() {
        return isUWMCourse;
    }

    public void setUWMCourse(boolean isUWMCourse) {
        this.isUWMCourse = isUWMCourse;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "StudentCourseModel [area=" + area + ", isMastersCourse=" + isMastersCourse + ", isMathCourse="
                + isMathCourse + ", courseName=" + courseName + ", courseId=" + courseId + ", courseLevel="
                + courseLevel + ", isUWMCourse=" + isUWMCourse + ", credits=" + credits + ", year=" + year + ", term="
                + term + "]";
    }

    

   
    

}
