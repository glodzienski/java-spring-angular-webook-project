package webbook.api.entity.dto;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class CustomGrantedAuthorityDTO implements GrantedAuthority, Serializable {

    private String name;

    public CustomGrantedAuthorityDTO(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }

}
