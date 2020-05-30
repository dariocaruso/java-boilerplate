package ar.com.dariocaruso.boilerplate.repositories;

import ar.com.dariocaruso.boilerplate.domain.BoilerplateEntity;
import com.querydsl.core.types.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface BoilerplateRepository extends
        JpaRepository<BoilerplateEntity, Long>,
        QuerydslPredicateExecutor<BoilerplateEntity> {

    default Page<BoilerplateEntity> find(Boolean active, String name,
                                 BigDecimal amount, int pageNumber,
                                         int pageSize, String sortField,
                                         Order sortDirection) {
        Pageable paging = QPageRequest.of(pageNumber, pageSize,
                QuerySupport.getOrderSpecifier(sortField, sortDirection));
        return findAll(QuerySupport.getPredicate(active, name, amount), paging);
    }
}
