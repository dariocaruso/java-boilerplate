package ar.com.dariocaruso.boilerplate.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Audited
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {
    @LastModifiedBy
    protected String modifiedBy;

    @LastModifiedDate
    protected LocalDateTime lastModifiedDateTime;

    @CreatedBy
    protected String createBy;

    @CreatedDate
    protected LocalDateTime createdDateTime;

    public Auditable() {
    }

    public Auditable(String modifiedBy, LocalDateTime lastModifiedDateTime,
                     String createBy, LocalDateTime createdDateTime) {
        this.modifiedBy = modifiedBy;
        this.lastModifiedDateTime = lastModifiedDateTime;
        this.createBy = createBy;
        this.createdDateTime = createdDateTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder
                .reflectionToString(this, ToStringStyle.JSON_STYLE, true, null);
    }
}
