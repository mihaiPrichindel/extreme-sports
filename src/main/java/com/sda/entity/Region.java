package com.sda.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Region")
@Table(name = "region")

public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "region_name")
    private String regionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "country_id")
    private Country country;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "region", orphanRemoval = true)
    private Set<City> regions = new HashSet<>();

    public Region(Long id, String regionName, Country country) {
        this.id = id;
        this.regionName = regionName;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(id, region.id) &&
                Objects.equals(regionName, region.regionName) &&
                Objects.equals(country, region.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regionName, country);
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                ", country=" + country +
                '}';
    }
}
