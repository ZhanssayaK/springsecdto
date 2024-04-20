package kz.bitlab.springsecdto.api;

import kz.bitlab.springsecdto.dto.StudentDto;
import kz.bitlab.springsecdto.model.Student;
import kz.bitlab.springsecdto.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/all")
    public List<StudentDto> getAllStudentsApi(){
        return studentService.getAllStudents();
    }

    @PostMapping(value = "/addStudent")
    public StudentDto addStudentApi( @RequestBody  StudentDto studentDto){
        System.out.println(studentDto.getFullName());
        return studentService.addStudent(studentDto);
    }

    @DeleteMapping(value = "/deleteStudent/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long id){
        studentService.deleteStudent(id);
    }
}
