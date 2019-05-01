package webbook.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_book")
public class Book extends Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "0")
    private Integer views;

    @Column(columnDefinition = "0")
    private Integer downloads;

    @Column(columnDefinition = "false")
    private Boolean active;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @NotNull
    @JoinColumn(name = "book_info_id", referencedColumnName = "id", nullable = false)
    private BookInfo bookInfo;

    @NotNull
    @JoinColumn(name = "book_category_id", referencedColumnName = "id", nullable = false)
    private BookCategory bookCategory;
}
