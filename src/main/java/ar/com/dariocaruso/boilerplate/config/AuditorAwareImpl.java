package ar.com.dariocaruso.boilerplate.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //TODO - Wire up with some security
        return Optional.of("Admin");
    }
}
