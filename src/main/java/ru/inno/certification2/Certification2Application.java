package ru.inno.certification2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class Certification2Application {

    /**
     * Возвращает шифровальщик пароля.
     * @return шифровальщик пароля.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Точка входа приложения.
     * @param args аргументы запуска приложения.
     */
    public static void main(String[] args) {
        SpringApplication.run(Certification2Application.class, args);
    }
}
