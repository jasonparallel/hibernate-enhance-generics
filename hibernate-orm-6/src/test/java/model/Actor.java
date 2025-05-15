package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Actor {


    @Id
    @SequenceGenerator(allocationSize = 1, name = "actorGen", sequenceName = "actorCounter")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "actorGen")
    @Column(name = "id")
    private Long id;

    @Version
    @Column(name = "version")
    private Integer version;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "akaObject", orphanRemoval = true)
    @jakarta.persistence.OrderBy("superseded, title")
    private List<ActorAka> actorAkas = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return this.version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }


    public List<ActorAka> getActorAkas() {
        return actorAkas;
    }

    public void setActorAkas(List<ActorAka> actorAkas) {
        this.actorAkas = actorAkas;
    }

}
