package ar.com.dariocaruso.boilerplate.services;

import java.util.List;

public interface AuditService {
    List getRevisionsFor(String id);
}
