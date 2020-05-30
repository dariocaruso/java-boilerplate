package ar.com.dariocaruso.boilerplate.services;

import ar.com.dariocaruso.boilerplate.domain.BoilerplateEntity;
import ar.com.dariocaruso.boilerplate.repositories.BoilerplateRepository;
import com.querydsl.core.types.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BoilerplateServiceImpl implements BoilerplateService {
    private final BoilerplateRepository repository;

    @Autowired
    public BoilerplateServiceImpl(BoilerplateRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public BoilerplateEntity getEntity(Long id) {
        return repository.getOne(id);
    }

    @Transactional(readOnly = true)
    public Page<BoilerplateEntity> find(Boolean active, String name,
                                        BigDecimal amount, Integer pageNumber,
                                        Integer pageSize, String sortField,
                                        Order sortDirection) {
        return repository.find(active, name, amount, pageNumber, pageSize,
                sortField, sortDirection);
    }

    @Transactional
    public void deleteEntity(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public BoilerplateEntity createEntity(BoilerplateEntity entity) {
        return repository.save(entity);
    }

    @Transactional
    public BoilerplateEntity updateEntity(Long id,
                                          BoilerplateEntity newEntity) {
        BoilerplateEntity entity = repository.getOne(id);
        entity.setName(newEntity.getName());
        entity.setAmount(newEntity.getAmount());
        return repository.save(entity);
    }
}
