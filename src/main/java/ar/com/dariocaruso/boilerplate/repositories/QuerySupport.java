package ar.com.dariocaruso.boilerplate.repositories;

import ar.com.dariocaruso.boilerplate.domain.QBoilerplateEntity;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

import java.math.BigDecimal;

public class QuerySupport {
    private static final QBoilerplateEntity ENTITY = QBoilerplateEntity.boilerplateEntity;

    public static BooleanExpression getPredicate(Boolean active, String name, BigDecimal amount) {
        BooleanExpression predicate = ENTITY.id.isNotNull();

        if (active != null) {
            predicate = predicate.and(ENTITY.active.eq(active));
        }

        if (name != null) {
            predicate = predicate.and(ENTITY.name.like(name));
        }

        if (amount != null) {
            predicate = predicate.and(ENTITY.amount.eq(amount));
        }
        return predicate;
    }

    public static OrderSpecifier<?> getOrderSpecifier(
            String sortField, Order sortDirection) {
        return new OrderSpecifier(sortDirection, Expressions.stringPath(ENTITY,
                sortField));
    }
}
