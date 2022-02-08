package ua.lviv.iot.domain.bus;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "manufacturer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private Collection<Bus> buses;

    public Manufacturer(Integer id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Manufacturer {"
                + "id =" + id + ", "
                + "name =" + name + ", "
                + "location =" + location.getId()
                + "};" + "\n";
    }
}
