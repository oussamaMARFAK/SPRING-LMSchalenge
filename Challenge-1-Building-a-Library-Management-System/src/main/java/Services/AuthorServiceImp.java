package Services;

import DTO.AuthorRequestDto;
import DTO.AuthorResponseDto;
import Entities.Author;
import Repositories.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImp implements AuthorService {
    private AuthorRepository authorRepository;
    private ModelMapper modelMapper;

    public AuthorServiceImp(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthorResponseDto save(AuthorRequestDto authorRequestDto) {

        Author author=modelMapper.map(authorRequestDto,Author.class);
        Author saved=authorRepository.save(author);
        return modelMapper.map(saved, AuthorResponseDto.class);      }


    @Override
    public void delete(long id) {
        authorRepository.delete(id);

    }

    @Override
    public AuthorResponseDto update(AuthorRequestDto authorRequestDto, long id) throws ChangeSetPersister.NotFoundException {
        Optional<Author> optionalAuthor=authorRepository.findById(id);
        if (optionalAuthor.isPresent()){
            Author author=modelMapper.map(authorRequestDto,Author.class);
            author.setId(id);
            Author updated=authorRepository.save(author);
            return modelMapper.map(updated, AuthorResponseDto.class);
        }else{
            throw new ChangeSetPersister.NotFoundException();
        }    }

    @Override
    public AuthorResponseDto findById() {
        return null;
    }

    @Override
    public AuthorResponseDto findById(long id) {
        Author author= authorRepository.findById(id).orElseThrow(() -> new RuntimeException("author not found"));

        return modelMapper.map(author, AuthorResponseDto.class);    }




}
