package ar.com.dariocaruso.boilerplate.controllers;

import ar.com.dariocaruso.boilerplate.domain.BoilerplateEntity;
import ar.com.dariocaruso.boilerplate.dto.BoilerplateDTO;
import ar.com.dariocaruso.boilerplate.dto.PageDTO;
import ar.com.dariocaruso.boilerplate.services.AuditService;
import ar.com.dariocaruso.boilerplate.services.BoilerplateService;
import com.querydsl.core.types.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/boilerplate")
public class BoilerplateController {
    private final BoilerplateService service;
    private final AuditService auditService;

    @Autowired
    public BoilerplateController(BoilerplateService service, AuditService auditService) {
        this.service = service;
        this.auditService = auditService;
    }

    @GetMapping
    public ResponseEntity<PageDTO> findAll(
            @RequestParam(name = "active", required = false) Boolean active,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "amount", required = false) BigDecimal amount,
            @RequestParam(name = "pageNumber") Integer pageNumber,
            @RequestParam(name = "pageSize") Integer pageSize,
            @RequestParam(name = "sortField") String sortField,
            @RequestParam(name = "sortDirection") Order sortDirection) {
        Page<BoilerplateEntity> page = service.find(active, name, amount,
                pageNumber, pageSize, sortField, sortDirection);
        return ResponseEntity.ok(new PageDTO(page.get().map(BoilerplateDTO::new).collect(
                toList()), page.getTotalElements()));
    }

    @GetMapping("{id}")
    public ResponseEntity<BoilerplateDTO> findOne(@PathVariable Long id) {
        return ResponseEntity.ok(BoilerplateDTO.fromEntity(service.getEntity(id)));
    }

    @PostMapping
    public ResponseEntity<BoilerplateDTO> create(@RequestBody BoilerplateDTO boilerplateDTO) {
        BoilerplateEntity entity =
                service.createEntity(boilerplateDTO.toEntity());
        return ResponseEntity.ok(BoilerplateDTO.fromEntity(entity));
    }

    @PutMapping("{id}")
    public ResponseEntity<BoilerplateDTO> update(@RequestBody BoilerplateDTO boilerplateDTO, @PathVariable Long id) {
        BoilerplateEntity entity = service.updateEntity(id,
                boilerplateDTO.toEntity());
        return ResponseEntity.ok(BoilerplateDTO.fromEntity(entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteEntity(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{id}/audit")
    public ResponseEntity<?> getAudit(@PathVariable String id) {
        List<Object[]> versions = auditService.getRevisionsFor(id);
        versions.stream().forEach(v -> {
            System.out.println("Entity = " + v[0]);
            System.out.println("DefaultRevisionEntity = " + v[1]);
            System.out.println("RevisionType = " + v[2]);
        });
        return ResponseEntity.ok(versions.stream().map(v -> v[0]));
    }
}
