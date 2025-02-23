package com.crud.model.dto;

public class UserDTO {

    private Long id;
    private String username;
    private String role;
    private UserDetailsDTO userDetails;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public UserDetailsDTO getUserDetails() { return userDetails; }
    public void setUserDetails(UserDetailsDTO userDetails) { this.userDetails = userDetails; }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", userDetails=" + userDetails +
                '}';
    }
}
