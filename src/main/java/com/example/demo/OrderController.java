package com.example.demo;

import com.example.demo.LogInSignUp.UserService;
import com.example.demo.Orders.*;
import com.example.demo.Orders.Dish.Dish;
import com.example.demo.Orders.Order.Order;
import com.example.demo.Orders.Order_dish.Order_dish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Controller
public class OrderController {

    private boolean started = false;

    private final UserService userService;

    private final Service<Dish> dishService;

    private final Service<Order> orderService;

    private final Service<Order_dish> order_dishService;

    @Autowired
    public OrderController(Service<Dish> dish, Service<Order> order, Service<Order_dish> order_dish, UserService userService) {
        this.dishService = dish;
        this.order_dishService = order_dish;
        this.orderService = order;
        this.userService = userService;
    }

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest request) {
        System.out.println("get in 1");
        var order = request.getOrder();
        System.out.println("get in 2");

        var dishes = dishService.readAll();
        System.out.println("get in 3");
        var allOrders = orderService.readAll();
        System.out.println("get in 4");
        for (var dish : order) {
            var d = dishService.read(dish.getId());
            if (d.getName().equals("")) {
                return new ResponseEntity<>("Contains dishes not in menu", HttpStatus.BAD_REQUEST);
            }
            if (dishService.read(dish.getId()).getQuantity() == 0) {
                return new ResponseEntity<>("Dish: " + dishService.read(dish.getId()).getName() + " dont have quantity", HttpStatus.BAD_REQUEST);
            }
        }
        System.out.println("get in 3");
        var date = new Date();
        Order order1 = new Order(allOrders.size() > 0 ? allOrders.get(allOrders.size() - 1).getId() + 1 : 1,
                request.getId(), request.getStatus(), request.getSpecialRequests(),
                new Timestamp(date.getTime()), new Timestamp(date.getTime()));
        orderService.create(order1);
        System.out.println("get in 4");
        int order_dish_id = 1;
        var dummy = order_dishService.readAll();
        if (dummy.size() > 0) {
            order_dish_id = dummy.get(dummy.size() - 1).getId() + 1;
        }
        for (var dish : order) {
            order_dishService.create(new Order_dish(order_dish_id, order1.getId(), dish.getId(), request.getCountDishes(), dishService.read(dish.getId()).getPrice()));
        }
        if (!started) {
            Thread t1 = new Thread(new orderManagement());
            t1.start();
        }
        return new ResponseEntity<>("order success", HttpStatus.OK);
    }


    private class orderManagement implements Runnable {

        public boolean stop = false;

        @Override
        public void run() {
            Integer order_id = -1;
            for (var order : orderService.readAll()) {
                if (order.getStatus().equals("process")) {
                    order.setStatus("complete");
                    orderService.update(order, order.getId());
                }
                if (order.getStatus().equals("wait")) {
                    order_id = order.getId();
                    order.setStatus("process");
                    orderService.update(order, order_id);
                    break;
                }
            }

            for (var dish : order_dishService.readAll()) {
                if (Objects.equals(dish.getOrder_id(), order_id)) {
                    var d = dishService.read(dish.getId());
                    d.setQuantity(d.getQuantity() - dish.getQuantity());
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!stop) {
                run();
            } else {
                started = false;
            }
        }
    }

    @GetMapping("/order")
    public ResponseEntity<String> getOrder(@RequestBody GetOrderRequest request) {
        var order = orderService.read(request.getOrder_id());
        if (order.getStatus().equals("")) {
            return new ResponseEntity<>("there is not such order", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(order.toString(), HttpStatus.OK);
    }


    @PostMapping("/dish")
    public ResponseEntity<String> newDish(@RequestBody NewDishCreate request) {
        if (!userService.read(request.getUser_id()).getRole().equals("manager")) {
            return new ResponseEntity<>("!role", HttpStatus.BAD_REQUEST);
        }
        var dishes = dishService.readAll();
        int id = 1;
        if (dishes.size() > 0) {
            id = dishes.get(dishes.size() - 1).getId() + 1;
        }
        var date = new Date();
        Timestamp create = request.getCreated_at(), update = request.getUpdated_at();
        if (request.getCreated_at() == null) {
            create = new Timestamp(date.getTime());
        }
        if (request.getUpdated_at() == null) {
            update = new Timestamp(date.getTime());
        }
        dishService.create(new Dish(id, request.getName(), request.getDescription(), request.getPrice(), request.getQuantity(), request.getIs_available(), create, update));
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping("/dish")
    public ResponseEntity<String> getDish(@RequestBody GetDish request) {
        var dish = dishService.read(request.getDish_id());
        if (dish.getName().equals("")) {
            return new ResponseEntity<>("there is no such dish", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(dish.toString(), HttpStatus.OK);
    }

    @PutMapping("/dish")
    public ResponseEntity<String> updateDish(@RequestBody NewDishCreate request) {
        if (!userService.read(request.getUser_id()).getRole().equals("manager")) {
            return new ResponseEntity<>("!role", HttpStatus.BAD_REQUEST);
        }
        var dish = dishService.read(request.getDish_id());
        var date = new Date();
        dish.setUpdated_at(new Timestamp(date.getTime()));
        dish.setName(request.getName());
        dish.setDescription(request.getDescription());
        dish.setPrice(request.getPrice());
        dish.setQuantity(request.getQuantity());
        dish.setIs_available(request.getIs_available());
        var flag = dishService.update(dish, request.getDish_id());
        if (flag) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("unsuccess", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/dish")
    public ResponseEntity<String> deleteDish(@RequestBody NewDishCreate request) {
        if (!userService.read(request.getUser_id()).getRole().equals("manager")) {
            return new ResponseEntity<>("!role", HttpStatus.BAD_REQUEST);
        }
        var flag = dishService.delete(request.getDish_id());
        if (flag) {
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("unsuccess", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/menu")
    public ResponseEntity<String> getMenu() {
        StringBuilder result = new StringBuilder("");
        for (var dish : dishService.readAll()) {
            result.append(dish).append("\n");
        }
        return new ResponseEntity<>(result.toString(), HttpStatus.OK);
    }

}
