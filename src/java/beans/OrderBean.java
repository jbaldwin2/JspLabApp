/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.OrderService;

/**
 *
 * @author jbaldwin2
 */
@ManagedBean
@RequestScoped
public class OrderBean implements Serializable{
    private OrderService orderService;
	private final boolean DEBUG = false;
    /**
     * Creates a new instance of OrderBean
     */
    public OrderBean() {
    }
}
