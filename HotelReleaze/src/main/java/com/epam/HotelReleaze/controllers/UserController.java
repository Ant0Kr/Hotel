package com.epam.HotelReleaze.controllers;


import com.epam.HotelReleaze.dao.Factory;
import com.epam.HotelReleaze.models.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/hotel")
public class UserController extends HttpServlet {

    private enum Request {
        LOGIN, REG, EXIT, INDEX, CHANGE,
        goLogin,goReg
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processing(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processing(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processing(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();

        switch (checkRequest(request)) {
            case INDEX:

                session.setAttribute("err","");
                session.setAttribute("errLog","");
                session.setAttribute("errPass","");
                session.setAttribute("errConf","");
                if (session.getAttribute("language") == null) {
                    session.setAttribute("language", "RU");
                    request.getRequestDispatcher("indexRU.jsp").forward(request, response);
                } else if (session.getAttribute("language").equals("RU")) {
                    request.getRequestDispatcher("indexRU.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("indexEN.jsp").forward(request, response);
                }

                break;

            case EXIT:
                session.setAttribute("user", null);
                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("indexRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("indexEN.jsp").forward(request, response);
                break;

            case LOGIN:
                request.setAttribute("err",session.getAttribute("err"));

                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("loginEN.jsp").forward(request, response);
                break;

            case REG:
                request.setAttribute("errLog",session.getAttribute("errLog"));
                request.setAttribute("errPass",session.getAttribute("errPass"));
                request.setAttribute("errConf",session.getAttribute("errConf"));
                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("registrationEN.jsp").forward(request, response);
                break;

            case CHANGE:

                if (session.getAttribute("language").equals("RU")) {
                    if (request.getParameter("changeIndexClick") != null)
                        request.getRequestDispatcher("indexEN.jsp").forward(request, response);
                    else if (request.getParameter("changeLoginClick") != null) {
                        request.setAttribute("err", "");
                        request.getRequestDispatcher("loginEN.jsp").forward(request, response);
                    }
                    else if (request.getParameter("changeRegClick") != null) {
                        request.setAttribute("errLog","");
                        request.setAttribute("errPass","");
                        request.setAttribute("errConf","");
                        request.getRequestDispatcher("registrationEN.jsp").forward(request, response);
                    }
                    session.setAttribute("language","EN");
                } else {
                    if (request.getParameter("changeIndexClick") != null)
                        request.getRequestDispatcher("indexRU.jsp").forward(request, response);
                    else if (request.getParameter("changeLoginClick") != null) {
                        request.setAttribute("err", "");
                        request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                    }else if (request.getParameter("changeRegClick") != null) {
                        request.setAttribute("errLog","");
                        request.setAttribute("errPass","");
                        request.setAttribute("errConf","");
                        request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                    }
                    session.setAttribute("language","RU");
                }

                break;

            case goLogin:
                String username = request.getParameter("loginUsername");
                String password = request.getParameter("loginPassword");
                User user = Factory.getInstance().getItemDAO().getUser(username);
                if(user == null || !(user.getPassword().equals(password))){
                    if(session.getAttribute("language").equals("RU")) {
                        request.setAttribute("err", "Ошибка! Неверный логин или пароль.");
                        request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                    }else{
                        request.setAttribute("err", "Error! Wrong username or password.");
                        request.getRequestDispatcher("loginEN.jsp").forward(request, response);
                    }
                }
                else{
                    request.setAttribute("err", "");
                    session.setAttribute("user",user);
                    if(session.getAttribute("language").equals("RU"))
                        request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                    else
                        request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);

                }
                break;
            case goReg:
                String regUsername = request.getParameter("regUsername");
                String regPassword = request.getParameter("regPassword");
                String regConfirm = request.getParameter("regConfirm");

                boolean flag = false;

                if(regUsername.length()>32 ||regUsername.length()<6) {
                    if(session.getAttribute("language").equals("EN"))
                        request.setAttribute("errLog", "Error!Username must be from 6 to 32 symbols.");
                    else
                        request.setAttribute("errLog", "Ошибка! Логин должен составлять от 6 до 32 символов.");
                    flag = true;
                }else
                    request.setAttribute("errLog","");
                if(regPassword.length()>32 || regUsername.length()<6) {
                    if(session.getAttribute("language").equals("EN"))
                        request.setAttribute("errPass", "Error!Password must be from 6 to 32 symbols.");
                    else
                        request.setAttribute("errPass", "Ошибка! Пароль должен составлять от 6 до 32 символов.");
                    flag = true;
                }else
                    request.setAttribute("errPass","");
                if(!regConfirm.equals(regPassword)) {
                    if(session.getAttribute("language").equals("EN"))
                        request.setAttribute("errConf", "Error!Passwords don't match.");
                    else
                        request.setAttribute("errConf", "Ошибка! Пароли не совпадают.");
                    flag = true;
                }else
                    request.setAttribute("errConf","");

                if(!flag){
                    User regUser = Factory.getInstance().getItemDAO().getUser(regUsername);
                    if(regUser == null ) {
                        Factory.getInstance().getItemDAO().addUser(new User(regUsername,regPassword,false));
                        session.setAttribute("user",regUser);
                        if(session.getAttribute("language").equals("RU"))
                            request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);
                    }else{

                        if(session.getAttribute("language").equals("EN"))
                            request.setAttribute("errLog", "Error! Someone already use this username.");
                        else
                            request.setAttribute("errLog", "Ошибка! Кто то уже использует этот логин");

                        if(session.getAttribute("language").equals("RU"))
                            request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("registrationEN.jsp").forward(request, response);
                    }

                }else{
                    if(session.getAttribute("language").equals("RU"))
                        request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                    else
                        request.getRequestDispatcher("registrationEN.jsp").forward(request, response);

                }


        }

    }

    private Request checkRequest(HttpServletRequest request) {

        if (request.getParameter("changeIndexClick") != null ||
                request.getParameter("changeLoginClick") != null ||
                request.getParameter("changeRegClick") != null)
            return Request.CHANGE;

        if (request.getParameter("loginClick") != null)
            return Request.LOGIN;

        if (request.getParameter("registrationClick") != null)
            return Request.REG;

        if (request.getParameter("loginBtn") != null)
            return Request.goLogin;

        if (request.getParameter("regBtn") != null)
            return Request.goReg;

        return Request.INDEX;
    }


}