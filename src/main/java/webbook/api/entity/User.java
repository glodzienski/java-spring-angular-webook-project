package webbook.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class User extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Column(nullable = false)
    private String cpf;

    @NotNull
    @Column(name = "birthday_date", nullable = false)
    private String birthdayDate;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "photo_url")
    private String photoUrl;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tb_address")
    private List<Address> address;
}
