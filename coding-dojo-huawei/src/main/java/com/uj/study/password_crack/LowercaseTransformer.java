package com.uj.study.password_crack;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author ：UncleJet
 * @date ：Created in 2021/6/23 上午10:08
 * @description：
 */
public class LowercaseTransformer extends PwdTransformer {
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

    public LowercaseTransformer(PwdTransformer nextTransformer) {
        super(nextTransformer);
    }

    @Override
    public char handle(char c) {
        String key = mapper.keySet().stream().filter(k->k.contains(String.valueOf(c))).collect(Collectors.joining());
        return mapper.get(key);
    }

    @Override
    boolean canHandle(char c) {
        return LOWER_PATTERN.matcher(String.valueOf(c)).matches();
    }
}
