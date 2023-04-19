package com.capstone.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstone.pos.model.CourseModel;

public interface CourseModelRepository extends JpaRepository<CourseModel,String> {

    @Query("SELECT cm FROM CourseModel cm WHERE cm.departmentCode    = :deptCode")
    List<CourseModel> findByDepartmentCode(@Param("deptCode") int deptCode);
}
