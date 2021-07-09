package com.enigma.challengegoldpocket.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private String id;
    private String username;
    private Boolean status;
    private String email;
    private String firstName;
    private String lastName;

}
