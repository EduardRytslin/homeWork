import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Arrays;

public class MainBook {
    public static void main(String[] args) {
        Set<NoteBook> noteBooks = new HashSet<>();
        noteBooks.add(new NoteBook("Apple", 6, 256, "MacOS", "Gold"));
        noteBooks.add(new NoteBook("Apple", 8, 512, "MacOS", "Silver"));
        noteBooks.add(new NoteBook("HP", 16, 1000, "Windows", "Black"));
        noteBooks.add(new NoteBook("Sony", 12, 720, "Windows", "White"));
        noteBooks.add(new NoteBook("Dell", 16, 1000, "Windows", "Black"));
        noteBooks.add(new NoteBook("Apple", 16, 512, "MacOS", "Rose Gold"));

        Map<String, Object> filters = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерии для фильтрации:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        System.out.println("0 - Завершить выбор");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Выбрать по мин. объёму ОЗУ");
                    filters.put("ramV", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Выбрать по мин. объёму жёсткого диска");
                    filters.put("hddV", scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Выбрать по ОС");
                    filters.put("os", scanner.next());
                    break;
                case 4:
                    System.out.println("Выбрать по цвету");
                    filters.put("colour", scanner.next());
                    break;
                case 5:
                    System.out.println("Выбрать по марке");
                    filters.put("brand", scanner.next());
                    break;
                default:
                    System.out.println("Ошибка ввода!");
            }
        }

        Set<NoteBook> filteredNoteBooks = noteBooks.stream()
                .filter(noteBook -> filters.getOrDefault("ramV", 0) instanceof Integer && noteBook.ramV >= (int) filters.getOrDefault("ramV", 0))
                .filter(noteBook -> filters.getOrDefault("hddV", 0) instanceof Integer && noteBook.hddV >= (int) filters.getOrDefault("hddV", 0))
                .filter(noteBook -> filters.getOrDefault("os", "").equals("") || noteBook.os.equalsIgnoreCase((String) filters.getOrDefault("os", "")))
                .filter(noteBook -> filters.getOrDefault("colour", "").equals("") || noteBook.colour.equalsIgnoreCase((String) filters.getOrDefault("colour", "")))
                .filter(noteBook -> filters.getOrDefault("brand", "").equals("") || noteBook.brand.equalsIgnoreCase((String) filters.getOrDefault("brand", "")))
                .collect(Collectors.toSet());

        System.out.println("Подходящие ноутбуки:");
        for (NoteBook noteBook : filteredNoteBooks) {
            System.out.println(noteBook);
        }

    }
}

