package models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "city")
public class City {
    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }
    @Id
    @Column(name = "city_id")
    private int cityId;
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER,mappedBy = "city")
    private List<Employee> emp;
}
