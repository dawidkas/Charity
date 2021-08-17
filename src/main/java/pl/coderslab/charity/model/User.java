package pl.coderslab.charity.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name = "Users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "Podaj adres email.")
    @Email(message = "Niepoprawny format adresu email.")
    @Column(nullable = false, unique = true)
    private String email;
    @NotEmpty(message = "Podaj hasło.")
    @Size(min = 6, message = "Hasło musi składać się z co najmniej 6 znaków.")
    private String password;
}