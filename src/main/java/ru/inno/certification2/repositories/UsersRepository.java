package ru.inno.certification2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.inno.certification2.models.User;

/**
 * Интерфейс {@code UsersRepository} предоставляет методы для работы с данными сущности {@code User}.
 * @author Savin Vladimir
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
