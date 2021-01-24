package com.mobilele.mobileleonlineshop.dtos;


import com.mobilele.mobileleonlineshop.entities.enums.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleImportDTO {
    Long userId;
    Role role;
}
