package com.security.api.configuration;

import com.security.api.model.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Optional;

public class AuditableConfig implements AuditorAware<User> {
    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> user = Optional.empty();

        if (auth != null) {
            try {
                user = Optional.ofNullable(SecurityContextHolder.getContext())
                    .map(SecurityContext::getAuthentication)
                    .filter(Authentication::isAuthenticated)
                    .map(Authentication::getPrincipal)
                    .map(User.class::cast);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}
