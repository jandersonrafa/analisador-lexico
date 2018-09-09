package services;


import services.dto.State;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnalizadorLexicoService {


    public static void main(String... args) {
        Map<StateType, State> states = new InitState().init();

        Map.Entry<StateType, State> stateFirst = states.entrySet().stream().filter(es -> es.getValue().isInitial()).findFirst().get();

        handler(states, stateFirst, "_a");
        handler(states, stateFirst, "_a");
        handler(states, stateFirst, "int");
        handler(states, stateFirst, "_asd");
        handler(states, stateFirst, "_as123");
        handler(states, stateFirst, "99");
        handler(states, stateFirst, "99.");
        handler(states, stateFirst, "99.999");
        handler(states, stateFirst, "float");
        handler(states, stateFirst, "real a");
        handler(states, stateFirst, "real");
        handler(states, stateFirst, "double _c");
        handler(states, stateFirst, "double");
        handler(states, stateFirst, "as_asd");
        handler(states, stateFirst, "_asd");
        handler(states, stateFirst, "/* Tales Bitelo Viegas */");
        handler(states, stateFirst, "-- Teste");
        handler(states, stateFirst, "Tales Viegas --");
        handler(states, stateFirst, "char");
    }

    private static void handler(Map<StateType, State> states, Map.Entry<StateType, State> stateFirst, String line) {
        String[] split = line.split("");
        State lastState = getLastState(states, stateFirst.getValue(), split, 0, stateFirst);

        if (lastState != null && lastState.isFinish()) {
            System.out.println(line + ":   aceito");
        } else {
            System.out.println(line  +":   rejeitado");
        }
    }

    private static State getLastState(Map<StateType, State> states, State state, String[] characters, Integer position, Map.Entry<StateType, State> stateFirst) {
        boolean lastPosition = (position == characters.length);
        if (lastPosition) {
            return state;
        } else {
            Optional<Map.Entry<String, StateType>> optTransition = state.getTransitionByCharacter(characters[position]);

            if (optTransition.isPresent()) {
                Map.Entry<String, StateType> transition = optTransition.get();
                return getLastState(states, states.get(transition.getValue()), characters, ++position, stateFirst);
            } else {
                String line = Arrays.asList(characters).stream().collect(Collectors.joining());
                Optional<Map.Entry<String, StateType>> transFirst = stateFirst.getValue().getTransitionByCharacter(line);
                if (transFirst.isPresent()){
                    return getLastState(states, states.get(transFirst.get().getValue()), characters, ++position, stateFirst);
                } else {
                    return null;
                }
            }
        }
    }
//    private static State getLastState(Map<StateType, State> states, State state, String[] characters, Integer position) {
//        boolean lastPosition = (position == characters.length);
//        if (lastPosition) {
//            return state;
//        } else {
//            String word = "";
//            Optional<Map.Entry<String, StateType>> optTransition = Optional.empty();
//            for (int i = 0; i < characters.length; i++) {
//                if (position >= characters.length) {
//                    break;
//                }
//                word +=characters[position];
//                ++position;
//                optTransition = state.getTransitionByCharacter(word);
//                if (optTransition.isPresent()) {
//                    break;
//                }
//            }
//
//            if (optTransition.isPresent()) {
//                Map.Entry<String, StateType> transition = optTransition.get();
//                return getLastState(states, states.get(transition.getValue()), characters, position);
//            } else {
//                return null;
//            }
//        }
//    }

}
