package com.uj.study.brother_word;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2022/3/4 下午12:27
 * @description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputData {
    private int wordCount;
    private List<String> words;
    private String word;
    private int index;
}
