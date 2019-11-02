package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Region")
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @Column(name = "region_name")
    private String regionName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "country_id")
    private Country country;

    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "region", orphanRemoval = true)
    private Set<City> cities = new HashSet<City>();

    public Region() {
    }

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

        if (id != null ? !id.equals(region.id) : region.id != null) return false;
        if (regionName != null ? !regionName.equals(region.regionName) : region.regionName != null) return false;
        return country != null ? country.equals(region.country) : region.country == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
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
