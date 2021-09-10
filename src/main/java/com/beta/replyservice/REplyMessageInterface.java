package com.beta.replyservice;

import org.json.JSONObject;

public interface REplyMessageInterface {
    JSONObject readPayloadAndProcess(String payload);
}
