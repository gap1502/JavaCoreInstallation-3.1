package JavaCore_3_1;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> catalogList = Arrays.asList(
                new File("C://Games"),
                new File("C://Games//temp"),
                new File("C://Games//src"),
                new File("C://Games//res"),
                new File("C://Games//savegames"),
                new File("C://Games//src//main"),
                new File("C://Games//src//test"),
                new File("C://Games//res//drawables"),
                new File("C://Games//res//vectors"),
                new File("C://Games//res//icons")
        );

        catalogList.forEach(catalog -> {
            if (catalog.mkdir())
                sb.append("Создан каталог ")
                        .append(catalog)
                        .append(" \n");
            else
                sb.append("Каталог не создан ")
                        .append(catalog)
                        .append(" \n");
        });

        List<File> filesList = Arrays.asList(
                new File("C://Games//src//main//Main.java"),
                new File("C://Games//src//main//Utils.java"),
                new File("C://Games//temp//temp.txt")
        );

        for (File files : filesList) {
            try {
                if (files.createNewFile())
                    sb.append("Файл создан ")
                            .append(files)
                            .append(" \n");
                else
                    sb.append("Файл не создан ")
                            .append(files)
                            .append(" \n");
            } catch (IOException ex) {
                sb.append(ex.getMessage())
                        .append(" \n");
            }
        }

        try (FileWriter writer = new FileWriter("C://Games//temp//temp.txt", false)) {
            writer.write(sb.toString());
        } catch (IOException ex) {
            sb.append(ex.getMessage())
                    .append(" \n");
        }
        System.out.println(sb.toString());
    }
}


