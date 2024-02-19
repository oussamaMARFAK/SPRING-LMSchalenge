package Services;

import DTO.AuthorRequestDto;
import DTO.AuthorResponseDto;
import DTO.PatronRequestDto;
import DTO.PatronResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface AuthorService {
    AuthorResponseDto save(AuthorRequestDto authorRequestDto);
//    AuthorResponseDto findByName(String name);
    void delete(long id);
    AuthorResponseDto update(AuthorRequestDto authorRequestDto,long id) throws ChangeSetPersister.NotFoundException;

    AuthorResponseDto findById();

    AuthorResponseDto findById(long id);
//     AuthorResponseDto findAll();





}
