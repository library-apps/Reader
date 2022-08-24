package com.books.reader.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

public class CheckToken {
    
    public static boolean checkAuthorization(HttpServletRequest request, String role){
        String authorizationHeader = request.getHeader("Authorization");
        String token = authorizationHeader.substring("Bearer ".length());
        String[] chunks = token.split("\\.");
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));	
        String word = role;
        System.out.println(payload.contains(word) + " == " + payload);

        return payload.contains(word);
    }
}