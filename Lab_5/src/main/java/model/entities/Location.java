package model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Table(name = "location")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Manufacturer> manufacturers;

    @OneToMany(mappedBy = "location", fetch = FetchType.LAZY)
    private Collection<Company> companies;

    public Location(Integer id, String country, String city, String street) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    @Override
    public String toString() {
        return ":Location {"
                + "id =" + id + ", "
                + "city =" + city + ", "
                + "street = " + street
                + "};" + "\n";
    }
}