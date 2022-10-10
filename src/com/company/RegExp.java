package com.company;

import java.io.*;
import java.util.regex.Pattern;
/**
 * ����� Main ��� ������� � ������������� � ������ ���������� � �������
 * � ������ Main ����������� ���������� try/catch
 *
 * @author �������� �����, ������ 21��35
 */
 class Main {
    public static void main(String[] args) throws Exception {
        String regExp = "\\d+\\s[+,\\-, *, %, /, ^]\\s\\d+"; //����� ��� ������ ����������� ���������
        double result = 0;
        String inputString;
        try (BufferedReader fr = new BufferedReader(new FileReader("src//input.txt"));
             BufferedWriter ad = new BufferedWriter(new FileWriter("src//output.txt"))) {

            while ((inputString = fr.readLine()) != null) {
//System.out.println(inputString);
                if ((inputString.trim().matches(regExp))) {
                    result = split(inputString.split(" "), result);
                    ad.write(result + "\n");
                    System.out.println(result);
                } else {
                    ad.write("" + "\n");
                    System.out.println("Input is not correct!");
                }
            }
        }
    }

    /**
     * ����� ��� ������ � �������� ������������� ������� � ������ � ��� ������ ��������
     *
     * @param array ������ ��� ������� ������ �� ��������, ����������� ��� ����������� ������ � ����
     * @param previousResult ���������� ����������� ���������� ���������
     * @return ���������� �������� ��� ����������� �� ����������� ������������� ������ calculate
     * @throws Exception ������������ ����������
     */
    private static double split(String[] array, double previousResult) throws Exception {
        String operand;
        double a;
        double b;
        if (array.length == 3) {
            a = Double.parseDouble(array[0]);
            operand = array[1];
            b = Double.parseDouble(array[2]);
            return calculate(a, b, operand);
        } else {
            throw new Exception("Input is not correct");
        }
    }

    /**
     * ����� ��� ���������� ������� ������� ������������
     *
     * @param a �������� 1
     * @param b �������� 2
     * @param operand ��������, ������� ������ ���� ��������� � ��������
     * @return ���������� ��������� ��������
     * @throws Exception ������������ ����������
     */
    private static double calculate(double a, double b, String operand) throws Exception {
        switch (operand) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "^":
                return Math.pow(a, b);
            case "%":
                return a % b;
            default:
                throw new Exception("Input is not correct");
        }
    }
}

