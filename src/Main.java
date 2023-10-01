import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создаем объект класса Scanner для считывания текста из консоли
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String text = scanner.nextLine();
        scanner.close();

        // Разбиваем текст на предложения по знакам препинания с помощью метода split и регулярного выражения
        String[] sentences = text.split("[.!?]");

        // Создаем массивы символов для гласных и согласных букв
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        char[] consonants = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};
        // Для каждого предложения
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            // Сохраняем исходное предложение для вывода, обрезаем ненужные пробелы
            String originalSentence = sentence.trim();
            // Удаляем все пробелы из предложения и приводим его к нижнему регистру
            sentence = sentence.replaceAll(" ", "").toLowerCase();
            // Переменные для подсчёта количества гласных и согласных букв
            int vowelCount = 0;
            int consonantCount = 0;

            // Для каждого символа в предложении
            for (char c : sentence.toCharArray()) {
                // Проверяем, принадлежит ли он массиву гласных букв
                boolean isVowel = false;
                for (char v : vowels) {
                    if (c == v) {
                        isVowel = true;
                        break;
                    }
                }
                // Если да, то увеличиваем переменную vowelCount на единицу
                if (isVowel) {
                    vowelCount++;
                }
                else {
                    // Иначе проверяем, принадлежит ли он массиву согласных букв
                    for (char k : consonants) {
                        if (c == k) {
                            consonantCount++;
                            break;
                        }
                    }
                }
            }
            if (vowelCount > consonantCount) {
                System.out.println("В предложении " + (i + 1) + ": \"" + originalSentence + "\" больше гласных букв");
            }
            else if (vowelCount < consonantCount) {
                System.out.println("В предложении " + (i + 1) + ": \"" + originalSentence + "\" больше согласных букв");
            }
            else {
                System.out.println("В предложении " + (i + 1) + ": \"" + originalSentence + "\" одинаковое количество гласных и согласных букв");
            }
        }
    }
}