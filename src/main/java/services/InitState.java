package services;

import services.dto.State;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class InitState {
    public static final String[] ALFABETO_MINUSCULO = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final String[] ALFABETO_MAIUSCULO = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final String[] RESERVADAS_JAVA = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "double", "do", "else", "enum", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};
    private static final String[] NUMEROS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static Map<StateType, State> init() {


        Map<StateType, State> states = new HashMap<>();

        State state1 = createState(true, false);
        addTransition(state1, StateType.STATE_2, RESERVADAS_JAVA);
        addTransition(state1, StateType.STATE_3, "/");
        addTransition(state1, StateType.STATE_8, "_");
        addTransition(state1, StateType.STATE_9, NUMEROS);

        State state2 = createState(false, true);

        State state3 = createState(false, false);
        addTransition(state3, StateType.STATE_4, "*");

        State state4 = createState(false, false);
        addTransition(state4, StateType.STATE_4, Stream.of(ALFABETO_MINUSCULO, ALFABETO_MAIUSCULO, NUMEROS, new String[]{"_", " "}).flatMap(Stream::of).toArray(String[]::new));
        addTransition(state4, StateType.STATE_5, "*");

        State state5 = createState(false, false);
        addTransition(state5, StateType.STATE_6, "/");

        State state6 = createState(false, true);

        State state8 = createState(false, true);
        addTransition(state8, StateType.STATE_8, Stream.of(ALFABETO_MINUSCULO, ALFABETO_MAIUSCULO, NUMEROS, new String[]{"_"}).flatMap(Stream::of).toArray(String[]::new));

        State state9 = createState(false, true);
        addTransition(state9, StateType.STATE_9, NUMEROS);
        addTransition(state9, StateType.STATE_10, ".");

        State state10 = createState(false, false);
        addTransition(state10, StateType.STATE_11, NUMEROS);

        State state11 = createState(false, true);
        addTransition(state11, StateType.STATE_11, NUMEROS);
//        addTransition(state2, StateType.STATE_3, RESERVADAS_JAVA);

//        State state3 = createState(false, true);
//        addTransition(state3, StateType.STATE_3, RESERVADAS_JAVA);

        states.put(StateType.STATE_1, state1);
        states.put(StateType.STATE_2, state2);
        states.put(StateType.STATE_3, state3);
        states.put(StateType.STATE_4, state4);
        states.put(StateType.STATE_5, state5);
        states.put(StateType.STATE_6, state6);
        states.put(StateType.STATE_8, state8);
        states.put(StateType.STATE_9, state9);
        states.put(StateType.STATE_10, state10);
        states.put(StateType.STATE_11, state11);
//        states.put(StateType.STATE_3, state3);

        return states;


    }

    private static void addTransition(State state, StateType destination, String... characters) {
        Arrays.asList(characters).stream().forEach(c -> state.getTransitions().put(c, destination));
    }

    private static State createState() {
        return createState(false, false);
    }

    private static State createState(boolean initial, boolean finish) {
        return State
                .builder()
                .initial(initial)
                .finish(finish)
                .transitions(new HashMap<>())
                .build();
    }
}
