package com.SimpleCrud.WebApp.models;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Tbl_kendaraan")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (length = 10, unique = true)
    private String noreg;
    @NotNull(message = "Title cannot be empty")
    @Size(min = 3, max = 50, message = "Title name can be minimum 3 and maximum 50 characters long")
    @Column (length = 10)
    private String nama;
    @Column(length = 100)
    private String alamat;
    @Column(length = 20)
    private String merk;
    @Column (length = 4)
    private Integer tahun;
    @Column(length = 10)
    private String warna;
    @Column(length = 10)
    private String Bbakar;

    public Product() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNoreg() {
        return this.noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public Integer getTahun() {
        return this.tahun;
    }

    public void setTahun(Integer tahun) {
        this.tahun = tahun;
    }

    public String getWarna() {
        return this.warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getBbakar() {
        return this.Bbakar;
    }

    public void setBbakar(String Bbakar) {
        this.Bbakar = Bbakar;
    }

  
}
