package models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString(exclude = "city")
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    public Employee(String name, String secondName, String sex, int cityId) {
        this.name = name;
        this.secondName = secondName;
        this.sex = sex;
        this.cityId = cityId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "second_name")
    private String secondName;
    private String sex;
    @Column(name = "city_id")
    private int cityId;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "city_id", nullable = false, insertable = false, updatable = false)
    private City city;

}
