package ru.inno.certification2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.inno.certification2.models.User;
import ru.inno.certification2.repositories.UsersRepository;

/**
 * Контроллер {@code SignUpController} предоставляет страницу регистрации нового пользователя.
 * @author Savin Vladimir
 */
@Controller
public class SignUpController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Метод возвращает страницу регистрации нового пользователя.
     * @return страница регистрации нового пользователя.
     */
    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp_page";
    }

    /**
     * Метод сохраняет данные о новом пользователе (при этом пароль - в зашифрованном виде).
     * @param user пользователь, данные которого нужно сохранить.
     * @return возвращает пустую страницу регистрации нового пользователя.
     */
    @PostMapping("/signUp")
    public String signUpUser(User user) {
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "redirect:/signUp";
    }
}
