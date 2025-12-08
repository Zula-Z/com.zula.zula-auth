package com.zula.auth.messages.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zula.queue.core.ZulaCommand;
import com.zula.queue.core.ZulaPublish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ZulaCommand
@ZulaPublish(service = "zula-auth")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateUser {
    private String email;
    private String password;
    private String username;
}
