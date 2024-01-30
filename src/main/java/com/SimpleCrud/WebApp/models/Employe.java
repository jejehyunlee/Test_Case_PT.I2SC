package com.SimpleCrud.WebApp.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "Mst_Employee")
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column (length = 20, unique = true)
    private String nik;

    @NotEmpty
    @Column (length = 50)
    private String nama;

    @Column(length = 20)
    private String jenisKelamin;

    @Column(length = 20)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tanggal;

    @Column(length = 100)
    private String alamat;

    @Column(length = 20)
    private String negara;

    @Column(length = 20)
    private Integer age;

}
