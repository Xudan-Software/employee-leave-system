package com.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="user_profile")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private Long age;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "user_manager",
        joinColumns = { @JoinColumn(name = "manager_id") },
        inverseJoinColumns = { @JoinColumn(name = "user_id") })
    private User manager;

    @OneToMany(fetch = FetchType.EAGER,
        mappedBy = "manager")
    private Set<User> managees;

    @Column(name = "address")
    private String address;

    @Column(name = "tag")
    private String tag;
    @Column(name = "password")
    private String password;


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public User getManager() {
        return manager;
    }

    public void setManager(User manager) {
        this.manager = manager;
        manager.addManagee(this);
    }

    public Set<User> getManagees() {
        return managees;
    }

    public void setManagees(Set<User> managees) {
        this.managees = managees;
    }

    public void addManagee(User managee) {
        this.managees.add(managee);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User id(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User.RoleEnum getRole() {
        return role;
    }

    public void setRole(User.RoleEnum role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

        public static User.RoleEnum fromValue(String text) {
            for (User.RoleEnum b : RoleEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }
}
