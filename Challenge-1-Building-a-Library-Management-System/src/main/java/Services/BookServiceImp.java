package Services;

import DTO.BookrRequestDto;
import DTO.BookrResponseDto;
import Entities.Book;
import Repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImp implements BookService{
    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    @Override
    public BookrResponseDto save(BookrRequestDto bookrRequestDto) {

        Book book=modelMapper.map(bookrRequestDto,Book.class);
        Book saved=bookRepository.save(book);
        return modelMapper.map(saved, BookrResponseDto.class);    }
@Override
    public BookrResponseDto findById(long id) {
       Book book=bookRepository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
        return modelMapper.map(book, BookrResponseDto.class);
    }




    @Override
    public void delete(long id) {
        bookRepository.delete(id);
    }



    @Override
    public BookrResponseDto update(BookrRequestDto bookrRequestDto, long id) throws ChangeSetPersister.NotFoundException {
        Optional<Book> bookOptional=bookRepository.findById(id);
        if (bookOptional.isPresent()){
            Book book=modelMapper.map(bookrRequestDto,Book.class);
            book.setId(id);
            Book bookupdated=bookRepository.save(book);
            return modelMapper.map(bookupdated,BookrResponseDto.class);
        }else{
            throw new ChangeSetPersister.NotFoundException();
        }
    }
    }


