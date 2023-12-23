package restaurant;

public class Main {
}


/**
 *
 *
 *     USER APP
 *
 *     [Restaurant] APIs : /add, /delete, /add-menu
 *
 *     - id
 *     - name
 *     - location
 *     - Menu
 *
 *     [Menu]
 *     - Resturant_id
 *     - item
 *     - ItemType {STARTER, --- ,--,  }
 *
 *      [Discounts/Offers]  APIs: /add, /delete, /update
 *
 *      - id
 *      - Payment Gateway
 *      - expiry Time
 *      - Restaurant
 *
 *
 *      [Order]  APIs: /create, /delete, /update
 *
 *      - id
 *      - status
 *      - amount
 *      - User
 *      - Restaurant
 *      - Delivery Partner
 *
 *      [User] APIs : /register, /delete
 *
 *      - id
 *      - name
 *      - location
 *      - List<Order>
 *      - Cart
 *
 *      [Cart] APIs: /create, /update, /delete
 *
 *      - id
 *      - List<Menu>
 *
 *
 *      [Payment Gateway]
 *      - name
 *      - Payment Method
 *
 *
 *
 *
 *
 *     PARTNER APP :
 *
 *     [Delivery Boy]
 *     -id
 *     -name
 *     -List<Order>
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */