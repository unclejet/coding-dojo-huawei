package com.uj.study.sort_score;

import com.uj.study.common.input.LineReader;
import com.uj.study.common.input.ValidLineReader;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：UncleJet
 * @date ：Created in 2024/2/5 下午12:49
 * @description：
 */
public class ScoreSorterUserInputReader {
    private StudentNumberReader studentNumberReader;
    private SortOrderReader sortOrderReader;
    private StudentReader studentReader;

    public ScoreSorterUserInputReader(LineReader lineReader) {
        studentNumberReader = new StudentNumberReader(lineReader);
        sortOrderReader = new SortOrderReader(lineReader);
        studentReader = new StudentReader(lineReader);
    }


    public int readStudentNumber() {
        return studentNumberReader.read();
    }

    public SortOrder readSortOrder() {
        return sortOrderReader.read();
    }

    public List<Student> readStudents(int number) {
        return studentReader.read(number);
    }

    class StudentNumberReader extends ValidLineReader {
        public StudentNumberReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            if (isInteger(line)) {
                int n = getInteger(line);
                return n >= 1 && n <= 200;
            }
            return false;
        }

        int read() {
            String line = readValidLine("Please input student number between 1 and 200: ");
            return getInteger(line);
        }
    }

    class SortOrderReader extends ValidLineReader {
        public SortOrderReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            return "0".equals(line) || "1".equals(line);
        }

        SortOrder read() {
            String line = readValidLine("please input 0 or 1 means DESC or ASC:");
            return "0".equals(line) ? SortOrder.DESC : SortOrder.ASC;
        }
    }

    class StudentReader extends ValidLineReader {

        public StudentReader(LineReader lineReader) {
            super(lineReader);
        }

        @Override
        protected boolean isValidString(String line) {
            String[] arr = line.split("\\s");
            return arr.length == 2 && isInteger(arr[1]);
        }

        List<Student> read(int number) {
            List<Student> result = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                String line = readValidLine("please input student name and score like: student1 50");
                result.add(new Student(line));
            }
            return result;
        }
    }
}
