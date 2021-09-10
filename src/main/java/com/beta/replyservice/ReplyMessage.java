package com.beta.replyservice;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class ReplyMessage {

	private final String message;

	public ReplyMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}



}