package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatronRequestDto {

    private  String patronName;
    private  String patronEmail;
    private List<String> booksBrowed;


}
