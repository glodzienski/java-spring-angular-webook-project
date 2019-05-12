package webbook.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "tb_subscription_monthly")
public class SubscriptionMonthly extends Model {
    @NotNull
    @Id
    @Column(nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(columnDefinition = "int default 0")
    private Float value;

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date")
    private Date paymentDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "payday", nullable = false)
    private Date payday;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subscription_id", nullable = false)
    private Subscription subscription;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    public Date getPayday() {
        return payday;
    }

    public void setPayday(Date payday) {
        this.payday = payday;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
