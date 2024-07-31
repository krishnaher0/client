package com.example.meatshop.Pojo;
import com.example.meatshop.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPojo {
    private Integer customerId;
    private String customerName;
    private String address;
    private String email;
    private String contactNo;
    private String password;
    private String username;
    private List<Role> roles = new ArrayList<>();
}
