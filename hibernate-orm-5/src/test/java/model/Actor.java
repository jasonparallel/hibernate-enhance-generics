package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

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
    @javax.persistence.OrderBy("superseded, title")
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
