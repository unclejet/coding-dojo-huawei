# target
Software Craftsmanship practice.

# environment 
JDK 11 gradle 6.1 junit 5.5.2

# 知识点
## utils
-- random alphabet generator by length.(包括字母和数字)
-- random lowercase chars(只有小写字母)

## approximate value
- 正则表达式：小数点

## decimal.binary.conversion
- 正则表达式： 十六进制数

## mingming_random
- 正则表达式：数字

## extract.non-repeat.integer
- 字符串反转
- 字符串分割
- 字符数组去重
- 字符串合并

## combine.table.record
- Collectors.groupingBy
- Collectors.summingInt 
- sorted(Comparator.comparingInt)

## count_char_numbers
- 正则表达式： ASCII字符
- lambda数字符个数

## reverse_number
- 判断是否是数字
- 字符串反转
  
## 字符串反转(revert_string)
- 小写字母
- 字符串反转

## 句子逆序(revert_sentence)
- 正则表达式：句子，单词以空格分隔
- split string -> string[] 将句子按照空格分割成单词数组
- revert string[]
    - for loop
    - stream
    - guava and apache common
- string[] -> string 
    - Arrays.toString(intArray);
    - list stream to string
    - list to string: StringUtils.join(list, " ")
    - guava and apache common

## sort string lines
- test list equals
- sort
- array as list

## 求int型数据在内存中存储时1的个数(count 1 in binary number)
- count special char in a string
- decimal to binary
- input an integer

## 购物单(shopping list)
- 正则表达式：用空格分隔2到3个数字
- list倒序排序

## 坐标计算(coordinate)

## IP和子网掩码识别(ip identity)
- Predicate and or compose
- groupingby
- factory pattern

## 简单错误记录功能小模块(find_code_error)
- 解决groupingBy之后的map无序问题(主动声明linkedhashMap)
- 显示map最新的8条记录(用steam.skip)

## 密码验证
- 不能有相同长度大于2的子串重复

## 简单密码破解
string.chars() stream -> intstream -> string

## 删除字符串中出现次数最少的字符 
- 字符串变为字符串stream->Arrays.stream(input.split(""))
- map 按照value值 聚合key list

## 合唱队
- int array stream get index

## 数据分类处理
- 正则表达式：数字 空格
- 获取子数组

## 字符串排序 
- list to string
- string to list

#字符串加解密
- char to string

#字符串合并处理 
- ascii int to char -> (char) c
- hex to decimal
- decimal to binary
- binary to decimal
- decimal to hex

#单词倒排
- list 倒序
- list 按 空格 to string

#整数与IP地址间的转换
- stream string join
- 二进制，十进制转换
- IP format

#图片整理
- ASCII排序

#字符串加密
- 字符串字母去重
- map two list one as key and another as value

# 求小球落地5次后所经历的路程和第5次反弹的高度
- 按索引range stream遍历数组

# 学英语 
- 字符串用空格拼接

# 迷宫问题 
- string array to int array

# suduku
- 二维数组转一维数组
- 二维数组打印
- set去重

# 名字的漂亮度
- intstream groupingby integer
- map value sort and sum value with count--

# 查找组成一个偶数最接近的两个素数 
- min
- comparing

# 矩阵乘法
- 数组拷贝

#矩阵乘法计算量估算
- test assert throw exception
- string array to list
- 统计字数串中某个字符的个数
- 根据ascii当前字符获取下一个字符


