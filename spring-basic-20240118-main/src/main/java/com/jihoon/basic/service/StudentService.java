package com.jihoon.basic.service;

import org.springframework.http.ResponseEntity;

import com.jihoon.basic.dto.request.student.PostStudentRequestDto;

public interface StudentService {
    ResponseEntity<String> postStudent(PostStudentRequestDto dto);
}
