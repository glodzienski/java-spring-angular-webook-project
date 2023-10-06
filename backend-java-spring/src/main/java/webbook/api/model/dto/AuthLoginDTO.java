package webbook.api.model.dto;

import javax.validation.constraints.NotNull;

public class AuthLoginDTO {
    @NotNull
    public String email;

    @NotNull
    public String password;
}
