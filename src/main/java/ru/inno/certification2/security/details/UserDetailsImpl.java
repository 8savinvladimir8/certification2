package ru.inno.certification2.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.inno.certification2.models.User;

import java.util.Collection;
import java.util.Collections;

/**
 * Класс {@code UserDetailsImpl} является реализацией {@code UserDetails} и отвечает на запросы Spring Security.
 * @author Savin Vladimir
 */
public class UserDetailsImpl implements UserDetails {
    private final User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    /**
     * Возвращает полномочия, предоставленные пользователю.
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("USER"));
    }

    /**
     * Возвращает пароль, используемый для аутентификации пользователя.
     * @return
     */
    @Override
    public String getPassword() {
        return user.getHashPassword();
    }

    /**
     * Возвращает имя пользователя, используемое для аутентификации пользователя.
     * @return
     */
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    /**
     * Указывает, истек ли срок действия учетной записи пользователя.
     * Учетная запись с истекшим сроком действия не может быть аутентифицирована.
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Указывает, заблокирован пользователь или разблокирован.
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Указывает, истек ли срок действия учетных данных (пароля) пользователя.
     * Просроченные учетные данные препятствуют аутентификации.
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Метод указывает, включен или отключен пользователь. Отключенный пользователь не может быть аутентифицирован.
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
