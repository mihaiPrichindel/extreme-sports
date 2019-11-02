package com.sda.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Region")
@Table(name = "region")
public class Region {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_id")
    private String countryId;

    public Region() {
    }

    public Region(String countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        Region region = (Region) o;
        return id == region.id &&
                Objects.equals(countryId, region.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, countryId);
    }
}
