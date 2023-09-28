
public class Perevod {
    public boolean isNumeric(String strNum) { // Проверяет int ли переменная. Если int вернет true
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public int perevi(String a) { // перводит Стринг в инт. Возвращает инт

        String[] rimskChisl = new String[10];
        rimskChisl[0] = "I";
        rimskChisl[1] = "II";
        rimskChisl[2] = "III";
        rimskChisl[3] = "IV";
        rimskChisl[4] = "V";
        rimskChisl[5] = "VI";
        rimskChisl[6] = "VII";
        rimskChisl[7] = "VIII";
        rimskChisl[8] = "IX";
        rimskChisl[9] = "X";

        int x = 0;
        for (int i = 0; i < rimskChisl.length; i++) {
            if (rimskChisl[i].equals(a)) {
                x = i + 1;
            }
        }
        return x; // вернуть х
    }

    public String convertResultToRoman(int summ) { // Конвертирует результат в Стринг
        String rezultat1 = null;
        String rezultat2 = null;
        String[] rimskRezult = new String[11];
        rimskRezult[0] = "O";
        rimskRezult[1] = "I";
        rimskRezult[2] = "II";
        rimskRezult[3] = "III";
        rimskRezult[4] = "IV";
        rimskRezult[5] = "V";
        rimskRezult[6] = "VI";
        rimskRezult[7] = "VII";
        rimskRezult[8] = "VIII";
        rimskRezult[9] = "IX";
        rimskRezult[10] = "X";
        if (summ<10){
            for(int i = 0; i < rimskRezult.length; i ++){
                if (i == summ) {
                    rezultat2 = rimskRezult[i];
                }
            }
        }

        if (summ > 10 || summ < 100) {
            int y = summ % 10;
            int x = summ - y;
            for(int i = 0; i < rimskRezult.length; i ++) {
                if (i == y) {
                    rezultat1 = rimskRezult[i];
                }
                if (x == 10) {
                    rezultat2 = "X"+rezultat1;
                }
                if (x == 20) {
                    rezultat2 = "XX"+rezultat1;
                }
                if (x == 30) {
                    rezultat2 = "XXX"+rezultat1;
                }
                if (x == 40) {
                    rezultat2 = "XL"+rezultat1;
                }
                if (x == 50) {
                    rezultat2 = "L"+rezultat1;
                }
                if (x == 60) {
                    rezultat2 = "LX"+rezultat1;
                }
                if (x == 70) {
                    rezultat2 = "LXX"+rezultat1;
                }
                if (x == 80) {
                    rezultat2 = "LXXX"+rezultat1;
                }
                if (x == 90) {
                    rezultat2 = "XC"+rezultat1;
                }
                if (x == 100) {
                    rezultat2 = "C";
                }
            }
        }
        return rezultat2;
    }


    public String sum(String a, String b, char c) throws Exception {

        String otvet = null;
        if(isNumeric(a) & !isNumeric(b)) throw new Exception("Используются одновременно разные системы счисления"); // Проверка исключений
        if(!isNumeric(a) & isNumeric(b)) throw new Exception("Используются одновременно разные системы счисления");

        int d = 0;
        int e = 0;
        if (!isNumeric(a) || !isNumeric(b)) {
            d = perevi(a);
            e = perevi(b);
            if (d < e & c == '-') throw new Exception("В римской системе нет отрицательных чисел");
            if (d < 1 || d > 10) throw new Exception("Введенное число находится за приделами диапозона допустимых значений");
            if (e < 1 || e > 10) throw new Exception("Введенное число находится за приделами диапозона допустимых значений");

            switch (c) {
                case ('+'):
                    otvet = ("Сумма чисел равна " + convertResultToRoman(d + e));
                    break;
                case ('-'):
                    otvet = ("Разность чисел равна " + convertResultToRoman(d - e));
                    break;
                case ('*'):
                    otvet = ("Произведение чисел равно " + convertResultToRoman(d * e));
                    break;
                case ('/'):
                    otvet = ("Частное чисел равно " + convertResultToRoman(d / e));
                    break;
            }
        }
        if (isNumeric(a) || isNumeric(b)) {
            int d1 = Integer.parseInt(a);
            int e1 = Integer.parseInt(b);
            if (d1 < 1 || d1 > 10) throw new Exception("Введенное число находится за приделами диапозона допустимых значений");
            if (e1 < 1 || e1 > 10) throw new Exception("Введенное число находится за приделами диапозона допустимых значений");

            switch (c) {
                case ('+'):
                    otvet = ("Сумма чисел равна " + (d1 + e1));
                    break;
                case ('-'):
                    otvet = ("Разность чисел равна " + (d1 - e1));
                    break;
                case ('*'):
                    otvet = ("Произведение чисел равно " + (d1 * e1));
                    break;
                case ('/'):
                    otvet = ("Частное чисел равно " + (d1 / e1));
                    break;
            }
        }
        return otvet;
    }
}


