package com.mobilele.mobileleonlineshop.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;

import javax.persistence.*;
import java.time.Instant;

@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public abstract class BaseEntity   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    public BaseEntity(){
        this.created = Instant.now();
        this.lastModified = null;
    }

    @Column(nullable = false)
    Instant created;

    @Column(name = "last_modified")
    Instant lastModified;


}
