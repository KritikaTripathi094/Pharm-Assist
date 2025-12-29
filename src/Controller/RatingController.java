/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import dao.RatingDAO;

/**
 *
 * @author This PC
 */
public class RatingController {
    public boolean submitRating(int rating) {
        return RatingDAO.saveRating(rating);
    }
    
    
}
