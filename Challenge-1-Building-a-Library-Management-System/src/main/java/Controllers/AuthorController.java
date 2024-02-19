package Controllers;

import DTO.AuthorRequestDto;
import DTO.AuthorResponseDto;
import Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("authors")
public class AuthorController {
private AuthorService authorService;
@Autowired

@GetMapping("/id/{id}")
    public AuthorResponseDto findById(@PathVariable long id){
    return authorService.findById(id);
}
@DeleteMapping("/id/{id}")
    public  void delete(@PathVariable long id){
    authorService.delete(id);
}
@PostMapping("")
public AuthorResponseDto save(@RequestBody AuthorRequestDto authorRequestDto){
    return authorService.save(authorRequestDto);
}
@PutMapping("/id/{id}")
    public AuthorResponseDto update(@RequestBody AuthorRequestDto authorRequestDto,@PathVariable long id) throws ChangeSetPersister.NotFoundException {
    return authorService.update(authorRequestDto,id);
}


}
