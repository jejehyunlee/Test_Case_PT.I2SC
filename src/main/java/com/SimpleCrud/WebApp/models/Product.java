package com.SimpleCrud.WebApp.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Tbl_kendaraan")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column (length = 10, unique = true)
    private String noreg;
    @Column (length = 10)
    private String nama;
    @Column(length = 100)
    private String alamat;
    @Column(length = 20)
    private String merk;
    @Column (length = 4)
    private Integer tahun;
    @Column(length = 10)
    private Warna warna;
    @Column(length = 10)
    private String Bbakar;



    public enum Warna {
        A,
        B
    }


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

    public Warna getWarna() {
        return this.warna;
    }

    public void setWarna(Warna warna) {
        this.warna = warna;
    }

    public String getBbakar() {
        return this.Bbakar;
    }

    public void setBbakar(String Bbakar) {
        this.Bbakar = Bbakar;
    }
   

}
