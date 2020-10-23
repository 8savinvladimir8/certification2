package ru.inno.certification2.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Сущность {@code User} представляет данные таблицы {@code account} с информацией о пользователях.
 * @author Savin Vladimir
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String hashPassword;

    @Transient
    @Column
    private String password;
}
