SELECT customer_id, MAX(price) second_highest_price
FROM orders
WHERE order_id NOT IN (SELECT o1.order_id
                       FROM orders o1
                              JOIN (SELECT customer_id, MAX(price) max_price FROM orders GROUP BY customer_id) o2
                                   ON o1.customer_id = o2.customer_id AND o1.price = o2.max_price)
GROUP BY customer_id;