package ar.com.dariocaruso.boilerplate.services;

import ar.com.dariocaruso.boilerplate.domain.BoilerplateEntity;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {
    private final AuditReader auditReader;

    @Autowired
    public AuditServiceImpl(AuditReader auditReader) {
        this.auditReader = auditReader;
    }

    @Override
    @Transactional
    public List getRevisionsFor(String id) {
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(BoilerplateEntity.class, false, true);
        return auditQuery.getResultList();
    }
}
