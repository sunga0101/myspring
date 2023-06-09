package com.example.demo.crud.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private Long nextId=1L;


    public StudentService() {
        createStudent("alpha", "alpha@gmail.com");
        createStudent("beta", "beta@gmail.com");
        createStudent("ghama", "ghama@gmail.com");
    }
    // 복수의 StudentDto 담는 변수(필드)

    private final List<StudentDto> studentList = new ArrayList<>();

    // 새로운 StudentDto 생성하는 메소드

    public StudentDto createStudent(String name, String email){
        StudentDto newStudent = new StudentDto(nextId,name,email);
        nextId++;
        studentList.add(newStudent);
        return newStudent;
    }
    // StudentDto 업데이트하는 메소드

    public StudentDto updateStudent(Long id, String name, String email){
        // 하나의 StudentDto를 찾아서
        int target = -1;
        // studentList의 크기만큼 반복
        for (int i = 0; i < studentList.size(); i++) {
            // id가 동일한 studentDto 찾았으면
            if (studentList.get(i).getId().equals(id)) {
                // 인덱스 기록
                target = i;
                // 반복 종료
                break;
            }
        }
        // 대상을 찾았다면
        if (target != -1) {
            // name과 email을 바꿔주자
            studentList.get(target).setName(name);
            studentList.get(target).setEmail(email);
            return studentList.get(target);
        }
        // 대상을 못찾았다면
        else return null;
    }

    public List<StudentDto> readAllStudent(){
        return studentList;
    }
    // Service에서 하나의 StudentDto를 반환하는 메소드

    public StudentDto readStudent(Long id){
        for (StudentDto studentDto: studentList) {
            if(studentDto.getId().equals(id))
                return studentDto;
        }
        return null;
    }

    // 학생 삭제하는 메소드
    public boolean deleteStudent(Long id){
        int target = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)){
                target = i;
                break;
            }
        }

        // 검색 성공시
        if (target != -1) {
            studentList.remove(target);
            return true;
        }
        else return true;
    }


}
