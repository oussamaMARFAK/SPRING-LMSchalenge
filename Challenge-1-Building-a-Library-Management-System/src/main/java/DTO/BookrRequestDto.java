package DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookrRequestDto {

    private String title;

    private String isbn;
    private String publicationdate;



}
