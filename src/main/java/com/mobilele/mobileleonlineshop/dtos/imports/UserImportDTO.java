package com.mobilele.mobileleonlineshop.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserImportDTO {
    String username;
    String password;
    String firstName;
    String lastName;
    Boolean isActive;
    String imageUrl;
}
