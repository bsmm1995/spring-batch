package com.bsmm.springbatch.service.impl;

import com.bsmm.springbatch.domain.dto.CreditCardRiskDto;
import com.bsmm.springbatch.domain.entities.CreditCardRiskEntity;
import com.bsmm.springbatch.repository.CreditCardRiskRepository;
import com.bsmm.springbatch.service.CreditCardRiskService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CreditCardRiskServiceImpl implements CreditCardRiskService {
    private final CreditCardRiskRepository creditCardRiskRepository;
    private final ModelMapper modelMapper;

    @Override
    public CreditCardRiskDto getById(long id) {
        return toDto(getEntity(id));
    }

    @Override
    public List<CreditCardRiskDto> getAll() {
        return creditCardRiskRepository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public CreditCardRiskDto create(CreditCardRiskDto data) {
        CreditCardRiskEntity entity = creditCardRiskRepository.save(toEntity(data));
        return toDto(entity);
    }

    @Override
    public CreditCardRiskDto update(long id, CreditCardRiskDto data) {
        CreditCardRiskEntity entity = getEntity(id);
        return toDto(creditCardRiskRepository.save(entity));
    }

    @Override
    public long deleteById(long id) {
        getEntity(id);
        creditCardRiskRepository.deleteById(id);
        return id;
    }

    private CreditCardRiskEntity getEntity(long id) {
        return creditCardRiskRepository.findById(id).orElseThrow(() -> new NotFoundException("The record with ID %d not exists."));
    }

    private CreditCardRiskDto toDto(CreditCardRiskEntity entity) {
        return modelMapper.map(entity, CreditCardRiskDto.class);
    }

    private CreditCardRiskEntity toEntity(CreditCardRiskDto dto) {
        return modelMapper.map(dto, CreditCardRiskEntity.class);
    }
}
