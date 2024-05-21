package com.ensar.norder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensar.norder.entity.Organization;
import com.ensar.norder.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);

    boolean existsByEmail(String email);

    List<User> findByOrganization(Organization organization);

    List<User> findByOrganizationId(String organizationId);
    List<User> findByTeam(String team);

}
