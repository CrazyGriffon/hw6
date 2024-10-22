package org.example;

import java.util.Map;

public class MorseTranslatorImpl implements MorseTranslator {
    private final Node root;

    public MorseTranslatorImpl() {
        root = new Node();
        for (Map.Entry<Character, String> entry : MorseMapping.entrySet()) {
            insert(entry.getKey(), entry.getValue());
        }
    }

    private void insert(char alphabeticChar, String morseSymbol) {
        Node p = root;
        for (char c : morseSymbol.toCharArray()) {
            if (c == '.') {
                if (p.dotLeft == null) {
                    p.dotLeft = new Node();
                }
                p = p.dotLeft;
            } else if (c == '-') {
                if (p.dashRight == null) {
                    p.dashRight = new Node();
                }
                p = p.dashRight;
            } else {
                throw new IllegalArgumentException("Unknown char in Morse symbol " + c);
            }
        }
        p.alphabeticChar = alphabeticChar;
    }

    private Character search(String morseSymbol) {
        Node p = root;
        for (char c : morseSymbol.toCharArray()) {
            if (c == '.') {
                p = p.dotLeft;
            } else if (c == '-') {
                p = p.dashRight;
            } else {
                throw new IllegalArgumentException("Unknown char in Morse symbol " + c);
            }
        }
        return p.alphabeticChar;
    }

    @Override
    public String decode(String morseCode) {
        char[] chars = morseCode.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = chars.length;
        while (i < n) {
            while (i < n && chars[i] == ' ') {
                ++i;
            }
            if (i < n && chars[i] == '/') {
                sb.append(' ');
                ++i;
            }
            int j = i;
            while (i < n && (chars[i] == '.' || chars[i] == '-')) {
                ++i;
            }
            if (i > j) {
                sb.append(search(morseCode.substring(j, i)));
            }
        }
        return sb.toString().trim();
    }


    @Override
    public String encode(String source) {
        char[] chars = source.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c == ' ') {
                sb.append('/');
                sb.append(' ');
            } else if (MorseMapping.containsKey(c)) {
                sb.append(MorseMapping.get(c));
                sb.append(' ');
            } else {
                throw new IllegalArgumentException("Unknown char in source string " + c);
            }
        }
        return sb.toString().trim();
    }

    static class Node {
        Character alphabeticChar;
        Node dotLeft;
        Node dashRight;
    }
}
