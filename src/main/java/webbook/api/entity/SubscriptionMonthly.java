package webbook.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_subscription_monthly")
public class SubscriptionMonthly {
    @NotNull
    @Id
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(columnDefinition = "int default 0")
    private Float value;

    @NotNull
    @Column(name = "payment_date", nullable = false)
    private String paymentDate;
}
