package io.swagger.petstore;

public class UserReqPayload {
    int id,userStatus;
    String username,firstName,lastName,email,password,phone;

    public UserReqPayload(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus){
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public int getId() {
        return id;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void printDetails(){
        System.out.println("The user id " + id + "username " + username + "firstname " + firstName +
                "email" + email + "phone" + phone);
    }
}
