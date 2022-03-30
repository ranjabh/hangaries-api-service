package com.hungries.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = {"id"})
@Entity
//@Table(name = "CUSTOMER_MASTER")
@Table(name = "CUSTOMER_MASTER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "customer_login_id"),
        @UniqueConstraint(columnNames = "email_id")})
public class Customer {

    private @Id
    @GeneratedValue
    long id;

    @Column(name = "customer_login_id", nullable = false, unique = true)
    private String loginId;

    @Column(name = "customer_login_password", nullable = false)
//    @ColumnTransformer(read = "pgp_sym_decrypt(customer_login_password, ‘mySecretKey’)", write = "pgp_sym_encrypt(?, ‘mySecretKey’)")
    private @NotBlank(message = "Password is required.") String password;

    @Column(name = "customer_first_name", nullable = false)
    private @NotBlank String firstName;

    @Column(name = "customer_middle_name")
    private String middleName;

    @Column(name = "customer_last_name")
    private String lastName;

    @Column(name = "mobile_number", nullable = false)
    @Min(value = 10, message = "Mobile Number should not be less than 10")
    private @NotBlank(message = "Mobile Number is required.") String mobileNumber;

    @Column(name = "email_id")
    private @NotBlank @Email String emailId;

    @Column(name = "restaurant_id")
    private @NotBlank String restaurantId;

    @Column(name = "store_Id")
    private @NotBlank String storeId;

    @Column(name = "customer_active_status")
    private @NotBlank String customerActiveStatus;

    @Column(name = "alternative_contact_id")
    private String alternativeContactId;

    @Temporal(TemporalType.DATE)
    @Column(name = "effective_start_date")
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "effective_end_date")
    private Date endDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    private Date updatedDate = new Date();

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;


}
