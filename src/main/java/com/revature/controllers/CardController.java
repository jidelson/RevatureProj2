package com.revature.controllers;

import java.io.BufferedReader;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.DTO.CardDTO;
import com.revature.models.Cards;

import com.revature.models.Status;
import com.revature.models.Subject;
import com.revature.models.Users;
import com.revature.services.CardService;
import com.revature.services.StatusService;
import com.revature.services.SubjectService;
import com.revature.services.UserService;



public class CardController {

	private static ObjectMapper om = new ObjectMapper();
	private static CardService cs = new CardService();
	private static StatusService statService = new StatusService();
	private static SubjectService subService = new SubjectService();
	private static UserService us = new UserService();
	
	public void getAllCards(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    try {
	        List<Cards> cardList = cs.getAllCards();
	        String data = om.writeValueAsString(cardList);
	        response.getWriter().print(data);
	        response.setStatus(200);
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.setStatus(500);
	        response.getWriter().print("Error: " + e.getMessage());
	    }
	}

	
    public void deleteCardById(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        cs.deleteCardsById(id);
        response.setStatus(204);
    }
	
    public void createCard(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if (req.getMethod().equals("POST")) {
            BufferedReader reader = req.getReader();
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }

            String body = new String(sb);
            CardDTO cDTO = om.readValue(body, CardDTO.class);

            Subject subject = subService.getSubjectByName(cDTO.getSubject());

            Status status = statService.getStatusById(cDTO.getStatus());

            Users correctUser = us.getUserByUsername(cDTO.getUsername());

            if (subject != null && status != null && correctUser != null) {
                Cards card = new Cards(
                    cDTO.getName(),
                    cDTO.getQuestion(),
                    cDTO.getAnswer(),
                    correctUser,
                    status,
                    subject
                );

                cs.addCard(card);

                String json = om.writeValueAsString(card);
                res.getWriter().print(json);
                res.setStatus(201);
            } else {
                res.setStatus(400); // Bad Request
                res.getWriter().print("Invalid card data");
            }
        } else {
            res.setStatus(405); // Method Not Allowed
            res.getWriter().print("Invalid method");
        }
    }

	

	
	public void getAllGreenCards(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> greenList = cs.getAllGreenCards();
		
		String data = null;

		data = om.writeValueAsString(greenList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllYellowCards(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> yellowList = cs.getAllYellowCards();
		
		String data = null;

		data = om.writeValueAsString(yellowList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllRedCards(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> redList = cs.getAllRedCards();
		
		String data = null;

		data = om.writeValueAsString(redList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getCardsByUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getCardsByUser1();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getCardsByUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getCardsByUser2();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getCardsByUser3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getCardsByUser3();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllGreenCardsByUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> greenList = cs.getAllGreenCardsByUser1();
		
		String data = null;

		data = om.writeValueAsString(greenList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllGreenCardsByUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> greenList = cs.getAllGreenCardsByUser2();
		
		String data = null;

		data = om.writeValueAsString(greenList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllGreenCardsByUser3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> greenList = cs.getAllGreenCardsByUser3();
		
		String data = null;

		data = om.writeValueAsString(greenList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllYellowCardsByUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> yellowList = cs.getAllYellowCardsByUser1();
		
		String data = null;

		data = om.writeValueAsString(yellowList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllYellowCardsByUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> yellowList = cs.getAllYellowCardsByUser2();
		
		String data = null;

		data = om.writeValueAsString(yellowList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllYellowCardsByUser3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> yellowList = cs.getAllYellowCardsByUser3();
		
		String data = null;

		data = om.writeValueAsString(yellowList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllRedCardsByUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> redList = cs.getAllRedCardsByUser1();
		
		String data = null;

		data = om.writeValueAsString(redList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllRedCardsByUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> redList = cs.getAllRedCardsByUser2();
		
		String data = null;

		data = om.writeValueAsString(redList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllRedCardsByUser3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> redList = cs.getAllRedCardsByUser3();
		
		String data = null;

		data = om.writeValueAsString(redList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllByMath(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> mathList = cs.getAllCardsByMath();
		
		String data = null;

		data = om.writeValueAsString(mathList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllByHistory(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllCardsByHistory();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllByPhysics(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllCardsByPhysics();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllByComputerScience(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllCardsByComputerScience();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	

	public void getAllMathCardsFromUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllMathCardsFromUser1();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllMathCardsFromUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllMathCardsFromUser2();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	
	public void getAllHistoryCardsFromUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllHistoryCardsFromUser1();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllHistoryCardsFromUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllHistoryCardsFromUser2();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	
	
	public void getAllCSCardsFromUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllCSCardsFromUser1();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllCSCardsFromUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllCSCardsFromUser2();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllCSCardsFromUser3(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllCSCardsFromUser3();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}

	public void getAllPhysicsCardsFromUser1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllPhysicsCardsFromUser1();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	
	public void getAllPhysicsCardsFromUser2(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<Cards> cardList = cs.getAllPhysicsCardsFromUser2();
		
		String data = null;

		data = om.writeValueAsString(cardList);
		
		response.getWriter().print(data);
		response.setStatus(200);
	}
	}
	