package com.mobiquityinc.packer;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.model.Package;
import com.mobiquityinc.model.Item;
import com.mobiquityinc.model.TextLine;
import com.mobiquityinc.processor.FileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Packer {

  private Packer() {
  }

  public static String pack(String filePath) throws APIException {
    StringBuilder result = new StringBuilder();
    try {
      List<TextLine> textLines = FileProcessor.init(filePath);

      for (TextLine textLine : textLines) {
        List<Package> packages = buildCombinationSet(textLine.getItems(), textLine.getMaxWeight());

        packages.sort((p1, p2) -> {
          if (p2.totalCost().compareTo(p1.totalCost()) == 0) {
            return p2.totalWeight().compareTo(p1.totalWeight());
          }
          return p2.totalCost().compareTo(p1.totalCost());
        });

        if (packages.size() > 0){
          result.append(packages.get(0).toString());
        }else{
          result.append("-\n");
        }
      }

    } catch (IOException e) {
        throw new APIException(e.getMessage());
    }
    return result.toString();
  }

  private static List<Package> buildCombinationSet(List<Item> itemList, BigDecimal maxWeight) {
    int totalCombinations = (int) Math.pow(2, itemList.size());
    List<Package> allCombinations = new ArrayList<>();
    for (int i = 0; i < totalCombinations; i++) {
      Package combination = new Package();
      combination.setMaxWeight(maxWeight);
      for (int j = 0; j < itemList.size(); j++) {

        if ((i & (1 << j)) != 0) {
          combination.getItems().add(itemList.get(j));
        }
      }
      if (combination.getItems().size() != 0 && combination.getMaxWeight().compareTo(combination.totalWeight()) > 0){
        allCombinations.add(combination);
      }

    }
    return allCombinations;
  }

}
