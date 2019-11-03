package entity;

import com.sda.entity.Sport;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Place")
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place_name")
    private String placeName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "city_id")
    private City city;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "place", orphanRemoval = true)
    private Set<Sport> sports = new HashSet<Sport>();


    public String getPlaceName() {
        return placeName;
    }
    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public Place() {
    }
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        if (id != null ? !id.equals(place.id) : place.id != null) return false;
        if (placeName != null ? !placeName.equals(place.placeName) : place.placeName != null) return false;
        return city != null ? city.equals(place.city) : place.city == null;
    }
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (placeName != null ? placeName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Place{" +
                "id=" + id +
                ", placeName='" + placeName + '\'' +
                '}';
    }
}
