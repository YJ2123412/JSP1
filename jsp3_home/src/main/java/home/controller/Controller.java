package home.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	//개발자 정의 - 인자를 doGet , doPost 와 동일한 형식으로 정의  / handle - >임의의 메소드명
	void handle(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException ;
}
