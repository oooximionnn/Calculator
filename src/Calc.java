import java.util.Locale;
import java.util.Arrays;
class Calc {
    public static String calc(String input) {
        String redactString = input.toUpperCase().replaceAll(" ", "");
        try {  // проверка на пустоту строки
            if (redactString.isEmpty()) throw new Exception("Строка не должна быть пустой");
            if (redactString == null) throw new Exception("Строка не должна быть пустой");
        } catch (Exception exepti) {
            System.out.println(exepti.getMessage());
            return "";
        }

        char[] checkString = redactString.toCharArray(); // разбиваем строку на массив символов, чтобы проверить
        //нет ли двух операторов
        int countOfOperators = 0;
        for (char charik : checkString) {
            if (charik == '+' || charik == '-' || charik == '*' || charik == '/') {
                countOfOperators++;
            }
        }

        try { // проверка на несколько операторов
            if (countOfOperators > 1) throw new Exception("Не д.б. больше двух чисел");
        } catch (Exception exxe) {
            System.out.println(exxe.getMessage());
            return "";
        }

        try { // проверка на отсутствие оператора и количество чисел соответственно
            if (redactString.indexOf("+") == -1 && redactString.indexOf("-") == -1 &&
                    redactString.indexOf("*") == -1 && redactString.indexOf("/") == -1)
                throw new Exception("Запустите программу заново, введите оператор");
        } catch (Exception exepti) {
            System.out.println(exepti.getMessage());
            return "";
        }


        int count = 0; // для подсчета количества операторов
        int a = 0;
        int b = 0;
        String[] romeArray = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabArray = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        int romeResult = 0;
        String romeAnswer = "";
        int arabicAnswer = 0;
        String operandOne = "";
        String operandTwo = "";
        // определение первого операнда
        if (redactString.indexOf("+") > -1) {
            operandOne = redactString.substring(0, redactString.indexOf("+"));
        }
        if (redactString.indexOf("-") > -1) {
            operandOne = redactString.substring(0, redactString.indexOf("-"));
        }
        if (redactString.indexOf("*") > -1) {
            operandOne = redactString.substring(0, redactString.indexOf("*"));
        }
        if (redactString.indexOf("/") > -1) {
            operandOne = redactString.substring(0, redactString.indexOf("/"));
        }
        //определение второго операнда
        if (redactString.indexOf("+") > -1) {
            operandTwo = redactString.substring(redactString.indexOf("+") + 1);
        }
        if (redactString.indexOf("-") > -1) {
            operandTwo = redactString.substring(redactString.indexOf("-") + 1);
        }
        if (redactString.indexOf("*") > -1) {
            operandTwo = redactString.substring(redactString.indexOf("*") + 1);
        }
        if (redactString.indexOf("/") > -1) {
            operandTwo = redactString.substring(redactString.indexOf("/") + 1);
        }


        try { // исключение ввода разных цифр
            for (String c : romeArray) {
                for (String n : arabArray) {
                    if (c.equals(operandOne) && n.equals(operandTwo) ||
                            n.equals(operandOne) && c.equals(operandTwo))
                        throw new Exception("Оба числа должны быть римскими либо арабскими");
                }
            }
        } catch (Exception exep) {
            System.out.println(exep.getMessage());
            return "";
        }

        // диапазон вводимых чисел должен быть от 1 до 10
        int countNumb = 0;
        for (int couun = 0; couun < romeArray.length; couun++) {
            if (romeArray[couun].equals(operandOne)) {
                countNumb++;
            }
            if (romeArray[couun].equals(operandTwo)) {
                countNumb++;
            }
        }

        for (int couunn = 0; couunn < arabArray.length; couunn++) {
            if (arabArray[couunn].equals(operandOne)) {
                countNumb++;
            }
            if (arabArray[couunn].equals(operandTwo)) {
                countNumb++;
            }
        }

        try {
            if (countNumb < 2) throw new Exception("Диапазон вводимых чисел должен быть от 1 до 10 или от I до X");
        } catch (Exception eeexx) {
            System.out.println(eeexx.getMessage());
            return "";
        }


        for (int counter = 0; counter < romeArray.length; counter++) {
            if (operandOne.equals(romeArray[counter])) {
                a = counter + 1;
            }
            if (operandTwo.equals(romeArray[counter])) {
                b = counter + 1;
            }
        }

        String one = "I";
        String two = "II";
        String three = "III";
        String four = "IV";
        String five = "V";
        String six = "VI";
        String seven = "VII";
        String eight = "VIII";
        String nine = "IX";
        String ten = "X";
        // проверка является ли первый и второй операнд римскими числами
        if ((redactString.startsWith(one) || redactString.startsWith(two) || redactString.startsWith(three) ||
                redactString.startsWith(four) || redactString.startsWith(five) || redactString.startsWith(six) ||
        redactString.startsWith(seven) || redactString.startsWith(eight) || redactString.startsWith(nine)) &&
        redactString.endsWith(one) || redactString.endsWith(two) || redactString.endsWith(three) ||
                redactString.endsWith(four) || redactString.endsWith(five) || redactString.endsWith(six)
                || redactString.endsWith(seven) || redactString.endsWith(eight) || redactString.endsWith(nine)
                || redactString.endsWith(ten)) {

            if (redactString.indexOf('+') >= 0) {
                romeResult = (a + b);
            }
            if (redactString.indexOf('-') >= 0) {
                romeResult = (a - b);
            }
            if (redactString.indexOf('*') >= 0) {
                romeResult = (a * b);
            }
            if (redactString.indexOf('/') >= 0) {
                romeResult = (a / b);
            }

            try {
                if (romeResult == 0) throw new Exception("в римской системе нет нуля");
                if (romeResult < 0) throw new Exception("в римской системе нет отрицательных чисел");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                return "";
            }

            // перевод арабского числа в римское
            if (romeResult >= 1 && romeResult < 10) {
                return romeArray[romeResult - 1];
            } if (romeResult > 10 && romeResult < 20) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "X" + romeArray[romeResult - 1];
            } if (romeResult > 20 && romeResult < 30) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "XX" + romeArray[romeResult - 1];
            } if (romeResult > 30 && romeResult < 40) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "XXX" + romeArray[romeResult - 1];
            } if (romeResult > 40 && romeResult < 50) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "XL" + romeArray[romeResult - 1];
            } if (romeResult > 50 && romeResult < 60) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "L" + romeArray[romeResult - 1];
            } if (romeResult > 60 && romeResult < 70) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "LX" + romeArray[romeResult - 1];
            } if (romeResult > 70 && romeResult < 80) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "LXX" + romeArray[romeResult - 1];
            } if (romeResult > 80 && romeResult < 90) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "LXXX" + romeArray[romeResult - 1];
            } if (romeResult > 90 && romeResult < 100) {
                romeAnswer = Integer.toString(romeResult).substring(Integer.toString(romeResult).length() - 1);
                romeResult = Integer.parseInt(romeAnswer);
                return "XC" + romeArray[romeResult - 1];


            } if (romeResult == 100) {
                return "C";
            } if (romeResult == 90) {
                return "XC";
            } if (romeResult == 80) {
                return "LXXX";
            } if (romeResult == 70) {
                return "LXX";
            } if (romeResult == 60) {
                return "LX";
            } if (romeResult == 50) {
                return "L";
            } if (romeResult == 40) {
                return "XL";
            } if (romeResult == 30) {
                return "XXX";
            } if (romeResult == 20) {
                return "XX";
            } if (romeResult == 10) {
                return "X";
            }


        } else { // если числа не римские


            try {
                if (Integer.parseInt(operandOne) > 10 ||
                        Integer.parseInt(operandOne) < 1 ||
                        Integer.parseInt(operandTwo) > 10 ||
                        Integer.parseInt(operandTwo) < 1 )
                    throw new Exception("Вводимые числа не д.б. меньше 1 или больше 10");
            } catch (Exception exxx) {
                System.out.println(exxx.getMessage());
                return "";
            }

            for (int count1 = 0; count1 < 11; count1++) {
                if (redactString.startsWith(Integer.toString(count1))) {
                    a = count1;
                }
                if (redactString.endsWith(Integer.toString(count1))) {
                    b = count1;
                }

            }
            if (redactString.indexOf('+') >= 0) {
                arabicAnswer = a + b;
            }
            if (redactString.indexOf('-') >= 0) {
                arabicAnswer = a - b;
            }
            if (redactString.indexOf('*') >= 0) {
                arabicAnswer = a * b;
            }
            if (redactString.indexOf('/') >= 0) {
                arabicAnswer = a / b;
            }
            return Integer.toString(arabicAnswer);
        }
        return  redactString;
    }
}
