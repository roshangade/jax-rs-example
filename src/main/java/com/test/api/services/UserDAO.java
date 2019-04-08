/*!
 * Java REST API
 * Author: Roshan Gade
 * Date: 21/7/18
 */
package com.test.api.services;

import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class UserDAO {

    public Optional getUser(Session s, String id) {
        Query query = s.createQuery("FROM User AS u WHERE uid=:uid");
        query.setParameter("uid", id);
        return query.uniqueResultOptional();
    }
}
