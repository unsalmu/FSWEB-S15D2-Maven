package org.example;

import org.example.entity.*;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 1) Her çalışanın kendi görev seti:
        Set<Task> annsTasks = new HashSet<>();
        Task taskAnn = new Task("Projex", "Login modülü", "ann", Priority.HIGH,   Status.IN_PROGRESS);
        Task taskAnn2 = new Task("Projex", "Profil sayfası", "ann", Priority.MED,    Status.ASSIGNED);
        annsTasks.add(taskAnn);
        annsTasks.add(taskAnn2);

        Set<Task> bobTasks = new HashSet<>();
        bobTasks.add(new Task("Projex", "Veritabanı tasarımı", "bob", Priority.HIGH, Status.ASSIGNED));

        Set<Task> carolTasks = new HashSet<>();
        carolTasks.add(new Task("Projex", "API dokümantasyonu", "carol", Priority.LOW, Status.IN_QUEUE));

        // 2) Henüz atanmamış diğer görevler:
        Set<Task> unassignedTasks = new HashSet<>();
        unassignedTasks.add(new Task("Projex", "Deploy ortamı kurulum", null, Priority.MED, Status.IN_QUEUE));

        // 3) TaskData nesnesini oluştur:
        TaskData data = new TaskData(annsTasks, bobTasks, carolTasks, unassignedTasks);

        // 4) Bireysel olarak çekmek:
        System.out.println("=== Ann'in Görevleri ===");
        data.getTasks("ann").forEach(t ->
                System.out.println("- " + t.getDescription() + " [" + t.getStatus() + "]")
        );

        System.out.println("\n=== Bob'un Görevleri ===");
        data.getTasks("bob").forEach(t ->
                System.out.println("- " + t.getDescription() + " [" + t.getStatus() + "]")
        );

        System.out.println("\n=== Carol'un Görevleri ===");
        data.getTasks("carol").forEach(t ->
                System.out.println("- " + t.getDescription() + " [" + t.getStatus() + "]")
        );

        // 5) Tüm görevleri birleştirerek raporlamak:
        System.out.println("\n=== Hepsi (Müdür Raporu) ===");
        data.getTasks("all").forEach(t ->
                System.out.println(
                        "- " + t.getAssignee()  + ": " +
                                t.getDescription()     + " (" + t.getPriority() + ")"
                )
        );
        TaskData taskData = new TaskData(annsTasks, bobTasks, carolTasks, unassignedTasks);
        System.out.println("bobstasks: " + taskData.getTasks("bob"));
        System.out.println("annstasks: " + taskData.getTasks("ann"));
        System.out.println("alltasks: " + taskData.getTasks("all"));


        StringSet.findUniqueWords();




    }
}