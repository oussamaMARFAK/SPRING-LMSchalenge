package DTO;

import jakarta.persistence.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PatronResponseDto {

    private long id;
    private  String patronName;
    private  String patronEmail;
    private List<String> booksBrowed;

}
