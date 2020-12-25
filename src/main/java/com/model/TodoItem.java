package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor

public class TodoItem extends BaseModel implements Serializable {
   @Column(nullable = true)
    private String title;
    @Column(nullable = true)
    private String description;
    @Column(nullable = true)
    private Date date;
    @Column(nullable = true)
    private String status;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne()
   // @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
