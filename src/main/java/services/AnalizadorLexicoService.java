package services;


import dto.Exit;
import dto.State;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AnalizadorLexicoService {

    private static List<Exit> exits = new ArrayList<>();

    private static List<Integer> lineErrors = new ArrayList<>();

    private static List<String> symbols = new ArrayList<>();

    public static void main(String... args) throws IOException {
        Map<StateType, State> states = new InitState().init();

        Map.Entry<StateType, State> stateFirst = states.entrySet().stream().filter(es -> es.getValue().isInitial()).findFirst().get();

//        if (args == null || args.length == 0) {
//            throw new RuntimeException("Diretório arquivo não informado");
//        }

//        List<String> lines = Files.readAllLines(Paths.get(args[0]));
        List<String> lines = Files.readAllLines(Paths.get("C:\\projetos\\analisador-lexico\\arquivo-test.txt"));

        for (int i = 0; i < lines.size(); i++) {
            handler(states, stateFirst, lines.get(i), i);
        }

        exits.stream().forEach(exit -> {
            boolean isAddTableSymbol = exit.getTokenType().addTableSymbol;

            System.out.println("[" + exit.getLine() + "]" + exit.getTokenType().message + " " +( isAddTableSymbol ? exit.getSymbolId() : ""));
        });

        System.out.println("\nTabela de Símbolos");
        for (int i = 0; i < symbols.size(); i++) {
            System.out.println(i + " - " + symbols.get(i));
        }

        if(!lineErrors.isEmpty()) {
            String lineErrorsText = lineErrors.stream().map(n -> n.toString()).collect(Collectors.joining(","));
            System.out.println("\nO programa possui erros nas linhas: " + lineErrorsText);
        }
    }

    private static void handler(Map<StateType, State> states, Map.Entry<StateType, State> stateFirst, String line, Integer numberLine) {
        String[] split = line.split("");
        State lastState = getLastState(states, stateFirst.getValue(), split, 0, stateFirst);

        if (lastState != null && lastState.isFinish()) {
            boolean isAddTableSymbol = lastState.getTokenType().addTableSymbol;
            exits.add(new Exit(lastState.getTokenType(), ++numberLine, isAddTableSymbol ? getSymbolId(line) : null));
        } else {
            lineErrors.add(++numberLine);
        }
    }

    private static Integer getSymbolId(String line) {
        for (int i = 0; i < symbols.size(); i++) {
            if (symbols.get(i).equals(line)) {
                return i + 1;
            }
        }
        symbols.add(line);

        return symbols.size();
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
                return null;
            }
        }
    }

}
