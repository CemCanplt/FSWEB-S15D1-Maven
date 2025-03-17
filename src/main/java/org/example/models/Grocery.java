package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nLütfen bir seçenek giriniz: ");
            System.out.println("0 - Uygulamayı Durdur");
            System.out.println("1 - Eleman Ekle");
            System.out.println("2 - Eleman Çıkar");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter tuşunu temizlemek için

            switch (choice) {
                case 0:
                    isRunning = false;
                    System.out.println("Uygulama durduruldu.");
                    break;
                case 1:
                    System.out.println("Eklemek istediğiniz eleman(lar): (virgülle ayırabilirsiniz)");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.println("Çıkarmak istediğiniz eleman(lar): (virgülle ayırabilirsiniz)");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız, tekrar deneyiniz.");
            }

            printSorted();
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!groceryList.contains(item)) {
                groceryList.add(item);
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList); // Listeyi sıralar
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        Collections.sort(groceryList); // Listeyi sıralar
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        System.out.println("Güncellenmiş Liste: " + groceryList);
    }
}
