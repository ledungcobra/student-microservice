package com.ledungcobra.service;

import com.ledungcobra.entity.Student;
import com.ledungcobra.feignclients.AddressService;
import com.ledungcobra.repository.StudentRepository;
import com.ledungcobra.request.CreateStudentRequest;
import com.ledungcobra.response.AddressResponse;
import com.ledungcobra.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressService addressService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student();
        student.setFirstName(createStudentRequest.getFirstName());
        student.setLastName(createStudentRequest.getLastName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddressId(createStudentRequest.getAddressId());
        student = studentRepository.save(student);
        var response =  new StudentResponse(student);
        response.setAddressResponse(addressService.getById(createStudentRequest.getAddressId()));
        return response;
    }

    public StudentResponse getById(long id) {
        var opStudent = studentRepository.findById(id);
        if (opStudent.isEmpty()) {
            return null;
        }
        Student student = opStudent.get();
        var response =  new StudentResponse(student);
        response.setAddressResponse(addressService.getById(student.getAddressId()));
        return response;
    }
}
