package org.zerock.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

@Service
public class SentimentAnalyzer {
	public String analyze(String text) {
        String sentiment = "";
        try {
            Process p = Runtime.getRuntime().exec("python sentiment.py " + text);
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            sentiment = in.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sentiment;
    }
}
