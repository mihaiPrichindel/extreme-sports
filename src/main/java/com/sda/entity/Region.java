package com.sda.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Region")
@Table(name = "region")

public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "region_name")
    private String regionName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "country_id")
    private Country country;

    @OneToMany (cascade = CascadeType.ALL,mappedBy = "region", orphanRemoval = true)
    private Set<City> cities = new HashSet<City>();


    public Region() {
    }

    public Region(String newRegionName, Country country) {
    }

    public Long getId() {
        return id;
    }



    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (id != null ? !id.equals(region.id) : region.id != null) return false;
        if (regionName != null ? !regionName.equals(region.regionName) : region.regionName != null) return false;
        if (country != null ? !country.equals(region.country) : region.country != null) return false;
        return cities != null ? cities.equals(region.cities) : region.cities == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (cities != null ? cities.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", country=" + country +
                ", cities=" + cities +
                '}';
    }
}
