package model;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Transient;

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
