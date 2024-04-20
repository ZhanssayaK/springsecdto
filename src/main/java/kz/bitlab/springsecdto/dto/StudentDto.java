package kz.bitlab.springsecdto.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class StudentDto {
    private Long id;
    private String fullName;
    private double gpa;
}
