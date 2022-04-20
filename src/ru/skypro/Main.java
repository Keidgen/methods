package ru.skypro;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    public static void task1() {
        defineYearIsLeap(1988);
    }

    public static void task2() {
        defineVersionOS(0, 2015);
    }

    public static void task3() {
        int countDay = defineCntDayDelivery(95);
        System.out.println("Потребуется дней для доставки карты: " + countDay);
    }

    public static void task4() {
        defineIsDouble("aabccddefgghiijjkk");
    }

    public static void task5() {
        reverseArray(new int[]{3, 2, 1, 6, 5});
    }

    public static void defineYearIsLeap(int year) {
        if ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0)){
            System.out.println(year + " високосный год");
        } else System.out.println(year + " не високосный год");
    }

    public static void defineVersionOS(int clientOS, int clientDeviceYear){
        int currentYear = LocalDate.now().getYear();
        if (clientDeviceYear >= currentYear){
            if (clientOS == 0){
                System.out.println("Установите версию приложения для iOS по ссылке");
            }  else System.out.println("Установите версию приложения для Android по ссылке");
        } else if (clientOS == 0){
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }  else System.out.println("Установите облегченную версию приложения для Android по ссылке");
    }

    public static int defineCntDayDelivery(int deliveryDistance) {
        int countDay = 1;
        if (deliveryDistance > 100) {
            throw new RuntimeException("Введено некорректное значение. Значения больше 100 не поддерживаются");
        }
        if (deliveryDistance <= 60 && deliveryDistance >= 20){
            countDay++;
        } else if (deliveryDistance <=100){
            countDay = countDay + 2;
        }
        return countDay;
    }

    public static void defineIsDouble(String str) {
        int idx8 = 0;
        boolean isNotDouble = true;
        char sd = ' ';
        StringBuilder sb = new StringBuilder(str);

        for (int num = 0; sb.length() > num; num++){
            while(isNotDouble){
                if (idx8+num == sb.length()) {
                    break;
                };

                if (sb.charAt(num) == sb.charAt(num+idx8) && idx8 != 0){
                    isNotDouble = false;
                    sd = sb.charAt(num);
                    break;
                }
                idx8++;
            }
            if (!isNotDouble){
                break;
            }
            idx8 = 0;
        }
        if (sd != ' '){
            System.out.println("В строке присутствует дубль - " + sd);
        } else System.out.println("Дубли отсутствуют");

    }

    public static void reverseArray(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++)
        {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }

        System.out.println(Arrays.toString(arr));

    }
}