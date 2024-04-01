/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokeny;

/**
 * Własny skonstruowany wyjątek
 * @author Radosław Sawicki
 */
public class BladRekordu extends Exception{

    public BladRekordu() {
        super();
    }
    
    public BladRekordu(String err) {
        super(err);
    }
    
    
}
