package webbook.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(name = "hiring_date", nullable = false)
    private String hiringDate;

    @Column(name = "cancellation_date")
    private String cancellationDate;

    @NotNull
    @Column(name = "email_contact", nullable = false)
    private String emailContact;
}
