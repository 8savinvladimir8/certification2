package ru.inno.certification2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.inno.certification2.repositories.UsersRepository;
import ru.inno.certification2.models.User;

import java.util.List;

/**
 * Контроллер {@code UsersController} предоставляет страницу с данными о зарегистрированных пользователях.
 * @author Savin Vladimir
 */
@Controller
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Метод возвращает страницу с данными о зарегистрированных пользователях.
     * @param model содержит данные о пользователях.
     * @return страница с данными о зарегистрированных пользователях.
     */
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }
}
