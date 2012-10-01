package model;

import java.util.*;

/**
 * This service class decouples the controller code from the data access code.
 * The advantage is that we can change what we access without breaking anything.
 * For example, here we can switch between production and development databases.
 *
 * @author jlombardo
 */
public class OrderService {

    private List<MenuItem> menuList;
    private List<MenuItem> orderList;
    private IOrderDAO orderDao;

    public OrderService() {
        initItemsDb();
    }

    private void initItemsDb() {
        orderDao = new OrderDAODev();
        menuList = orderDao.getCurrentMenuChoices();
        orderList = new ArrayList<MenuItem>();
    }

    public void placeOrder() {
        orderDao.saveOrder(orderList);
    }

    public List<MenuItem> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuItem> menuList) {
        this.menuList = menuList;
    }

    public List<MenuItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<MenuItem> orderList) {
        this.orderList = orderList;
    }

    public IOrderDAO getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(IOrderDAO orderDao) {
        this.orderDao = orderDao;
    }
}
