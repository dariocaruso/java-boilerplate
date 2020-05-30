package ar.com.dariocaruso.boilerplate.services;

import ar.com.dariocaruso.boilerplate.domain.BoilerplateEntity;
import com.querydsl.core.types.Order;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;

public interface BoilerplateService {
    BoilerplateEntity getEntity(Long id);
    Page<BoilerplateEntity> find(Boolean active, String name, BigDecimal amount,
                                 Integer pageNumber, Integer pageSize,
                                 String sortField, Order sortDirection);
    void deleteEntity(Long id);

    BoilerplateEntity createEntity(BoilerplateEntity entity);

    BoilerplateEntity updateEntity(Long id, BoilerplateEntity newEntity);
}
