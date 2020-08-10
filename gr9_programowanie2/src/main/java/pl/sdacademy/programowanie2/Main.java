package pl.sdacademy.programowanie2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;

public class Main {
    //tworzenie logow
    private static Logger logger = LogManager.getLogger(Main.class.getSimpleName());

    public static void main(String[] args) throws InterruptedException{
        logger.debug("Informacja startowa");
        try {
            int a = 7 / 0;
        } catch (Exception e){
            logger.debug("Błąd", e);
        }


    }
}
