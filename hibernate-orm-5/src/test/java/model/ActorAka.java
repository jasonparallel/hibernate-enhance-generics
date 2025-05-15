package model;

import javax.persistence.AssociationOverride;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@AssociationOverride(name = "akaObject", joinColumns = @JoinColumn(name = "actorId"))
@Entity
public class ActorAka extends AbstractAka<Actor, ActorAka> {
    @Transient
    public Actor getActor() {
        return this.getAkaObject();
    }

    @Transient
    public void setActor(Actor entity) {
        this.setAkaObject(entity);
    }
}
