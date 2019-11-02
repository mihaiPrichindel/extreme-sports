package com.sda.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Sport")
@Table(name = "sport")
public class Sport {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sport_name")
    private String sportName;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    public Sport() {
    }

    public Sport(String sportName, Double cost, Date startDate, Date endDate){
        this.sportName = sportName;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sport sport = (Sport) o;

        if (id != null ? !id.equals(sport.id) : sport.id != null) return false;
        if (sportName != null ? !sportName.equals(sport.sportName) : sport.sportName != null) return false;
        if (cost != null ? !cost.equals(sport.cost) : sport.cost != null) return false;
        if (startDate != null ? !startDate.equals(sport.startDate) : sport.startDate != null) return false;
        return endDate != null ? endDate.equals(sport.endDate) : sport.endDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (sportName != null ? sportName.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", cost=" + cost +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", place=" + place +
                '}';
    }
}
