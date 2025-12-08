package com.zula.auth.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminCommandMessage {
    private String command;
    private String targetService;
    private Object payload;
    private String timestamp;

    @Override
    public String toString() {
        return String.format("AdminCommand[%s: %s]", command, targetService);
    }
}
