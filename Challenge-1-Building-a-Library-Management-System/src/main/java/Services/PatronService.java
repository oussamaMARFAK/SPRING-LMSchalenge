package Services;

import DTO.AuthorResponseDto;
import DTO.PatronRequestDto;
import DTO.PatronResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface PatronService {

    PatronResponseDto save(PatronRequestDto patronRequestDto);
//    PatronResponseDto findByName(String patronName);
    void delete(long id);
    PatronResponseDto update(PatronRequestDto patronRequestDto,long id) throws ChangeSetPersister.NotFoundException;

    PatronResponseDto findById(long id);
//     PatronResponseDto findAll();





}
