package webbook.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_book_category")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;
}
