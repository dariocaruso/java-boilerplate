package ar.com.dariocaruso.boilerplate.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBoilerplateEntity is a Querydsl query type for BoilerplateEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBoilerplateEntity extends EntityPathBase<BoilerplateEntity> {

    private static final long serialVersionUID = 797997287L;

    public static final QBoilerplateEntity boilerplateEntity = new QBoilerplateEntity("boilerplateEntity");

    public final QAuditable _super = new QAuditable(this);

    public final BooleanPath active = createBoolean("active");

    public final NumberPath<java.math.BigDecimal> amount = createNumber("amount", java.math.BigDecimal.class);

    //inherited
    public final StringPath createBy = _super.createBy;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDateTime = _super.createdDateTime;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDateTime = _super.lastModifiedDateTime;

    //inherited
    public final StringPath modifiedBy = _super.modifiedBy;

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

