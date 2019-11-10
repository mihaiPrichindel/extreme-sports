package com.sda.dto;

public class PlaceDTO {

    /// O SA FACI OBIECTUL PE CARE IL RETURNEZI
    // CU TOATE ATRIBUTELE PE CARE LE IEI DIN OBJECT
    String sportName;
    Double sportPrice;
    String placeName;

    public PlaceDTO() {
    }

    public PlaceDTO(String sportName, Double sportPrice, String placeName) {
        this.sportName = sportName;
        this.sportPrice = sportPrice;
        this.placeName = placeName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public Double getSportPrice() {
        return sportPrice;
    }

    public void setSportPrice(Double sportPrice) {
        this.sportPrice = sportPrice;
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

        PlaceDTO placeDTO = (PlaceDTO) o;

        if (sportName != null ? !sportName.equals(placeDTO.sportName) : placeDTO.sportName != null) return false;
        if (sportPrice != null ? !sportPrice.equals(placeDTO.sportPrice) : placeDTO.sportPrice != null) return false;
        return placeName != null ? placeName.equals(placeDTO.placeName) : placeDTO.placeName == null;
    }

    @Override
    public int hashCode() {
        int result = sportName != null ? sportName.hashCode() : 0;
        result = 31 * result + (sportPrice != null ? sportPrice.hashCode() : 0);
        result = 31 * result + (placeName != null ? placeName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "sportName='" + sportName + '\'' +
                ", sportPrice=" + sportPrice +
                ", placeName='" + placeName + '\'' +
                '}';
    }
}
