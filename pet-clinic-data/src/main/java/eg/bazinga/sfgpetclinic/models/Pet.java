package eg.bazinga.sfgpetclinic.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PETS")
@Getter
@Setter
@NoArgsConstructor
public class Pet extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "birth_day")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits;

    @Builder
    public Pet(Long id, String name, LocalDate birthday, PetType petType, Owner owner, Set<Visit> visits) {
        super(id);
        this.name = name;
        this.birthday = birthday;
        this.petType = petType;
        this.owner = owner;
        this.visits = visits;
    }

    public Set<Visit> getVisits() {
        if (visits == null) {
            visits = new HashSet<>();
        }
        return visits;
    }

}
