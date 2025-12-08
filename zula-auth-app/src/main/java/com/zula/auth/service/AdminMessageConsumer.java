package com.zula.auth.service;

import com.zula.auth.messages.AdminCommandMessage;
import com.zula.queue.core.BaseMessageConsumer;
import org.springframework.stereotype.Service;

@Service
public class AdminMessageConsumer extends BaseMessageConsumer<AdminCommandMessage> {

    public AdminMessageConsumer() {
        super("admin");
    }

    @Override
    public void processMessage(AdminCommandMessage message) {
        System.out.println("Admin command received: " + message.getCommand());

        switch (message.getCommand()) {
            case "RELOAD_CONFIG":
                handleReloadConfig(message);
                break;
            case "CLEAR_CACHE":
                handleClearCache(message);
                break;
            case "STATUS_REPORT":
                handleStatusReport(message);
                break;
            default:
                System.out.println("Unknown admin command: " + message.getCommand());
        }
    }

    private void handleReloadConfig(AdminCommandMessage message) {
        System.out.println("Reloading configuration...");
    }

    private void handleClearCache(AdminCommandMessage message) {
        System.out.println("Clearing cache...");
    }

    private void handleStatusReport(AdminCommandMessage message) {
        System.out.println("Generating status report...");
    }
}