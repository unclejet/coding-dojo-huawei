package com.uj.study.password_strong_level;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 描述
 * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
 *
 * 一、密码长度:
 * 5 分: 小于等于4 个字符
 * 10 分: 5 到7 字符
 * 25 分: 大于等于8 个字符
 *
 * 二、字母:
 * 0 分: 没有字母
 * 10 分: 密码里的字母全都是小（大）写字母
 * 20 分: 密码里的字母符合"大小写混合"
 *
 * 三、数字:
 * 0 分: 没有数字
 * 10 分: 1 个数字
 * 20 分: 大于1 个数字
 *
 * 四、符号:
 * 0 分: 没有符号
 * 10 分: 1 个符号
 * 25 分: 大于1 个符号
 *
 * 五、奖励（只能选符合最多的那一种奖励）:
 * 2 分: 字母和数字
 * 3 分: 字母、数字和符号
 * 5 分: 大小写字母、数字和符号
 *
 * 最后的评分标准:
 * >= 90: 非常安全
 * >= 80: 安全（Secure）
 * >= 70: 非常强
 * >= 60: 强（Strong）
 * >= 50: 一般（Average）
 * >= 25: 弱（Weak）
 * >= 0:  非常弱（Very_Weak）
 *
 * 对应输出为：
 *
 * VERY_SECURE
 * SECURE
 * VERY_STRONG
 * STRONG
 * AVERAGE
 * WEAK
 * VERY_WEAK
 *
 * 请根据输入的密码字符串，进行安全评定。
 *
 * 注：
 * 字母：a-z, A-Z
 * 数字：0-9
 * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
 * !"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
 * :;<=>?@             (ASCII码：0x3A~0x40)
 * [\]^_`              (ASCII码：0x5B~0x60)
 * {|}~                (ASCII码：0x7B~0x7E)
 *
 * 提示:
 * 1 <= 字符串的长度<= 300
 * 输入描述：
 *
 * 输入一个string的密码
 * 输出描述：
 *
 * 输出密码等级
 * 示例1
 * 输入：
 *
 * 38$@NoNoN
 *
 * 输出：
 *
 * VERY_SECURE
 *
 * 说明：
 *
 * 样例的密码长度大于等于8个字符，得25分；大小写字母都有所以得20分；有两个数字，所以得20分；包含大于1符号，所以得25分；由于该密码包含大小写字母、数字和符号，所以奖励部分得5分，经统计得该密码的密码强度为25+20+20+25+5=95分。
 *
 *
 * 示例2
 * 输入：
 *
 * Jl)M:+
 *
 * 输出：
 *
 * AVERAGE
 *
 * 说明：
 *
 * 示例2的密码强度为10+20+0+25+0=55分。
 */
public class PasswordStrongLevelTest {
    /**
     * // 5 分: 小于等于4 个字符
     *         // 10 分: 5 到7 字符
     *         // 25 分: 大于等于8 个字符
     *
     */
    @Test
    void length_score() {
        Assertions.assertEquals(5, lengthScore("1234"));
        Assertions.assertEquals(10, lengthScore("12345"));
        Assertions.assertEquals(25, lengthScore("12345678"));
    }

    /**
     * // 0 分: 没有字母
     *         // 10 分: 密码里的字母全都是小（大）写字母
     *         // 20 分: 密码里的字母符合"大小写混合"
     *
    */
    @Test
    void alphabet_score() {
        Assertions.assertEquals(0, alphabetScore2("1234"));
        Assertions.assertEquals(10, alphabetScore2("abc"));
        Assertions.assertEquals(10, alphabetScore2("ABC"));
        Assertions.assertEquals(20, alphabetScore2("Abc"));
    }


    /**
     * * 三、数字:
     *  * 0 分: 没有数字
     *  * 10 分: 1 个数字
     *  * 20 分: 大于1 个数字
     */
    @Test
    void number_score() {
        Assertions.assertEquals(0, numberScore("abc"));
        Assertions.assertEquals(10, numberScore("1bc"));
        Assertions.assertEquals(20, numberScore("123"));
    }

    /**
     * 符号:
     *  * 0 分: 没有符号
     *  * 10 分: 1 个符号
     *  * 25 分: 大于1 个符号
     */
    @Test
    void symbol_score() {
        Assertions.assertEquals(0, symbolScore1("abc"));
        Assertions.assertEquals(10, symbolScore1("#bc"));
        Assertions.assertEquals(25, symbolScore1("!@#"));
    }

    /**
     * 奖励（只能选符合最多的那一种奖励）:
     *  * 2 分: 字母和数字
     *  * 3 分: 字母、数字和符号
     *  * 5 分: 大小写字母、数字和符号
     */
    @Test
    void reward_score() {
        Assertions.assertEquals(2, rewardScore1("abc1"));
        Assertions.assertEquals(3, rewardScore1("abc1#"));
        Assertions.assertEquals(5, rewardScore1("Abc1#"));
    }

    /**
     * * 最后的评分标准:
     *  * >= 90: 非常安全
     *  * >= 80: 安全（Secure）
     *  * >= 70: 非常强
     *  * >= 60: 强（Strong）
     *  * >= 50: 一般（Average）
     *  * >= 25: 弱（Weak）
     *  * >= 0:  非常弱（Very_Weak）
     *  *
     *  * 对应输出为：
     *  *
     *  * VERY_SECURE
     *  * SECURE
     *  * VERY_STRONG
     *  * STRONG
     *  * AVERAGE
     *  * WEAK
     *  * VERY_WEAK
     *  * 示例1
     *  * 输入：
     *  *
     *  * 38$@NoNoN
     *  *
     *  * 输出：
     *  *
     *  * VERY_SECURE
     *  *
     *  * 说明：
     *  *
     *  * 样例的密码长度大于等于8个字符，得25分；大小写字母都有所以得20分；有两个数字，所以得20分；包含大于1符号，所以得25分；由于该密码包含大小写字母、数字和符号，所以奖励部分得5分，经统计得该密码的密码强度为25+20+20+25+5=95分。
     *  *
     *  * 示例2
     *  * 输入：
     *  *
     *  * Jl)M:+
     *  *
     *  * 输出：
     *  *
     *  * AVERAGE
     *  *
     *  * 说明：
     *  *
     *  * 示例2的密码强度为10+20+0+25+0=55分。
     */
    @Test
    void final_score() {
        String password = "38$@NoNoN";
        Assertions.assertEquals("VERY_SECURE", finalScore(password));
        password = "Jl)M:+";
        Assertions.assertEquals("AVERAGE", finalScore(password));
    }

    private String finalScore(String password) {
        // 计算各部分得分
        int length = lengthScore(password);
        int alphabet = alphabetScore2(password);
        int number = numberScore(password);
        int symbol = symbolScore1(password);
        int reward = rewardScore1(password);
        
        // 计算总分
        int totalScore = length + alphabet + number + symbol + reward;
        
        // 根据总分返回安全等级
        if (totalScore >= 90) return "VERY_SECURE";
        if (totalScore >= 80) return "SECURE";
        if (totalScore >= 70) return "VERY_STRONG";
        if (totalScore >= 60) return "STRONG";
        if (totalScore >= 50) return "AVERAGE";
        if (totalScore >= 25) return "WEAK";
        return "VERY_WEAK";
    }

    // 1. 使用正则表达式实现（简洁优雅）
    private int rewardScore1(String password) {
        boolean hasLetter = password.matches(".*[a-zA-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSymbol = password.matches(".*[!-/:-@\\[-`{-~].*");
        boolean hasMixedCase = password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
        
        if (hasMixedCase && hasNumber && hasSymbol) return 5;
        if (hasLetter && hasNumber && hasSymbol) return 3;
        if (hasLetter && hasNumber) return 2;
        return 0;
    }

    // 2. 使用Stream API实现（函数式风格）
    private int rewardScore2(String password) {
        boolean hasLower = password.chars().anyMatch(Character::isLowerCase);
        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSymbol = password.chars().anyMatch(c -> 
            (c >= 0x21 && c <= 0x2F) ||
            (c >= 0x3A && c <= 0x40) ||
            (c >= 0x5B && c <= 0x60) ||
            (c >= 0x7B && c <= 0x7E));
        
        if (hasLower && hasUpper && hasDigit && hasSymbol) return 5;
        if ((hasLower || hasUpper) && hasDigit && hasSymbol) return 3;
        if ((hasLower || hasUpper) && hasDigit) return 2;
        return 0;
    }

    // 3. 使用传统循环实现（性能最优）
    private int rewardScore3(String password) {
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSymbol = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if ((c >= 0x21 && c <= 0x2F) ||
                    (c >= 0x3A && c <= 0x40) ||
                    (c >= 0x5B && c <= 0x60) ||
                    (c >= 0x7B && c <= 0x7E)) {
                hasSymbol = true;
            }
            
            // 提前返回优化：如果已经找到所有类型，可以直接返回最高分
            if (hasLower && hasUpper && hasDigit && hasSymbol) return 5;
        }
        
        // 计算最终得分
        if (hasLower && hasUpper && hasDigit && hasSymbol) return 5;
        if ((hasLower || hasUpper) && hasDigit && hasSymbol) return 3;
        if ((hasLower || hasUpper) && hasDigit) return 2;
        return 0;
    }

    // 1. 使用正则表达式实现（简洁优雅）
    private int symbolScore1(String password) {
        // 符号的正则表达式：[!-/:-@[-`{-~] 包含了所有ASCII码：0x21~0x2F, 0x3A~0x40, 0x5B~0x60, 0x7B~0x7E
        if (!password.matches(".*[!-/:-@\\[-`{-~].*")) {
            return 0;  // 没有符号
        }
        return password.matches(".*[!-/:-@\\[-`{-~].*[!-/:-@\\[-`{-~].*") ? 25 : 10;
    }

    // 2. 使用Stream API实现（函数式风格）
    private int symbolScore2(String password) {
        long symbolCount = password.chars()
                .filter(c -> (c >= 0x21 && c <= 0x2F) ||
                           (c >= 0x3A && c <= 0x40) ||
                           (c >= 0x5B && c <= 0x60) ||
                           (c >= 0x7B && c <= 0x7E))
                .count();
        
        return symbolCount == 0 ? 0 :
               symbolCount > 1 ? 25 : 10;
    }

    // 3. 使用传统循环实现（性能最优）
    private int symbolScore3(String password) {
        int symbolCount = 0;
        for (char c : password.toCharArray()) {
            if ((c >= 0x21 && c <= 0x2F) ||
                (c >= 0x3A && c <= 0x40) ||
                (c >= 0x5B && c <= 0x60) ||
                (c >= 0x7B && c <= 0x7E)) {
                symbolCount++;
                if (symbolCount > 1) {
                    return 25;  // 发现第二个符号就可以直接返回
                }
            }
        }
        return symbolCount == 0 ? 0 : 10;
    }

    private int numberScore(String password) {
        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
                if (digitCount > 1) {
                    return 20;  // 发现第二个数字就可以直接返回
                }
            }
        }
        return digitCount == 0 ? 0 : 10;
    }

    private int numberScore2(String password) {
        long digitCount = password.chars()
                .filter(Character::isDigit)
                .count();
        return digitCount == 0 ? 0 :
                digitCount > 1 ? 20 : 10;
    }

    private int numberScore3(String password) {
        if (!password.matches(".*\\d.*")) {
            return 0;  // 没有数字
        }
        return password.matches(".*\\d.*\\d.*") ? 20 : 10;  // 多个数字返回20，一个数字返回10
    }


    private int alphabetScore(String password) {
        return !password.matches(".*[a-zA-Z].*") ? 0 :
               password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") ? 20 : 10;
    }

    private int alphabetScore2(String password) {
        // 使用 Stream API 统计大小写字母
        long lowerCount = password.chars().filter(Character::isLowerCase).count();
        long upperCount = password.chars().filter(Character::isUpperCase).count();

        // 使用三元运算符简化逻辑判断
        return (lowerCount + upperCount == 0) ? 0 :
                (lowerCount > 0 && upperCount > 0) ? 20 : 10;
    }

    private int lengthScore(String password) {
        int length = password.length();
        
        if (length <= 4) {
            return 5;
        } else if (length <= 7) {
            return 10;
        } else {
            return 25;
        }
    }
}
