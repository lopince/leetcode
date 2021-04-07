package com.leetcode.solution;

import java.util.*;

public class EvaluateDivision {

    private static class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

            Set<String> elements = new HashSet<>();
            Map<List<String>, Double> equationsMap = new HashMap<>();
            for (int i = 0; i < equations.size(); i++) {

                List<String> equation = equations.get(i);

                elements.addAll(equation);
                equationsMap.put(equation, values[i]);
            }

            double[] anss = new double[queries.size()];
            for (int i = 0; i < queries.size(); i++) {

                List<String> query = queries.get(i);
                String qDividend = query.get(0);
                String qDivisor = query.get(1);

                Double ans = null;

                if (qDividend.equals(qDivisor) && elements.contains(qDividend)) {
                    ans = 1.0;

                } else {
                    for (Map.Entry<List<String>, Double> entry : equationsMap.entrySet()) {

                        List<String> equation = entry.getKey();
                        String eDividend = equation.get(0);
                        String eDivisor = equation.get(1);

                        Double val = entry.getValue();

                        List<String> reverseEquation = new ArrayList<>(equation);
                        Collections.reverse(reverseEquation);

                        if (query.equals(reverseEquation)) {
                            ans = (1 / val);

                        } else if (qDividend.equals(eDividend)) {
                            HashMap<List<String>, Double> tempMap = new HashMap<>(equationsMap);
                            tempMap.remove(equation);

                            ans = dfs(tempMap, equation, qDivisor, val);

                        } else if (qDividend.equals(eDivisor)){

                            HashMap<List<String>, Double> tempMap = new HashMap<>(equationsMap);
                            tempMap.remove(equation);

                            ans = dfs(tempMap, reverseEquation, qDivisor, (1/val));
                        }

                        if (ans != null) {
                            break;
                        }
                    }
                }

                if (ans != null) {
//                    equationsMap.put(curQuery, ans);
                    anss[i] = ans;
                } else {
                    anss[i] = -1.0;
                }
            }

            return anss;
        }

        // [a, c] ==> [a, b] -> [b, c]
        public Double dfs(Map<List<String>, Double> equationsMap, List<String> query, String targetDivisor, Double ans) {

            String divisor = query.get(1);

            if (targetDivisor.equals(divisor)) {
                return ans;
            }

            for (Map.Entry<List<String>, Double> equation : equationsMap.entrySet()) {

                List<String> curE = equation.getKey();
                String curDividend = curE.get(0);
                String curDivisor = curE.get(1);

                Double curVal = equation.getValue();

                if (divisor.equals(curDivisor)) {

                    HashMap<List<String>, Double> temp = new HashMap<>(equationsMap);
                    temp.remove(curE);

                    curVal = ans / curVal;
                    Double curAns = dfs(temp, newList(curDivisor, curDividend), targetDivisor, curVal);
                    if (curAns != null) {
                        return curAns;
                    }

                    equationsMap.put(curE, curVal);

                } else if (divisor.equals(curDividend)) {

                    HashMap<List<String>, Double> temp = new HashMap<>(equationsMap);
                    temp.remove(curE);

                    curVal = ans / (1 / curVal);
                    Double curAns = dfs(temp, newList(curDividend, curDivisor), targetDivisor, curVal);
                    if (curAns != null) {
                        return curAns;
                    }

                    equationsMap.put(curE, curVal);
                }
            }

            return null;
        }

        public <T> List<T> newList(T... ts) {

            List<T> l = new ArrayList<>();

            if (ts.length > 0) {
                Collections.addAll(l, ts);
            }

            return l;
        }
    }
}
