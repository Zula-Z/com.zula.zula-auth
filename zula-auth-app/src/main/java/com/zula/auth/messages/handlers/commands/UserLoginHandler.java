package com.zula.auth.messages.handlers.commands;

import com.zula.auth.messages.command.UserLogin;
import com.zula.queue.core.BaseCommandHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserLoginHandler extends BaseCommandHandler<UserLogin> {

    @Override
    public void processMessage(UserLogin command) {
        log.info("Handling UserLogin command: {}", command);
        // TODO: add business logic for user login handling
    }
}
