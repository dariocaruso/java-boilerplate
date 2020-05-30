package ar.com.dariocaruso.boilerplate.dto;

import ar.com.dariocaruso.boilerplate.domain.Auditable;
import ar.com.dariocaruso.boilerplate.domain.BoilerplateEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

public class BoilerplateDTO extends Auditable {
    private Long id;
    private String name;
    private BigDecimal amount;

    //Jackson
    public BoilerplateDTO() {
    }

    public BoilerplateDTO(BoilerplateEntity entity) {
        super(entity.getModifiedBy(),
                entity.getLastModifiedDateTime(),
                entity.getCreateBy(), entity.getCreatedDateTime());
        this.id = entity.getId();
        this.name = entity.getName();
        this.amount = entity.getAmount();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BoilerplateEntity toEntity() {
        return new BoilerplateEntity(this.name, this.amount);
    }

    public static BoilerplateDTO fromEntity(BoilerplateEntity entity) {
        return new BoilerplateDTO(entity);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder
                .reflectionToString(this, ToStringStyle.JSON_STYLE, true);
    }
}
