package com.customer.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateCustomerRequest {

    @NotBlank(message = "first name is required")
    @Size(min = 3 , max = 100 , message = "first name has to be between 1 - 100")
    private String firstName;

    @NotBlank(message = "last name is required")
    @Size(min = 3 , max = 100 , message = "last name has to be between 1 - 100")
    private String lastName;

    @Pattern(regexp = "/^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$/gm" , message = "Phone number is incorrect")
    private String phoneNo;

    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$" , message = "Provided email is incorrect")
    private String email;


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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
