package com.company;

        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

/**
 * ����������� RegExp ������� ������ ����������� ��������� ��� ������������� ������ � ��������
 * � RegExp ����������� ����� ����������, ��� - try/catch
 *
 * @autor �������� �����, ������ 21��35
 */
public class RegExp {
    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("\\d+\\s[+\\-*%/^]\\s\\d+"); //����� ��� ������ ����������� ���������
        Matcher m; //���������� ��������������� �������, ���� �� �������� ���������� � ��������
        double result = 0;
        System.out.println("������� ������: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
                    m = p.matcher(inputString);
                    if (m.find()) {
                        result = split(inputString.split(" "), result);
                        System.out.println(result);
                    } else {
                        System.out.println("���� �� ���������!");
                    }
                    return;

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ����� ��� ������ � �������� ������������� ������� � ������ � ��� ������ ��������
     * @param array - ������ ��� ���������� ������ �� ��������
     * @param previousResult - ����������, ������� ��������� ���������� ���������
     * @return - ������������ ��� ���������� ������ �������� �� ������ calculate
     * @throws Exception - ������������ ����������
     */
    private static double split(String[] array, double previousResult) throws Exception {
        String operand;
        double number1;
        double number2;
        if (array.length == 3) {
            number1 = Double.parseDouble(array[0]);
            operand = array[1];
            number2 = Double.parseDouble(array[2]);
            return calculate(number1, number2, operand);
        } else {
            throw new Exception("���� �� ���������");
        }
    }

    /**
     * ����� ��� ���������� ������� ������� ������������
     * @param number1 - �������� 1
     * @param number2 - �������� 2
     * @param operand - ��������, ������� ������ ���� ��������� � ��������
     * @return - ��� ����������� ���������� ��������
     * @throws Exception - ��� ��������� ����������
     */
    private static double calculate(double number1, double number2, String operand) throws Exception {
        return switch (operand) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            case "^" -> Math.pow(number1, number2);
            case "%" -> number1 % number2;
            default -> throw new Exception("���� �� ���������");
        };
    }
}
