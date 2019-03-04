package com.kswr.wallets.api.walletsapi.domain.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String role;
}
