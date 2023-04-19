package com.capstone.pos.response;

import java.util.List;

import com.capstone.pos.model.CourseModel;

public class CoursesResponseModel {
    private int status;
    private String errorMessage;
    private List<CourseModel> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<CourseModel> getData() {
        return data;
    }

    public void setData(List<CourseModel> data) {
        this.data = data;
    }

}
