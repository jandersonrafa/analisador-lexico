package dto;

import lombok.Builder;
import lombok.Data;
import services.StateType;
import services.TokenType;

import java.util.Map;
import java.util.Optional;

@Data
@Builder
public class State {

    private Map<String, StateType> transitions;

    private boolean initial;

    private boolean finish;

    private TokenType tokenType;

    public Optional<Map.Entry<String, StateType>> getTransitionByCharacter(String word) {
        return transitions.entrySet().stream().filter(t -> t.getKey().equals(word)).findFirst();
    }
}
