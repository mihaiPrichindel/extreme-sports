package com.sda.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Entity(name = "Sport")
@Table(name = "sport")

public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
    @JoinColumn (name = "place_id")
    private Place place;

    public Sport(){

    }

    public Sport(String sportName, Double cost, Date startDate, Date endDate) {
        this.sportName = sportName;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sport sport = (Sport) o;
        return Objects.equals(id, sport.id) &&
                Objects.equals(sportName, sport.sportName) &&
                Objects.equals(cost, sport.cost) &&
                Objects.equals(startDate, sport.startDate) &&
                Objects.equals(endDate, sport.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sportName, cost, startDate, endDate);
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", sportName='" + sportName + '\'' +
                ", cost=" + cost +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
