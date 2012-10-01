/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jbaldwin2
 */
public class Waiter {
    /**
     * Retrieves the menu item recommendations.
     * 
     * @param course - the course preference for the meal. NOTE: the course is
     * is validated in any way and a String is required.
     * @return a collection of menu items that are appropriate
     * for the preferred course.
     */
    public List getRecommends(String course) {
        List recommends = new ArrayList();
        
        if (course.equals("app")) {
             recommends.add("Rueben Rolls");
             recommends.add("Lamb Belly Risotto");
             
        } else if (course.equals("entree")) {
            recommends.add("Gouda & Kale Omelete");
            recommends.add("Corn Beef Hash");
            
        } else {
            recommends.add("Budweiser");
            recommends.add("Coffee");
        }

        return recommends;
    }
}
