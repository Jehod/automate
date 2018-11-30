/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Outils;

import java.io.IOException;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.xml.XMLLayout;

/**
 *
 * @author nrochas
 */
public class Loggeur {

    private static Logger logger = Logger.getLogger(Loggeur.class);
    
    

    public static void testLog() {
        logger.debug("message de debug");
        logger.info("info message");
        logger.warn("warning message");
        logger.error("message d'erreur");
        logger.fatal("message fatal");

    }

    /**
     *
     * @param mess
     * @param prio
     * @return
     */
    public static boolean logMessage(String mess, int prio) {
        

        try {

            FileAppender fa = new FileAppender(new XMLLayout(), "log_automate.txt");

            fa.setName("automate_Log");

            logger.addAppender(fa);

        } catch (IOException e) {
            System.out.println("catch du logger : " + e.getMessage());
        }
        logger.setAdditivity(false);
        logger.debug(mess);
        
        return false;
    }

}
