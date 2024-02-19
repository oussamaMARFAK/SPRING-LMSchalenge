package Services;

import DTO.PatronRequestDto;
import DTO.PatronResponseDto;
import Entities.Patron;
import Repositories.PatronRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatronServiceImp implements PatronService{

    private PatronRepository patronRepository;
    private ModelMapper modelMapper;

    public PatronServiceImp(PatronRepository patronRepository, ModelMapper modelMapper) {
        this.patronRepository = patronRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PatronResponseDto save(PatronRequestDto patronRequestDto) {

        Patron patron=modelMapper.map(patronRequestDto,Patron.class);
        Patron saved=patronRepository.save(patron);
        return modelMapper.map(saved,PatronResponseDto.class);
    }


@Override
    public PatronResponseDto findById(long id) {
        Patron patron= patronRepository.findById(id).orElseThrow(() -> new RuntimeException("patron not found"));
        return modelMapper.map(patron,PatronResponseDto.class);
    }

    @Override
    public void delete(long id) {
        patronRepository.delete(id);

    }

    @Override
    public PatronResponseDto update(PatronRequestDto patronRequestDto, long id) throws ChangeSetPersister.NotFoundException {

        Optional<Patron> optionalPatron=patronRepository.findById(id);
        if (optionalPatron.isPresent()){
            Patron patron=modelMapper.map(patronRequestDto,Patron.class);
            patron.setId(id);
            Patron updated=patronRepository.save(patron);
            return modelMapper.map(updated,PatronResponseDto.class);
        }else{
            throw new ChangeSetPersister.NotFoundException();
        }
    }


}
