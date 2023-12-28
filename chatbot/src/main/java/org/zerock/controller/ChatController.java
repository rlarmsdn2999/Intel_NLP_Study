package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.chatbot.ChatBot;

@Controller
public class ChatController {
	// 질문과 답을 저장한 파일의 경로
    String questionFilePath = "C:/Users/rmsdn/Desktop/project/que.txt";
    String answerFilePath = "C:/Users/rmsdn/Desktop/project/ans.txt";

    // 질문과 답을 파일에서 읽어옴
    ChatBot chatBot = new ChatBot(questionFilePath, answerFilePath);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chat(String userInput, Model model) {
        if ("종료".equals(userInput)) {
            model.addAttribute("chatbot", "챗봇을 종료합니다. 감사합니다!");
            return "index";
        }
        
        String answer = chatBot.getAnswer(userInput);

        if (answer == null || answer.isEmpty()) {
            answer = "죄송합니다ㅠ 질문에 대한 답을 찾지 못했습니다ㅠ";
        }

        // 입력된 질문에 대한 답을 찾아 모델에 추가
        model.addAttribute("user", userInput);
        model.addAttribute("chatbot", answer);

        return "index";
    }
}
