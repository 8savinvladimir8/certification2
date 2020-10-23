package ru.inno.certification2.security.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.inno.certification2.repositories.UsersRepository;
import ru.inno.certification2.models.User;

/**
 * Класс {@code UserDetailsServiceImpl} предоставляет информацию об искомом пользователе.
 * @author Savin Vladimir
 */
@Component(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    /**
     * Метод возвращает объект, содержащий данные пользователя, если тот был найден в БД.
     * @param email эл.почта (логин) искомого пользователя.
     * @return объект, содержащий данные пользователя, если тот был найден в БД.
     * @throws UsernameNotFoundException ошибка, если пользователь не найден.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email);
        if (user != null) {
            return new UserDetailsImpl(user);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
