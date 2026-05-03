package com.app.my_app.rest;

import com.app.my_app.domain.CartItem;
import com.app.my_app.domain.Category;
import com.app.my_app.domain.Order;
import com.app.my_app.domain.OrderItem;
import com.app.my_app.domain.OrderStatus;
import com.app.my_app.domain.Product;
import com.app.my_app.model.UserDTO;
import com.app.my_app.service.CartItemService;
import com.app.my_app.service.CategoryService;
import com.app.my_app.service.OrderItemService;
import com.app.my_app.service.OrderService;
import com.app.my_app.service.OrderStatusService;
import com.app.my_app.service.ProductService;
import com.app.my_app.service.UserService;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminResource {

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final OrderStatusService orderStatusService;
    private final CartItemService cartItemService;

    public AdminResource(final UserService userService,
                         final ProductService productService,
                         final CategoryService categoryService,
                         final OrderService orderService,
                         final OrderItemService orderItemService,
                         final OrderStatusService orderStatusService,
                         final CartItemService cartItemService) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.orderStatusService = orderStatusService;
        this.cartItemService = cartItemService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> users() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> products() {
        return ResponseEntity.ok(productService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/categories")
    public ResponseEntity<List<Category>> categories() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> orders() {
        return ResponseEntity.ok(orderService.findAllAdmin());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/order-items")
    public ResponseEntity<List<OrderItem>> orderItems() {
        return ResponseEntity.ok(orderItemService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/order-status")
    public ResponseEntity<List<OrderStatus>> orderStatus() {
        return ResponseEntity.ok(orderStatusService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/cart-items")
    public ResponseEntity<List<CartItem>> cartItems() {
        return ResponseEntity.ok(cartItemService.findAllAdmin());
    }

}
