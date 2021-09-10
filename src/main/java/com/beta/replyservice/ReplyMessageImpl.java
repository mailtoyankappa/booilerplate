package com.beta.replyservice;

import org.json.JSONObject;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

@Service
@Lazy
public class ReplyMessageImpl implements REplyMessageInterface{

    public JSONObject readPayloadAndProcess(String payload){
        JSONObject json = new JSONObject();

        if(payload.contains("-")){
            String[] stringArray = payload.split("-");
            String caseType = stringArray[0];
            String originalString = stringArray[1];
            String reverseString = reverseString(originalString);
            if(caseType.equalsIgnoreCase("11")){
                json.put("data", reverseString);
            }else if(caseType.equalsIgnoreCase("12")){
                json.put("data",convertString(reverseString));
            }else if(caseType.equalsIgnoreCase("22")){
                String repeatReverseString = reverseString+reverseString;
                json.put("data",convertString(repeatReverseString));
            }
        }
        return json;
    }

    public String reverseString(String originalString){
        String reverseString;
        StringBuilder str = new StringBuilder();
        str.append(originalString);
        reverseString = String.valueOf(str.reverse());
        return reverseString;
    }
    public String convertString(String str){
        String original = new String();
        try{
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            md.reset();
            md.update(str.getBytes(StandardCharsets.UTF_8));
            final byte[] resultByte = md.digest();
            original = new String(Hex.encode(resultByte));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return original;
    }

}
