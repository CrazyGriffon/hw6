package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Код Морзе состоит из символов точка(.) и тире(-).<br/>
 * Разделителем между символами в слове является пробел( )<br/>
 * Разделителем между словами является слэш(/).<br/>
 * <br/>
 * Пример исходного сообщения: 'hello world'<br/>
 * Пример закодированного: '.... . .-.. .-.. --- / .-- --- .-. .-.. -..'<br/>
 * <p>
 * Для кодирования\декодирования можно воспользоваться префиксным деревом (hint.png)<br/>
 * Словарь можно посмотреть в morse.jpg<br/>
 *
 * @see <a href="https://morsecodetranslator.com/">https://morsecodetranslator.com/</a>
 */
public interface MorseTranslator {
    Map<Character, String> MorseMapping = new HashMap<>() {
        {
            put('a', ".-");
            put('b', "-...");
            put('c', "-.-.");
            put('d', "-..");
            put('e', ".");
            put('f', "..-.");
            put('g', "--.");
            put('h', "....");
            put('i', "..");
            put('j', ".---");
            put('k', "-.-");
            put('l', ".-..");
            put('m', "--");
            put('n', "-.");
            put('o', "---");
            put('p', ".--.");
            put('q', "--.-");
            put('r', ".-.");
            put('s', "...");
            put('t', "-");
            put('u', "..-");
            put('v', "...-");
            put('w', ".--");
            put('x', "-..-");
            put('y', "-.--");
            put('z', "--..");

            put('0', "-----");
            put('1', ".----");
            put('2', "..---");
            put('3', "...--");
            put('4', "....-");
            put('5', ".....");
            put('6', "-....");
            put('7', "--...");
            put('8', "---..");
            put('9', "----.");
        }
    };

    /**
     * Расшифровка кода Морзе
     *
     * @param morseCode input string
     * @return decoded string
     */
    String decode(String morseCode);

    /**
     * Шифрование кодом Морзе
     *
     * @param source input string
     * @return encoded string
     */
    String encode(String source);
}
