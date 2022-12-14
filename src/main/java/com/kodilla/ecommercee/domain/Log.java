package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "LOGS")
public class Log {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Column(name = "USER_ID", length = 20)
    private String userId;

    @NotNull
    @Column(name = "DATED")
    private Date date;

    @NotNull
    @Column(name = "LOGGER", length = 50)
    private String logger;

    @NotNull
    @Column(name = "LEVEL", length = 10)
    private String level;

    @NotNull
    @Column(name = "MESSAGE", length = 1000)
    private String message;
}
