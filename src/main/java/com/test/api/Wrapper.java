/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 6/8/18
 */
package com.test.api;

import com.test.api.entities.User;

import javax.persistence.Entity;
import javax.validation.Valid;
@Entity
public class Wrapper {

    @Valid
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
