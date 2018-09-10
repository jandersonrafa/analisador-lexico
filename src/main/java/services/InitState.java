package services;

import dto.Exit;
import dto.State;

import java.util.*;
import java.util.stream.Stream;

public class InitState {
    public static final String[] ALFABETO_MINUSCULO = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private static final String[] ALFABETO_MAIUSCULO = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private static final String[] NUMEROS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static Map<StateType, State> init() {


        Map<StateType, State> states = new HashMap<>();

        State state1 = createState(true, false);
        addTransition(state1, StateType.STATE_12, "a");
        addTransition(state1, StateType.STATE_25, "b");
        addTransition(state1, StateType.STATE_39, "c");
        addTransition(state1, StateType.STATE_62, "d");
        addTransition(state1, StateType.STATE_74, "e");
        addTransition(state1, StateType.STATE_87, "f");
        addTransition(state1, StateType.STATE_104, "g");
        addTransition(state1, StateType.STATE_108, "i");
        addTransition(state1, StateType.STATE_138, "l");
        addTransition(state1, StateType.STATE_142, "n");
        addTransition(state1, StateType.STATE_153, "p");
        addTransition(state1, StateType.STATE_178, "r");
        addTransition(state1, StateType.STATE_184, "s");
        addTransition(state1, StateType.STATE_220, "t");
        addTransition(state1, StateType.STATE_239, "v");
        addTransition(state1, StateType.STATE_249, "w");
        addTransition(state1, StateType.STATE_3, "/");
        addTransition(state1, StateType.STATE_8, "_");
        addTransition(state1, StateType.STATE_9, NUMEROS);
        states.put(StateType.STATE_1, state1);

        states.put(StateType.STATE_3, createState(StateType.STATE_4,"*"));

        State state4 = createState(StateType.STATE_4, Stream.of(ALFABETO_MINUSCULO, ALFABETO_MAIUSCULO, NUMEROS, new String[]{"_", " "}).flatMap(Stream::of).toArray(String[]::new));
        addTransition(state4, StateType.STATE_5, "*");
        states.put(StateType.STATE_4, state4 );

        states.put(StateType.STATE_5, createState(StateType.STATE_6,"/"));
        states.put(StateType.STATE_6, createStateFinish(TokenType.COMMENT));

        State state8 = createStateFinish(TokenType.IDENTIFICADOR);
        addTransition(state8, StateType.STATE_8, Stream.of(ALFABETO_MINUSCULO, ALFABETO_MAIUSCULO, NUMEROS, new String[]{"_"}).flatMap(Stream::of).toArray(String[]::new));
        states.put(StateType.STATE_8, state8);

        State state9 = createStateFinish(TokenType.INT_NUMBER);
        addTransition(state9, StateType.STATE_9, NUMEROS);
        addTransition(state9, StateType.STATE_10, ".");
        states.put(StateType.STATE_9, state9);

        states.put(StateType.STATE_10, createState(StateType.STATE_11,NUMEROS));

        State state11 = createStateFinish(TokenType.REAL_NUMBER);
        addTransition(state11, StateType.STATE_11, NUMEROS);
        states.put(StateType.STATE_11, state11);

        states.putAll(getStatesReservedWordsInitA());
        states.putAll(getStatesReservedWordsInitB());
        states.putAll(getStatesReservedWordsInitC());
        states.putAll(getStatesReservedWordsInitD());
        states.putAll(getStatesReservedWordsInitE());
        states.putAll(getStatesReservedWordsInitF());
        states.putAll(getStatesReservedWordsInitG());
        states.putAll(getStatesReservedWordsInitI());
        states.putAll(getStatesReservedWordsInitL());
        states.putAll(getStatesReservedWordsInitN());
        states.putAll(getStatesReservedWordsInitP());
        states.putAll(getStatesReservedWordsInitR());
        states.putAll(getStatesReservedWordsInitS());
        states.putAll(getStatesReservedWordsInitT());
        states.putAll(getStatesReservedWordsInitV());
        states.putAll(getStatesReservedWordsInitW());
        return states;


    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitA() {
        Map<StateType, State> states = new HashMap<>();

        State state12 = createState(false, false);
        addTransition(state12, StateType.STATE_13, "b");
        addTransition(state12, StateType.STATE_20, "s");
        states.put(StateType.STATE_12, state12);

        // abstract
        states.put(StateType.STATE_13, createState(StateType.STATE_14,"s"));
        states.put(StateType.STATE_14, createState(StateType.STATE_15,"t"));
        states.put(StateType.STATE_15, createState(StateType.STATE_16,"r"));
        states.put(StateType.STATE_16, createState(StateType.STATE_17,"a"));
        states.put(StateType.STATE_17, createState(StateType.STATE_18,"c"));
        states.put(StateType.STATE_18, createState(StateType.STATE_19,"t"));
        states.put(StateType.STATE_19, createStateFinish(TokenType.ABSTRACT));

        // assert
        states.put(StateType.STATE_20, createState(StateType.STATE_21,"s"));
        states.put(StateType.STATE_21, createState(StateType.STATE_22,"e"));
        states.put(StateType.STATE_22, createState(StateType.STATE_23,"r"));
        states.put(StateType.STATE_23, createState(StateType.STATE_24,"t"));
        states.put(StateType.STATE_24, createStateFinish(TokenType.ASSERT));
        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitB() {
        Map<StateType, State> states = new HashMap<>();

        State state25 = createState(false, false);
        addTransition(state25, StateType.STATE_26, "o");
        addTransition(state25, StateType.STATE_32, "r");
        addTransition(state25, StateType.STATE_36, "y");
        states.put(StateType.STATE_25, state25);

        // boolean
        states.put(StateType.STATE_26, createState(StateType.STATE_27,"o"));
        states.put(StateType.STATE_27, createState(StateType.STATE_28,"l"));
        states.put(StateType.STATE_28, createState(StateType.STATE_29,"e"));
        states.put(StateType.STATE_29, createState(StateType.STATE_30,"a"));
        states.put(StateType.STATE_30, createState(StateType.STATE_31,"n"));
        states.put(StateType.STATE_31, createStateFinish(TokenType.BOOLEAN));

        // break
        states.put(StateType.STATE_32, createState(StateType.STATE_33,"e"));
        states.put(StateType.STATE_33, createState(StateType.STATE_34,"a"));
        states.put(StateType.STATE_34, createState(StateType.STATE_35,"k"));
        states.put(StateType.STATE_35, createStateFinish(TokenType.BREAK));

        // byte
        states.put(StateType.STATE_36, createState(StateType.STATE_37,"t"));
        states.put(StateType.STATE_37, createState(StateType.STATE_38,"e"));
        states.put(StateType.STATE_38, createStateFinish(TokenType.BYTE));
        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitC() {
        Map<StateType, State> states = new HashMap<>();

        State state39 = createState(false, false);
        addTransition(state39, StateType.STATE_40, "a");
        addTransition(state39, StateType.STATE_46, "h");
        addTransition(state39, StateType.STATE_49, "l");
        addTransition(state39, StateType.STATE_53, "o");
        states.put(StateType.STATE_39, state39);

        // a
        State state40 = createState(StateType.STATE_41, "s");
        addTransition(state40,StateType.STATE_43, "t");
        states.put(StateType.STATE_40, state40);

        // o
        states.put(StateType.STATE_53, createState(StateType.STATE_54, "n"));

        //n
        State state54 = createState(StateType.STATE_55, "s");
        addTransition(state54,StateType.STATE_57, "t");
        states.put(StateType.STATE_54, state54);

        // case
        states.put(StateType.STATE_41, createState(StateType.STATE_42,"e"));
        states.put(StateType.STATE_42, createStateFinish(TokenType.CASE));

        // catch
        states.put(StateType.STATE_43, createState(StateType.STATE_44,"c"));
        states.put(StateType.STATE_44, createState(StateType.STATE_45,"h"));
        states.put(StateType.STATE_45, createStateFinish(TokenType.CATCH));

        // char
        states.put(StateType.STATE_46, createState(StateType.STATE_47,"a"));
        states.put(StateType.STATE_47, createState(StateType.STATE_48,"r"));
        states.put(StateType.STATE_48, createStateFinish(TokenType.CHAR));

        // class
        states.put(StateType.STATE_49, createState(StateType.STATE_50,"a"));
        states.put(StateType.STATE_50, createState(StateType.STATE_51,"s"));
        states.put(StateType.STATE_51, createState(StateType.STATE_52,"s"));
        states.put(StateType.STATE_52, createStateFinish(TokenType.CLASS));

        // const
        states.put(StateType.STATE_55, createState(StateType.STATE_56,"t"));
        states.put(StateType.STATE_56, createStateFinish(TokenType.CONST));

        // continue
        states.put(StateType.STATE_57, createState(StateType.STATE_58,"i"));
        states.put(StateType.STATE_58, createState(StateType.STATE_59,"n"));
        states.put(StateType.STATE_59, createState(StateType.STATE_60,"u"));
        states.put(StateType.STATE_60, createState(StateType.STATE_61,"e"));
        states.put(StateType.STATE_61, createStateFinish(TokenType.CONTINUE));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitD() {
        Map<StateType, State> states = new HashMap<>();

        State state62 = createState(false, false);
        addTransition(state62, StateType.STATE_63, "e");
        addTransition(state62, StateType.STATE_69, "o");
        states.put(StateType.STATE_62, state62);

        // default
        states.put(StateType.STATE_63, createState(StateType.STATE_64,"f"));
        states.put(StateType.STATE_64, createState(StateType.STATE_65,"a"));
        states.put(StateType.STATE_65, createState(StateType.STATE_66,"u"));
        states.put(StateType.STATE_66, createState(StateType.STATE_67,"l"));
        states.put(StateType.STATE_67, createState(StateType.STATE_68,"t"));
        states.put(StateType.STATE_68, createStateFinish(TokenType.DEFAULT));

        // o
        State state69 = createStateFinish(TokenType.DO);
        addTransition(state69, StateType.STATE_70, "u");
        states.put(StateType.STATE_69, state69);

        // double
        states.put(StateType.STATE_70, createState(StateType.STATE_71,"b"));
        states.put(StateType.STATE_71, createState(StateType.STATE_72,"l"));
        states.put(StateType.STATE_72, createState(StateType.STATE_73,"e"));
        states.put(StateType.STATE_73, createStateFinish(TokenType.DOUBLE));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitE() {
        Map<StateType, State> states = new HashMap<>();

        State state74 = createState(false, false);
        addTransition(state74, StateType.STATE_75, "l");
        addTransition(state74, StateType.STATE_78, "n");
        addTransition(state74, StateType.STATE_81, "x");
        states.put(StateType.STATE_74, state74);

        // else
        states.put(StateType.STATE_75, createState(StateType.STATE_76,"s"));
        states.put(StateType.STATE_76, createState(StateType.STATE_77,"e"));
        states.put(StateType.STATE_77, createStateFinish(TokenType.ELSE));

        // enum
        states.put(StateType.STATE_78, createState(StateType.STATE_79,"u"));
        states.put(StateType.STATE_79, createState(StateType.STATE_80,"m"));
        states.put(StateType.STATE_80, createStateFinish(TokenType.ENUM));

        // extends
        states.put(StateType.STATE_81, createState(StateType.STATE_82,"t"));
        states.put(StateType.STATE_82, createState(StateType.STATE_83,"e"));
        states.put(StateType.STATE_83, createState(StateType.STATE_84,"n"));
        states.put(StateType.STATE_84, createState(StateType.STATE_85,"d"));
        states.put(StateType.STATE_85, createState(StateType.STATE_86,"s"));
        states.put(StateType.STATE_86, createStateFinish(TokenType.EXTENDS));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitF() {
        Map<StateType, State> states = new HashMap<>();
        State state87 = createState(false, false);
        addTransition(state87, StateType.STATE_88, "a");
        addTransition(state87, StateType.STATE_92, "i");
        addTransition(state87, StateType.STATE_98, "l");
        addTransition(state87, StateType.STATE_102, "o");
        states.put(StateType.STATE_87, state87);

        // false
        states.put(StateType.STATE_88, createState(StateType.STATE_89,"l"));
        states.put(StateType.STATE_89, createState(StateType.STATE_90,"s"));
        states.put(StateType.STATE_90, createState(StateType.STATE_91,"e"));
        states.put(StateType.STATE_91, createStateFinish(TokenType.FALSE));

        // i
        states.put(StateType.STATE_92, createState(StateType.STATE_93, "n"));
        // n
        states.put(StateType.STATE_93, createState(StateType.STATE_94, "a"));
        // a
        states.put(StateType.STATE_94, createState(StateType.STATE_95, "l"));
        // l
        State state95 = createStateFinish(TokenType.FINAL);
        addTransition(state95, StateType.STATE_96, "l");
        states.put(StateType.STATE_95, state95);

        // finally
        states.put(StateType.STATE_96, createState(StateType.STATE_97,"y"));
        states.put(StateType.STATE_97, createStateFinish(TokenType.FINALLY));

        // float
        states.put(StateType.STATE_98, createState(StateType.STATE_99,"o"));
        states.put(StateType.STATE_99, createState(StateType.STATE_100,"a"));
        states.put(StateType.STATE_100, createState(StateType.STATE_101,"t"));
        states.put(StateType.STATE_101, createStateFinish(TokenType.FLOAT));

        // for
        states.put(StateType.STATE_102, createState(StateType.STATE_103,"r"));
        states.put(StateType.STATE_103, createStateFinish(TokenType.FOR));

        return states;
    }
    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitG() {
        Map<StateType, State> states = new HashMap<>();
        states.put(StateType.STATE_104, createState(StateType.STATE_105, "o"));
        states.put(StateType.STATE_105, createState(StateType.STATE_106, "t"));
        states.put(StateType.STATE_106, createState(StateType.STATE_107, "o"));
        states.put(StateType.STATE_107, createStateFinish(TokenType.GOTO));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitI() {
        Map<StateType, State> states = new HashMap<>();
        State state108 = createState(false, false);
        addTransition(state108, StateType.STATE_109, "f");
        addTransition(state108, StateType.STATE_110, "m");
        addTransition(state108, StateType.STATE_122, "n");
        states.put(StateType.STATE_108, state108);

        // if
        states.put(StateType.STATE_109, createStateFinish(TokenType.IF));

        // m
        states.put(StateType.STATE_110, createState(StateType.STATE_111, "p"));
        // p
        State state111 = createState(StateType.STATE_112, "l");
        addTransition(state111, StateType.STATE_119, "o");
        states.put(StateType.STATE_111, state111);

        // implements
        states.put(StateType.STATE_112, createState(StateType.STATE_113, "e"));
        states.put(StateType.STATE_113, createState(StateType.STATE_114, "m"));
        states.put(StateType.STATE_114, createState(StateType.STATE_115, "e"));
        states.put(StateType.STATE_115, createState(StateType.STATE_116, "n"));
        states.put(StateType.STATE_116, createState(StateType.STATE_117, "t"));
        states.put(StateType.STATE_117, createState(StateType.STATE_118, "s"));
        states.put(StateType.STATE_118, createStateFinish(TokenType.IMPLEMENTS));

        // import
        states.put(StateType.STATE_119, createState(StateType.STATE_120, "r"));
        states.put(StateType.STATE_120, createState(StateType.STATE_121, "t"));
        states.put(StateType.STATE_121, createStateFinish(TokenType.IMPORT));

        // n
        State state122 = createState(StateType.STATE_123, "s");
        addTransition(state122, StateType.STATE_131, "t");
        states.put(StateType.STATE_122, state122);

        // instanceof
        states.put(StateType.STATE_123, createState(StateType.STATE_124,"t"));
        states.put(StateType.STATE_124, createState(StateType.STATE_125,"a"));
        states.put(StateType.STATE_125, createState(StateType.STATE_126,"n"));
        states.put(StateType.STATE_126, createState(StateType.STATE_127,"c"));
        states.put(StateType.STATE_127, createState(StateType.STATE_128,"e"));
        states.put(StateType.STATE_128, createState(StateType.STATE_129,"o"));
        states.put(StateType.STATE_129, createState(StateType.STATE_130,"f"));
        states.put(StateType.STATE_130, createStateFinish(TokenType.INSTANCEOF));

        // int
        State state131 = createStateFinish(TokenType.INT);
        addTransition(state131, StateType.STATE_132, "e");
        states.put(StateType.STATE_131, state131);

        // interface
        states.put(StateType.STATE_132, createState(StateType.STATE_133,"r"));
        states.put(StateType.STATE_133, createState(StateType.STATE_134,"f"));
        states.put(StateType.STATE_134, createState(StateType.STATE_135,"a"));
        states.put(StateType.STATE_135, createState(StateType.STATE_136,"c"));
        states.put(StateType.STATE_136, createState(StateType.STATE_137,"e"));
        states.put(StateType.STATE_137, createStateFinish(TokenType.INTERFACE));

        return states;
    }
    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitL() {

        Map<StateType, State> states = new HashMap<>();
        states.put(StateType.STATE_138, createState(StateType.STATE_139, "o"));
        states.put(StateType.STATE_139, createState(StateType.STATE_140, "n"));
        states.put(StateType.STATE_140, createState(StateType.STATE_141, "g"));
        states.put(StateType.STATE_141, createStateFinish(TokenType.LONG));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitN() {
        Map<StateType, State> states = new HashMap<>();
        State state142 = createState(false, false);
        addTransition(state142, StateType.STATE_143, "a");
        addTransition(state142, StateType.STATE_148, "e");
        addTransition(state142, StateType.STATE_150, "u");
        states.put(StateType.STATE_142, state142);

        // native
        states.put(StateType.STATE_143, createState(StateType.STATE_144, "t"));
        states.put(StateType.STATE_144, createState(StateType.STATE_145, "i"));
        states.put(StateType.STATE_145, createState(StateType.STATE_146, "v"));
        states.put(StateType.STATE_146, createState(StateType.STATE_147, "e"));
        states.put(StateType.STATE_147, createStateFinish(TokenType.NATIVE));

        // new
        states.put(StateType.STATE_148, createState(StateType.STATE_149, "w"));
        states.put(StateType.STATE_149, createStateFinish(TokenType.NEW));

        // null
        states.put(StateType.STATE_150, createState(StateType.STATE_151, "l"));
        states.put(StateType.STATE_151, createState(StateType.STATE_152, "l"));
        states.put(StateType.STATE_152, createStateFinish(TokenType.NULL));
        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitP() {
        Map<StateType, State> states = new HashMap<>();
        State state153 = createState(false, false);
        addTransition(state153, StateType.STATE_154, "a");
        addTransition(state153, StateType.STATE_160, "r");
        addTransition(state153, StateType.STATE_173, "u");
        states.put(StateType.STATE_153, state153);

        // package
        states.put(StateType.STATE_154, createState(StateType.STATE_155, "c"));
        states.put(StateType.STATE_155, createState(StateType.STATE_156, "k"));
        states.put(StateType.STATE_156, createState(StateType.STATE_157, "a"));
        states.put(StateType.STATE_157, createState(StateType.STATE_158, "g"));
        states.put(StateType.STATE_158, createState(StateType.STATE_159, "e"));
        states.put(StateType.STATE_159, createStateFinish(TokenType.PACKAGE));

        // r
        State state160 = createState(StateType.STATE_161, "i");
        addTransition(state160, StateType.STATE_166, "o");
        states.put(StateType.STATE_160, state160);

        // private
        states.put(StateType.STATE_161, createState(StateType.STATE_162, "v"));
        states.put(StateType.STATE_162, createState(StateType.STATE_163, "a"));
        states.put(StateType.STATE_163, createState(StateType.STATE_164, "t"));
        states.put(StateType.STATE_164, createState(StateType.STATE_165, "e"));
        states.put(StateType.STATE_165, createStateFinish(TokenType.PRIVATE));

        // protected
        states.put(StateType.STATE_166, createState(StateType.STATE_167, "t"));
        states.put(StateType.STATE_167, createState(StateType.STATE_168, "e"));
        states.put(StateType.STATE_168, createState(StateType.STATE_169, "c"));
        states.put(StateType.STATE_169, createState(StateType.STATE_170, "t"));
        states.put(StateType.STATE_170, createState(StateType.STATE_171, "e"));
        states.put(StateType.STATE_171, createState(StateType.STATE_172, "d"));
        states.put(StateType.STATE_172, createStateFinish(TokenType.PROTECTED));

        // public
        states.put(StateType.STATE_173, createState(StateType.STATE_174, "b"));
        states.put(StateType.STATE_174, createState(StateType.STATE_175, "l"));
        states.put(StateType.STATE_175, createState(StateType.STATE_176, "i"));
        states.put(StateType.STATE_176, createState(StateType.STATE_177, "c"));
        states.put(StateType.STATE_177, createStateFinish(TokenType.PUBLIC));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitR() {
        Map<StateType, State> states = new HashMap<>();
        states.put(StateType.STATE_178, createState(StateType.STATE_179, "e"));
        states.put(StateType.STATE_179, createState(StateType.STATE_180, "t"));
        states.put(StateType.STATE_180, createState(StateType.STATE_181, "u"));
        states.put(StateType.STATE_181, createState(StateType.STATE_182, "r"));
        states.put(StateType.STATE_182, createState(StateType.STATE_183, "n"));
        states.put(StateType.STATE_183, createStateFinish(TokenType.RETURN));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitS() {
        Map<StateType, State> states = new HashMap<>();
        State state184 = createState(false, false);
        addTransition(state184, StateType.STATE_185, "h");
        addTransition(state184, StateType.STATE_189, "t");
        addTransition(state184, StateType.STATE_200, "u");
        addTransition(state184, StateType.STATE_204, "w");
        addTransition(state184, StateType.STATE_209, "y");
        states.put(StateType.STATE_184, state184);

        // short
        states.put(StateType.STATE_185, createState(StateType.STATE_186, "o"));
        states.put(StateType.STATE_186, createState(StateType.STATE_187, "r"));
        states.put(StateType.STATE_187, createState(StateType.STATE_188, "t"));
        states.put(StateType.STATE_188, createStateFinish(TokenType.SHORT));

        // t
        State state189 = createState(StateType.STATE_190, "a");
        addTransition(state189, StateType.STATE_194, "r");
        states.put(StateType.STATE_189, state189);

        // static
        states.put(StateType.STATE_190, createState(StateType.STATE_191, "t"));
        states.put(StateType.STATE_191, createState(StateType.STATE_192, "i"));
        states.put(StateType.STATE_192, createState(StateType.STATE_193, "c"));
        states.put(StateType.STATE_193, createStateFinish(TokenType.STATIC));

        // strictfp
        states.put(StateType.STATE_194, createState(StateType.STATE_195, "i"));
        states.put(StateType.STATE_195, createState(StateType.STATE_196, "c"));
        states.put(StateType.STATE_196, createState(StateType.STATE_197, "t"));
        states.put(StateType.STATE_197, createState(StateType.STATE_198, "f"));
        states.put(StateType.STATE_198, createState(StateType.STATE_199, "p"));
        states.put(StateType.STATE_199, createStateFinish(TokenType.STRICTFP));

        // super
        states.put(StateType.STATE_200, createState(StateType.STATE_201, "p"));
        states.put(StateType.STATE_201, createState(StateType.STATE_202, "e"));
        states.put(StateType.STATE_202, createState(StateType.STATE_203, "r"));
        states.put(StateType.STATE_203, createStateFinish(TokenType.SUPER));

        // switch
        states.put(StateType.STATE_204, createState(StateType.STATE_205, "i"));
        states.put(StateType.STATE_205, createState(StateType.STATE_206, "t"));
        states.put(StateType.STATE_206, createState(StateType.STATE_207, "c"));
        states.put(StateType.STATE_207, createState(StateType.STATE_208, "h"));
        states.put(StateType.STATE_208, createStateFinish(TokenType.SWITCH));

        // synchronized
        states.put(StateType.STATE_209, createState(StateType.STATE_210, "n"));
        states.put(StateType.STATE_210, createState(StateType.STATE_211, "c"));
        states.put(StateType.STATE_211, createState(StateType.STATE_212, "h"));
        states.put(StateType.STATE_212, createState(StateType.STATE_213, "r"));
        states.put(StateType.STATE_213, createState(StateType.STATE_214, "o"));
        states.put(StateType.STATE_214, createState(StateType.STATE_215, "n"));
        states.put(StateType.STATE_215, createState(StateType.STATE_216, "i"));
        states.put(StateType.STATE_216, createState(StateType.STATE_217, "z"));
        states.put(StateType.STATE_217, createState(StateType.STATE_218, "e"));
        states.put(StateType.STATE_218, createState(StateType.STATE_219, "d"));
        states.put(StateType.STATE_219, createStateFinish(TokenType.SYNCHRONIZED));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitT() {
        Map<StateType, State> states = new HashMap<>();
        State state220 = createState(false, false);
        addTransition(state220, StateType.STATE_221, "h");
        addTransition(state220, StateType.STATE_228, "r");
        states.put(StateType.STATE_220, state220);

        // h
        State state221 = createState(StateType.STATE_222, "i");
        addTransition(state221, StateType.STATE_224, "r");
        states.put(StateType.STATE_221, state221);

        // this
        states.put(StateType.STATE_222, createState(StateType.STATE_223, "s"));
        states.put(StateType.STATE_223, createStateFinish(TokenType.THIS));

        // r
        states.put(StateType.STATE_224, createState(StateType.STATE_225, "o"));
        states.put(StateType.STATE_225, createState(StateType.STATE_226, "w"));
        State state226 = createStateFinish(TokenType.THROW);
        addTransition(state226, StateType.STATE_227, "s");
        states.put(StateType.STATE_226, state226);

        // throws
        states.put(StateType.STATE_227, createStateFinish(TokenType.THROWS));

        // r
        State state228 = createState(StateType.STATE_229, "a");
        addTransition(state228, StateType.STATE_236, "u");
        addTransition(state228, StateType.STATE_238, "y");
        states.put(StateType.STATE_228, state228);

        // transient
        states.put(StateType.STATE_229, createState(StateType.STATE_230, "n"));
        states.put(StateType.STATE_230, createState(StateType.STATE_231, "s"));
        states.put(StateType.STATE_231, createState(StateType.STATE_232, "i"));
        states.put(StateType.STATE_232, createState(StateType.STATE_233, "e"));
        states.put(StateType.STATE_233, createState(StateType.STATE_234, "n"));
        states.put(StateType.STATE_234, createState(StateType.STATE_235, "t"));
        states.put(StateType.STATE_235, createStateFinish(TokenType.TRANSIENT));

        // true
        states.put(StateType.STATE_236, createState(StateType.STATE_237, "e"));
        states.put(StateType.STATE_237, createStateFinish(TokenType.TRUE));

        // try
        states.put(StateType.STATE_238, createStateFinish(TokenType.TRY));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitV() {
        Map<StateType, State> states = new HashMap<>();
        State state239 = createState(false, false);
        addTransition(state239, StateType.STATE_240, "o");
        states.put(StateType.STATE_239, state239);

        // o
        State state240 = createState(StateType.STATE_241, "i");
        addTransition(state240, StateType.STATE_243, "l");
        states.put(StateType.STATE_240, state240);

        // void
        states.put(StateType.STATE_241, createState(StateType.STATE_242, "d"));
        states.put(StateType.STATE_242, createStateFinish(TokenType.VOID));

        // volatile
        states.put(StateType.STATE_243, createState(StateType.STATE_244, "a"));
        states.put(StateType.STATE_244, createState(StateType.STATE_245, "t"));
        states.put(StateType.STATE_245, createState(StateType.STATE_246, "i"));
        states.put(StateType.STATE_246, createState(StateType.STATE_247, "l"));
        states.put(StateType.STATE_247, createState(StateType.STATE_248, "e"));
        states.put(StateType.STATE_248, createStateFinish(TokenType.VOLATILE));

        return states;
    }

    private static Map<? extends StateType, ? extends State> getStatesReservedWordsInitW() {
        Map<StateType, State> states = new HashMap<>();
        states.put(StateType.STATE_249, createState(StateType.STATE_250, "h"));
        states.put(StateType.STATE_250, createState(StateType.STATE_251, "i"));
        states.put(StateType.STATE_251, createState(StateType.STATE_252, "l"));
        states.put(StateType.STATE_252, createState(StateType.STATE_253, "e"));
        states.put(StateType.STATE_253, createStateFinish(TokenType.WHILE));

        return states;
    }

    private static void addTransition(State state, StateType destination, String... characters) {
        Arrays.asList(characters).stream().forEach(c -> state.getTransitions().put(c, destination));
    }

    private static State createState(StateType destiny, String... characters) {
        State state = State
                .builder()
                .initial(false)
                .finish(false)
                .transitions(new HashMap<>())
                .build();
        addTransition(state, destiny,characters);
        return state;
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

    private static State createStateFinish(TokenType tokenType) {
        return State
                .builder()
                .initial(false)
                .finish(true)
                .transitions(new HashMap<>())
                .tokenType(tokenType)
                .build();
    }
}
