/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 21/7/18
 */
package com.test.api.entities;

import com.test.api.framework.utils.Crypto;
import com.test.api.framework.utils.MD5;
import com.test.api.framework.utils.UID;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "user")
@Table(name = "test")
@JsonbPropertyOrder({"id", "firstName", "lastName", "email", "mobile"})
public class User {

    @Id
    @Column(name = "uid")
    @JsonbProperty("id")
    private String id = UID.get(16);

    @Column(name = "first_name")
    @NotNull(message = "is required")
    @Size(max = 128)
    @JsonbProperty("first_name")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "is required")
    @Size(max = 128)
    @JsonbProperty("last_name")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "is required")
    @Size(max = 128)
    private String email;

    @Column(name = "password")
    @NotNull(message = "is required")
    @Size(max = 128)
    private String password;

    @Column(name = "mobile")
    @NotNull(message = "is required")
    @Size(max = 128)
    private String mobile;


    public String getId() {
        return id;
    }

    public String getFirstName() {
        return Crypto.decrypt(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = Crypto.encrypt(firstName);
    }

    public String getLastName() {
        return Crypto.decrypt(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = Crypto.encrypt(lastName);
    }

    public String getEmail() {
        return Crypto.decrypt(email);
    }

    public void setEmail(String email) {
        this.email = Crypto.encrypt(email);
    }

    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MD5.hash(password);
    }

    public String getMobile() {
        return Crypto.decrypt(mobile);
    }

    public void setMobile(String mobile) {
        this.mobile = Crypto.encrypt(mobile);
    }

    public void setId(String id) {
        this.id = id;
    }

}
