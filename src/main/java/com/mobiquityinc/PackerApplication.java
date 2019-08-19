package com.mobiquityinc;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.Packer;

public class PackerApplication {

    public static void main(String[] args){
        try {
            System.out.println(Packer.pack("testFile.txt"));
        } catch (APIException e) {
            e.printStackTrace();
        }
    }
}
