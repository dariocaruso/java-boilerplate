package ar.com.dariocaruso.boilerplate.domain;

import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Audited
@Table(name = "boiler_plate")
public class BoilerplateEntity extends Auditable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal amount;

    protected BoilerplateEntity() {
    }

    public BoilerplateEntity(String name, BigDecimal amount) {
        this.name = name;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
