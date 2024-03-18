/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice.Advent;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author nikhilsultania
 */
public class prog9 {

    public static void main(String[] args) throws Exception {
        final List<String> lines = Files.readAllLines(Path.of("//Users//nikhilsultania//Downloads//data.txt"), StandardCharsets.UTF_8);

        long result = 0;

        for (final String line : lines) {
            final String[] temp = line.split("\s+");
            List<Long> values = new ArrayList<>(temp.length);
            for (final String s : temp) {
                values.add(Long.parseLong(s));
            }

            long partResult = 0;
            final Stack<Long> leftmostValues = new Stack<>();
            leftmostValues.push(values.get(0));

            boolean finished = false;
            while (!finished) {
                final List<Long> newValues = new ArrayList<>(values.size() - 1);
                boolean allZeros = true;

                for (int i = 0; i < values.size() - 1; i++) {
                    long sub = values.get(i + 1) - values.get(i);
                    if (sub != 0) {
                        allZeros = false;
                    }
                    newValues.add(sub);
                }

                leftmostValues.push(newValues.get(0));
                values = newValues;
                finished = allZeros;
            }

            while (!leftmostValues.empty()) {
                long val = leftmostValues.pop();
                partResult = val - partResult;
            }

            result += partResult;
        }

        System.out.println(result); // 1016
    }
}
