package ru.inno.certification2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Контроллер {@code SignInController} предоставляет страницу авторизаии зарегистрированного пользователя.
 * @author Savin Vladimir
 */
@Controller
public class SignInController {

    /**
     * Метод возвращает страницу авторизаии зарегистрированного пользователя.
     * @return страница авторизаии зарегистрированного пользователя.
     */
    @GetMapping("/signIn")
    public String getSignInPage() {
        return "signIn_page";
    }
}
