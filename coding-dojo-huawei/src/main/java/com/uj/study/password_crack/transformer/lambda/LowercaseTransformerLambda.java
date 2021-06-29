package com.uj.study.password_crack.transformer.lambda;

import com.uj.study.password_crack.transformer.old.PwdTransformerOld;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/29 下午12:26
 * @description：
 */
public class LowercaseTransformerLambda implements UnaryOperator<Character> {
    private static final Pattern LOWER_PATTERN = Pattern.compile("\\p{Lower}");

    private static Map<String, Character> mapper;

    static  {
        mapper = new HashMap<>();
        mapper.put("abc", '2');
        mapper.put("def", '3');
        mapper.put("ghi", '4');
        mapper.put("jkl", '5');
        mapper.put("mno", '6');
        mapper.put("pqrs", '7');
        mapper.put("tuv", '8');
        mapper.put("wxyz", '9');
    }

    @Override
    public Character apply(Character character) {
        return canHandle(character) ? handle(character) : character;
    }

    private char handle(char c) {
        String key = mapper.keySet().stream().filter(k->k.contains(String.valueOf(c))).collect(Collectors.joining());
        return mapper.get(key);
    }

    private boolean canHandle(char c) {
        return LOWER_PATTERN.matcher(String.valueOf(c)).matches();
    }
}
