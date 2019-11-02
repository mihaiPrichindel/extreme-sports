package com.sda.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Country")
@Table(name = "country")
public class Country {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "countryName")
    private String countryName;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Region> regions = new HashSet<Region>();

    public Country(){}

    public Country(String countryName){
        this.countryName = countryName;
    }

    public String getCountryName(){
        return countryName;
    }

    public void setCountryName(){
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id == country.id &&
                Objects.equals(countryName, country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryName);
    }
}
