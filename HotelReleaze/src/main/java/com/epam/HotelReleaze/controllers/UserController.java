package com.epam.HotelReleaze.controllers;


import com.epam.HotelReleaze.dao.Factory;
import com.epam.HotelReleaze.models.Room;
import com.epam.HotelReleaze.models.User;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/hotel")
public class UserController extends HttpServlet {

    private enum Request {
        LOGIN, REG, EXIT, INDEX, CHANGE,
        goLogin, goReg, goMyBook, goBook, goUsers, goBookClick,
        changeUserTable, changeRoomTable, changeMyBookTable, bookPerform
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

                session.setAttribute("err", "");
                session.setAttribute("errLog", "");
                session.setAttribute("errPass", "");
                session.setAttribute("errConf", "");

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
                request.setAttribute("err", "");
                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("loginEN.jsp").forward(request, response);
                break;

            case LOGIN:
                request.setAttribute("err", "");

                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("loginEN.jsp").forward(request, response);
                break;

            case REG:
                request.setAttribute("errLog", session.getAttribute("errLog"));
                request.setAttribute("errPass", session.getAttribute("errPass"));
                request.setAttribute("errConf", session.getAttribute("errConf"));
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
                    } else if (request.getParameter("changeRegClick") != null) {
                        request.setAttribute("errLog", "");
                        request.setAttribute("errPass", "");
                        request.setAttribute("errConf", "");
                        request.getRequestDispatcher("registrationEN.jsp").forward(request, response);
                    } else if (request.getParameter("changeMyBookClick") != null) {
                        request.getRequestDispatcher("myBookEN.jsp").forward(request, response);
                    } else if (request.getParameter("changeMainUserClick") != null) {
                        request.setAttribute("errBook", "");
                        request.setAttribute("errCheckIn", "");
                        request.setAttribute("errCheckOut", "");
                        request.setAttribute("successBook", "");
                        request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("mainAdminEN.jsp").forward(request, response);
                    }
                    session.setAttribute("language", "EN");
                } else {
                    if (request.getParameter("changeIndexClick") != null)
                        request.getRequestDispatcher("indexRU.jsp").forward(request, response);
                    else if (request.getParameter("changeLoginClick") != null) {
                        request.setAttribute("err", "");
                        request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                    } else if (request.getParameter("changeRegClick") != null) {
                        request.setAttribute("errLog", "");
                        request.setAttribute("errPass", "");
                        request.setAttribute("errConf", "");
                        request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                    } else if (request.getParameter("changeMyBookClick") != null) {
                        request.getRequestDispatcher("myBookRU.jsp").forward(request, response);
                    } else if (request.getParameter("changeMainUserClick") != null) {
                        request.setAttribute("errBook", "");
                        request.setAttribute("errCheckIn", "");
                        request.setAttribute("errCheckOut", "");
                        request.setAttribute("successBook", "");
                        request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("mainAdminRU.jsp").forward(request, response);
                    }

                    session.setAttribute("language", "RU");
                }

                break;

            case goLogin:
                String username = request.getParameter("loginUsername");
                String password = request.getParameter("loginPassword");
                User user = Factory.getInstance().getUserDAO().getUser(username);
                if (user == null || !(user.getPassword().equals(password))) {
                    if (session.getAttribute("language").equals("RU")) {
                        request.setAttribute("err", "Ошибка! Неверный логин или пароль.");
                        request.getRequestDispatcher("loginRU.jsp").forward(request, response);
                    } else {
                        request.setAttribute("err", "Error! Wrong username or password.");
                        request.getRequestDispatcher("loginEN.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("err", "");
                    session.setAttribute("user", user);
                    if (user.getRole() == true) {
                        List<Room> listRooms = (List<Room>) Factory.getInstance().getRoomDAO().getAllRooms();
                        request.setAttribute("rooms", listRooms);
                        if (session.getAttribute("language").equals("RU"))
                            request.getRequestDispatcher("mainAdminRU.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("mainAdminEN.jsp").forward(request, response);
                    } else {
                        request.setAttribute("errBook", "");
                        request.setAttribute("errCheckIn", "");
                        request.setAttribute("errCheckOut", "");
                        request.setAttribute("successBook", "");

                        if (session.getAttribute("language").equals("RU"))
                            request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);
                    }

                }
                break;
            case goReg:
                String regUsername = request.getParameter("regUsername");
                String regPassword = request.getParameter("regPassword");
                String regConfirm = request.getParameter("regConfirm");

                boolean flag = false;

                if (regUsername.length() > 32 || regUsername.length() < 6) {
                    if (session.getAttribute("language").equals("EN"))
                        request.setAttribute("errLog", "Error!Username must be from 6 to 32 symbols.");
                    else
                        request.setAttribute("errLog", "Ошибка! Логин должен составлять от 6 до 32 символов.");
                    flag = true;
                } else
                    request.setAttribute("errLog", "");
                if (regPassword.length() > 32 || regUsername.length() < 6) {
                    if (session.getAttribute("language").equals("EN"))
                        request.setAttribute("errPass", "Error!Password must be from 6 to 32 symbols.");
                    else
                        request.setAttribute("errPass", "Ошибка! Пароль должен составлять от 6 до 32 символов.");
                    flag = true;
                } else
                    request.setAttribute("errPass", "");
                if (!regConfirm.equals(regPassword)) {
                    if (session.getAttribute("language").equals("EN"))
                        request.setAttribute("errConf", "Error!Passwords don't match.");
                    else
                        request.setAttribute("errConf", "Ошибка! Пароли не совпадают.");
                    flag = true;
                } else
                    request.setAttribute("errConf", "");

                if (!flag) {
                    User regUser = Factory.getInstance().getUserDAO().getUser(regUsername);
                    if (regUser == null) {
                        Factory.getInstance().getUserDAO().addUser(new User(regUsername, regPassword, false));
                        session.setAttribute("user", regUser);
                        request.setAttribute("errBook", "");
                        request.setAttribute("errCheckIn", "");
                        request.setAttribute("errCheckOut", "");
                        request.setAttribute("successBook", "");

                        if (session.getAttribute("language").equals("RU"))
                            request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);
                    } else {

                        if (session.getAttribute("language").equals("EN"))
                            request.setAttribute("errLog", "Error! Someone already use this username.");
                        else
                            request.setAttribute("errLog", "Ошибка! Кто то уже использует этот логин");

                        if (session.getAttribute("language").equals("RU"))
                            request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                        else
                            request.getRequestDispatcher("registrationEN.jsp").forward(request, response);
                    }

                } else {
                    if (session.getAttribute("language").equals("RU"))
                        request.getRequestDispatcher("registrationRU.jsp").forward(request, response);
                    else
                        request.getRequestDispatcher("registrationEN.jsp").forward(request, response);

                }
                break;

            case goBook:
                List<Room> roomList = (List<Room>) Factory.getInstance().getRoomDAO().getAllRooms();
                request.setAttribute("rooms", roomList);
                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("mainAdminRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("mainAdminEN.jsp").forward(request, response);
                break;

            case goBookClick:
                request.setAttribute("errBook", "");
                request.setAttribute("errCheckIn", "");
                request.setAttribute("errCheckOut", "");
                request.setAttribute("successBook", "");

                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);
                break;
            case goMyBook:
                User manUser = (User) session.getAttribute("user");
                List<Room> Roomss = (List<Room>) Factory.getInstance().getRoomDAO().getRoomsOnId(manUser.getUserID());
                if (Roomss != null)
                    request.setAttribute("userRooms", Roomss);
                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("myBookRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("myBookEN.jsp").forward(request, response);
                break;
            case goUsers:
                List<User> users = (List<User>) Factory.getInstance().getUserDAO().getAllUsers();
                request.setAttribute("users", users);
                if (session.getAttribute("language").equals("RU"))
                    request.getRequestDispatcher("usersRU.jsp").forward(request, response);
                else
                    request.getRequestDispatcher("usersEN.jsp").forward(request, response);
                break;

            case changeUserTable:
                List<User> userList = (List<User>) Factory.getInstance().getUserDAO().getAllUsers();
                request.setAttribute("users", userList);
                if (session.getAttribute("language").equals("RU")) {
                    request.getRequestDispatcher("usersEN.jsp").forward(request, response);
                    session.setAttribute("language", "EN");
                } else {
                    request.getRequestDispatcher("usersRU.jsp").forward(request, response);
                    session.setAttribute("language", "RU");
                }
                break;

            case changeRoomTable:
                List<Room> listRooms = (List<Room>) Factory.getInstance().getRoomDAO().getAllRooms();
                request.setAttribute("rooms", listRooms);
                if (session.getAttribute("language").equals("RU")) {
                    request.getRequestDispatcher("mainAdminEN.jsp").forward(request, response);
                    session.setAttribute("language", "EN");
                } else {
                    request.getRequestDispatcher("mainAdminRU.jsp").forward(request, response);
                    session.setAttribute("language", "RU");
                }
                break;
            case changeMyBookTable:
                User mainUser = (User) session.getAttribute("user");
                List<Room> Rooms = (List<Room>) Factory.getInstance().getRoomDAO().getRoomsOnId(mainUser.getUserID());
                if (Rooms != null)
                    request.setAttribute("userRooms", Rooms);
                if (session.getAttribute("language").equals("RU")) {
                    request.getRequestDispatcher("myBookEN.jsp").forward(request, response);
                    session.setAttribute("language", "EN");
                } else {
                    request.getRequestDispatcher("myBookRU.jsp").forward(request, response);
                    session.setAttribute("language", "RU");
                }
                break;

            case bookPerform:
                String checkIn = request.getParameter("bookCheckIn");
                String checkOut = request.getParameter("bookCheckOut");
                String type = request.getParameter("langRU");
                boolean fl = false;
                if (checkIn.equals("")) {
                    fl = true;
                    if (session.getAttribute("language").equals("EN")) {
                        request.setAttribute("errCheckIn", "Error! Field is empty.");
                    } else
                        request.setAttribute("errCheckIn", "Ошибка! Поле должно быть заполнено.");

                }else {
                    request.setAttribute("errCheckIn","");
                }

                if (checkOut.equals("")) {
                    fl = true;
                    if (session.getAttribute("language").equals("EN")) {
                        request.setAttribute("errCheckOut", "Error! Field is empty.");
                    } else
                        request.setAttribute("errCheckOut", "Ошибка! Поле должно быть заполнено.");

                }else{
                    request.setAttribute("errCheckOut","");
                }

                if (!fl) {

                    int i;
                    if (type.equals("one"))
                        i = 1;
                    else if (type.equals("two"))
                        i = 2;
                    else i = 3;

                    List<Room> bookRooms = (List<Room>) Factory.getInstance().getRoomDAO().getFreeRoomsByType(i);
                    if (bookRooms.size()>0) {
                        Room bookedRoom = bookRooms.get(0);
                        bookedRoom.setState(true);
                        User user1 = (User) session.getAttribute("user");
                        bookedRoom.setUserID(user1.getUserID());
                        Factory.getInstance().getRoomDAO().updateRoom(bookedRoom);

                        request.setAttribute("errCheckIn","");
                        request.setAttribute("errCheckOut","");
                        request.setAttribute("errBook","");
                        if (session.getAttribute("language").equals("RU")) {
                            request.setAttribute("successBook","Номер успешно забронирован!");
                        }else
                            request.setAttribute("successBook","Success of booking!");
                    } else {

                        if (session.getAttribute("language").equals("EN")) {
                            request.setAttribute("errBook", "Error! There are not free rooms in this category.");
                        } else
                            request.setAttribute("errBook", "Ошибка! Свободных комнат в этой категории нет.");
                        request.setAttribute("successBook","");
                    }

                }else{
                    request.setAttribute("successBook","");
                    request.setAttribute("errBook","");
                }

                if (session.getAttribute("language").equals("RU")) {
                    request.getRequestDispatcher("mainUserRU.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("mainUserEN.jsp").forward(request, response);

                }


        }

    }

    private Request checkRequest(HttpServletRequest request) {

        if (request.getParameter("changeIndexClick") != null ||
                request.getParameter("changeLoginClick") != null ||
                request.getParameter("changeRegClick") != null ||
                request.getParameter("changeMainUserClick") != null)
            return Request.CHANGE;
        else if (request.getParameter("loginClick") != null)
            return Request.LOGIN;
        else if (request.getParameter("registrationClick") != null)
            return Request.REG;
        else if (request.getParameter("loginBtn") != null)
            return Request.goLogin;
        else if (request.getParameter("regBtn") != null)
            return Request.goReg;
        else if (request.getParameter("exitClick") != null)
            return Request.EXIT;
        else if (request.getParameter("myBookClick") != null)
            return Request.goMyBook;
        else if (request.getParameter("goBookClick") != null)
            return Request.goBookClick;
        else if (request.getParameter("usersClick") != null)
            return Request.goUsers;
        else if (request.getParameter("bookClick") != null)
            return Request.goBook;
        else if (request.getParameter("changeMyUsersClick") != null)
            return Request.changeUserTable;
        else if (request.getParameter("changeMainAdminClick") != null)
            return Request.changeRoomTable;
        else if (request.getParameter("changeMyBookClick") != null)
            return Request.changeMyBookTable;
        else if (request.getParameter("bookBtn") != null)
            return Request.bookPerform;
        else return Request.INDEX;
    }


}