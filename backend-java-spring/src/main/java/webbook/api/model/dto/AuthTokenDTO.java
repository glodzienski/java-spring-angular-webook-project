package webbook.api.model.dto;

import javax.validation.constraints.NotNull;

public class AuthTokenDTO {
    @NotNull
    public String token;

    public AuthTokenDTO(String token) {
        this.token = token;
    }

    public AuthTokenDTO() {
    }
}
