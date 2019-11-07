package com.sda.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "City")
@Table(name = "city")

public class City {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "city_name")
    private String cityName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "region_id")
    private Region region;

    @OneToMany (cascade = CascadeType.ALL,mappedBy = "city", orphanRemoval = true)
    private Set<Place> places = new HashSet<Place>();

    public City(String countryName) {
        this.cityName = countryName;
    }

    public City() {
    }

    public City(String newCityName, Region region) {
    }

    public long getId() {
        return id;
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", countryName='" + cityName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City country = (City) o;

        if (id != country.id) return false;
        return cityName != null ? cityName.equals(country.cityName) : country.cityName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }
}
