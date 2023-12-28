package org.zerock.chatbot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ChatBot {
	private Map<String, String> qaPairs;

    public ChatBot(String questionFilePath, String answerFilePath) {
        this.qaPairs = loadQAPairs(questionFilePath, answerFilePath);
    }

    private Map<String, String> loadQAPairs(String questionFilePath, String answerFilePath) {
        Map<String, String> qaPairs = new HashMap<>();

        try (BufferedReader questionReader = new BufferedReader(new FileReader(questionFilePath));
             BufferedReader answerReader = new BufferedReader(new FileReader(answerFilePath))) {

            String question;
            String answer;

            while ((question = questionReader.readLine()) != null && (answer = answerReader.readLine()) != null) {
                qaPairs.put(question, answer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return qaPairs;
    }

    public String getAnswer(String userInput) {
        String closestQuestion = qaPairs.keySet()
                .stream()
                .min((q1, q2) -> distance(userInput, q1) - distance(userInput, q2))
                .orElse(null);

        return closestQuestion != null ? qaPairs.get(closestQuestion) : "죄송합니다. 답을 찾을 수 없습니다.";
    }

    private int distance(String X, String Y) {
    	int m = X.length();
        int n = Y.length();
 
        int[][] T = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            T[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            T[0][j] = j;
        }
 
        int cost;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cost = X.charAt(i - 1) == Y.charAt(j - 1) ? 0: 1;
                T[i][j] = Integer.min(Integer.min(T[i - 1][j] + 1, T[i][j - 1] + 1),
                        T[i - 1][j - 1] + cost);
            }
        }
 
        return T[m][n];
    }
}
