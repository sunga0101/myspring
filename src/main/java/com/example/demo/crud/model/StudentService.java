package com.example.demo.crud.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private Long nextId=1L;


    // 복수의 StudentDto 담는 변수(필드)
    private final List<StudentDto> studentList = new ArrayList<>();


    // 새로운 StudentDto 생성하는 메소드
    public StudentDto createStudent(String name, String email){
        StudentDto newStudent = new StudentDto(nextId,name,email);
        nextId++;
        studentList.add(newStudent);
        return newStudent;
    }

    public List<StudentDto> readAllStudent(){
        return studentList;
    }





}
