package Controllers;

import DTO.AuthorResponseDto;
import DTO.BookrRequestDto;
import DTO.BookrResponseDto;
import Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookController {
    private BookService bookService;
    @Autowired
@PostMapping("")
    public BookrResponseDto save(@RequestBody BookrRequestDto bookrRequestDto) {
        return bookService.save(bookrRequestDto);
    }
@DeleteMapping("/id/{id}")
    public void delete(@PathVariable long id) {
        bookService.delete(id);
    }
@PutMapping("/id/{id}")
    public BookrResponseDto update(@RequestBody BookrRequestDto bookrRequestDto,@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        return bookService.update(bookrRequestDto, id);
    }
    @GetMapping("/id/{id}")
    public BookrResponseDto findById(@PathVariable long id){
        return bookService.findById(id);
    }

}
