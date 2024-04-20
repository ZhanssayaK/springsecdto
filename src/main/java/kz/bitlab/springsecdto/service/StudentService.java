package kz.bitlab.springsecdto.service;

import kz.bitlab.springsecdto.dto.StudentDto;
import kz.bitlab.springsecdto.model.Student;
import kz.bitlab.springsecdto.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDto> getAllStudents(){
        List<Student> student = studentRepository.findAll();
        List<StudentDto> studentDto = new ArrayList<>();
        student.forEach(s -> studentDto.add(toDto(s)));
        return studentDto;
    }

    public StudentDto addStudent(StudentDto studentDto){
        Student student = toEntity(studentDto);
        return toDto(studentRepository.save(student));
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    private StudentDto toDto(Student student){
        StudentDto studentDto = StudentDto
                .builder()
                .id(student.getId())
                .fullName(student.getFullName())
                .gpa(student.getGpa())
                .build();
        return studentDto;
    }

    private Student toEntity(StudentDto studentDto){
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFullName(studentDto.getFullName());
        student.setGpa(studentDto.getGpa());
        return student;
    }
}
