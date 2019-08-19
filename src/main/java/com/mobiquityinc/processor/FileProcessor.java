package com.mobiquityinc.processor;

import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.TextLine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {

    public static List<TextLine> init(String path) throws IOException {
        List<TextLine> lines = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] weightAndItems = line.split(":");
            BigDecimal weightLimit = new BigDecimal(weightAndItems[0].trim());
            String[] stringItems = weightAndItems[1].trim().split(" ");
            List<Item> items = new ArrayList<>();
            for (String stringItem : stringItems) {
                String[] itemDetails = stringItem.split(",");
                int index = Integer.parseInt(itemDetails[0].substring(1));
                BigDecimal weight = new BigDecimal(itemDetails[1]);
                BigDecimal cost = new BigDecimal(itemDetails[2].substring(1, itemDetails[2].length() - 1));
                items.add(new Item(index, weight, cost));
            }
            TextLine textLine = new TextLine();
            textLine.setItems(items);
            textLine.setMaxWeight(weightLimit);
            lines.add(textLine);
            line = bufferedReader.readLine();
        }
        return lines;
    }
}
