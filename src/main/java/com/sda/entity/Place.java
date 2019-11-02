package com.sda.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Place")
@Table(name = "place")

public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "place_name")
    private String placeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "place", orphanRemoval = true)
    private Set<Sport> sports = new HashSet<>();

    public Place(){

    }

    public Place(Long id, String placeName) {
        this.id = id;
        this.placeName = placeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(id, place.id) &&
                Objects.equals(placeName, place.placeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, placeName);
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                '}';
    }
}
