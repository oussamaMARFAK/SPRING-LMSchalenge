package Controllers;

import DTO.AuthorResponseDto;
import DTO.PatronRequestDto;
import DTO.PatronResponseDto;
import Services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("patrons")
public class PatronController {
    private PatronService patronService;
    @Autowired
@PostMapping("")
    public PatronResponseDto save(@RequestBody PatronRequestDto patronRequestDto) {
        return patronService.save(patronRequestDto);
    }
@DeleteMapping("/id/{id}")
    public void delete(long id) {
        patronService.delete(id);
    }
@PutMapping("/id/{id}")
    public PatronResponseDto update(@RequestBody PatronRequestDto patronRequestDto,@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        return patronService.update(patronRequestDto, id);
    }
    @GetMapping("/id/{id}")
    public PatronResponseDto findById(@PathVariable long id){
        return patronService.findById(id);
    }
}
