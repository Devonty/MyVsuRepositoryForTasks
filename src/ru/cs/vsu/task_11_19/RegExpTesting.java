package ru.cs.vsu.task_11_19;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTesting {
    public static void main(String[] args) {
        List<String> data = new ArrayList<>();
        String variableName = "counter1";
        data.add(String.format("%s=%s+1;", variableName, variableName));
        data.add(String.format("%s = %s + 1;", variableName, variableName));
        data.add(String.format("%s  =  %s  +  1;", variableName, variableName));
        data.add(String.format("%s=%s + 1;", variableName, variableName));
        data.add(String.format("notSameName=%s+1   ;", variableName, variableName));
        data.add(String.format("%s=%s+1   ;", variableName, variableName));
        data.add(String.format("            %s   =  %s+ 1  ;", variableName, variableName));
        data.add(String.format("%s   =  %s+ 1  ;", variableName, variableName));

        for(String line : data){
            String regex = "%s\\s*=\\s*%s\\s*\\+\\s*1\\s*;";
            regex = String.format(regex, variableName, variableName);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);
            System.out.println(line +" : "+ matcher.matches());
        }
    }

}
