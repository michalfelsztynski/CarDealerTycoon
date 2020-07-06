package model.actor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseActor {
    private final String playerName;

    public BaseActor(String playerName) {
        this.playerName = playerName;
    }
}
