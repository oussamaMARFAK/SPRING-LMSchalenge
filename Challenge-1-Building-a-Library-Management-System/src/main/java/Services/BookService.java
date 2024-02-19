package Services;

import DTO.*;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface BookService {

        BookrResponseDto save(BookrRequestDto bookrRequestDto);
//    BookrResponseDto findByTitle(String title);
    void delete(long id);
    BookrResponseDto update(BookrRequestDto bookrRequestDto,long id) throws ChangeSetPersister.NotFoundException;

    BookrResponseDto findById(long id);
//     BookrResponseDto findAll();



}
