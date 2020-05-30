package ar.com.dariocaruso.boilerplate.domain;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * QBoilerplateEntity is a Querydsl query type for BoilerplateEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoilerplateEntity extends EntityPathBase<BoilerplateEntity> {

    private static final long serialVersionUID = 797997287L;

    public static final QBoilerplateEntity boilerplateEntity = new QBoilerplateEntity("boilerplateEntity");

    public final BooleanPath active = createBoolean("active");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QBoilerplateEntity(String variable) {
        super(BoilerplateEntity.class, forVariable(variable));
    }

    public QBoilerplateEntity(Path<? extends BoilerplateEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBoilerplateEntity(PathMetadata metadata) {
        super(BoilerplateEntity.class, metadata);
    }

}

