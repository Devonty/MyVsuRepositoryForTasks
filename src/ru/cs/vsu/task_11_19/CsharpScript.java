package ru.cs.vsu.task_11_19;

import ru.cs.vsu.tools.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsharpScript {
    public static String getDataFromUser() {
        String filePath = "D:\\.JavaProjects\\HelloWorld\\src\\ru\\cs\\vsu\\task_11_19\\input\\input.txt", data = null;
        while (data == null) {
            System.out.println("Введите путь до файла:");
            filePath = new Scanner(System.in).nextLine();
            try {
                data = Utils.readFile(filePath);
                System.out.println("Успешное чтение файла!");
            } catch (Exception e) {
                System.out.println("Ошибка чтения файла!");
            }
        }
        return data;
    }

    public static List<String> parseVars(String data) {
        HashSet<String> vars = new HashSet<>();

        String regex = "[a-zA-Z][a-zA-Z0-9]*\\s*=";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            String matchedVar = data.substring(matcher.start(), matcher.end());
            String clearMatchedVar = matchedVar.substring(0, matchedVar.length() - 1).strip();
            System.out.println(clearMatchedVar);
            vars.add(clearMatchedVar);
        }
        return vars.stream().toList();
    }


    public static void main(String[] args) {
        String data = getDataFromUser();

        System.out.println("\nCODE---------------------------------\n");
        System.out.println(data);
        System.out.println("\nPARSING---------------------------------\n");

        List<String> vars = parseVars(data);
        for (String var : vars) {
            String regex = "%s\\s*=\\s*%s\\s*\\+\\s*1\\s*;";
            regex = String.format(regex, var, var);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(data);
            System.out.println(matcher.toString());
            data = matcher.replaceAll(String.format("%s++;", var));
        }
        System.out.println("\nFIXED---------------------------------\n");
        System.out.println(data);
    }


}
