package com.example.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user_profile")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Long age;
    private String phone;
    private RoleEnum role;
    private String password;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_manager",
        joinColumns = { @JoinColumn(name = "manager_id") },
        inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private User manager;
    @OneToMany(fetch = FetchType.EAGER,
        mappedBy = "manager")
    private Set<User> managees;
    private String address;
    private String tag;


    public void setId(Long id) {
        this.id = id;
    }


    @Id public Long getId() {
        return id;
    }
    public enum RoleEnum {
        MGR("MGR"),

        REPORTEE("REPORTEE"),

        ADMIN("ADMIN");

        private String value;

        RoleEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
        public static RoleEnum fromValue(String text) {
            for (RoleEnum b : RoleEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }
}
