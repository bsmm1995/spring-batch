package com.bsmm.springbatch.service.impl;

import com.bsmm.springbatch.domain.CreditCard;
import com.bsmm.springbatch.domain.CreditCardDto;
import com.bsmm.springbatch.repository.CreditCardRepository;
import com.bsmm.springbatch.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
    private final CreditCardRepository creditCardRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreditCardDto getById(long id) {
        return toDto(getEntity(id));
    }

    @Override
    public List<CreditCardDto> getAll() {
        return creditCardRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public CreditCardDto create(CreditCardDto data) {
        CreditCard entity = creditCardRepository.save(toEntity(data));
        return toDto(entity);
    }

    @Override
    public CreditCardDto update(long id, CreditCardDto data) {
        CreditCard entity = getEntity(id);
        return toDto(creditCardRepository.save(entity));
    }

    @Override
    public long deleteById(long id) {
        getEntity(id);
        creditCardRepository.deleteById(id);
        return id;
    }

    private CreditCard getEntity(long id) {
        return creditCardRepository.findById(id).orElseThrow(() -> new NotFoundException("The person with ID %d not exists."));
    }

    private CreditCardDto toDto(CreditCard entity) {
        return modelMapper.map(entity, CreditCardDto.class);
    }

    private CreditCard toEntity(CreditCardDto dto) {
        return modelMapper.map(dto, CreditCard.class);
    }

}
