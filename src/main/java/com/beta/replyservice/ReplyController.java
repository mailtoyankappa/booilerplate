package com.beta.replyservice;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ReplyController {

	@Autowired
	@Lazy
	private REplyMessageInterface readPayloadAndProcess;

	@GetMapping("/reply")
	public ReplyMessage replying() {
		return new ReplyMessage("Message is empty");
	}

	@GetMapping("/reply/{message}")
	public ReplyMessage replying(@PathVariable String message) {
		return new ReplyMessage(message);
	}
	@GetMapping(value = "/v2/reply/{payload}")
	public JSONObject replyString(@PathVariable String payload){
		return readPayloadAndProcess.readPayloadAndProcess(payload);
	}
}