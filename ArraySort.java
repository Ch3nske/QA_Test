/*
        На входе функция получает параметр n - натуральное число. Необходимо сгенерировать n-массивов,
        заполнить их случайными числами, каждый массив имеет случайный размер.
        Размеры массивов не должны совпадать. Далее необходимо отсортировать массивы.
        Массивы с четным порядковым номером отсортировать по возрастанию,
        с нечетным порядковым номером - по убыванию.
        На выходе функция должна вернуть массив с отсортированными массивами.
*/

import java.util.*;

public class ArraySort{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); //ввод n-го числа количества массивов
        int n = sc.nextInt();
        sc.close();
        List<List<Integer>> arrays = generateArrays(n);
        System.out.println("Исходные массивы:");
        printArrays(arrays);
        List<List<Integer>> sortedArrays = sortArrays(arrays);
        System.out.println("\nОтсортированные массивы:");
        printArrays(sortedArrays);
    }

    private static List<List<Integer>> generateArrays(int n){
        Random random = new Random();
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < n; i++){
            List<Integer> array = new ArrayList<>();
            //Не сказано по ТЗ насколько должнен быть случайный размер, поэтому поставлю условные 10
            int size = random.nextInt(10) + 1; // случайный размер от 1 до 10
            while (array.size() == size){
                size = random.nextInt(10) + 1;
            }
            for (int j = 0; j < size; j++){
                array.add(random.nextInt(100)); // случайные числа от 0 до 99
            }
            arrays.add(array);
        }
        return arrays;
    }
    private static List<List<Integer>> sortArrays(List<List<Integer>> arrays){
        List<List<Integer>> sortedArrays = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++){
            List<Integer> array = arrays.get(i);
            if (i % 2 == 0){
                Collections.sort(array);
            } else {
                array.sort(Collections.reverseOrder());
            }
            sortedArrays.add(array);
        }
        return sortedArrays;
    }
    private static void printArrays(List<List<Integer>> arrays){
        for (List<Integer> array : arrays){
            System.out.println(array);
        }
    }
}
