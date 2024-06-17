//package com.example.meatshop.Service.Impl;
//
//import com.example.meatshop.Entity.Items;
//import com.example.meatshop.Entity.Order;
//import com.example.meatshop.Pojo.ItemsPojo;
//import com.example.meatshop.Pojo.OrderPojo;
//import com.example.meatshop.Repo.OrderRepo;
//import com.example.meatshop.Service.OrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//@RequiredArgsConstructor
//@Service
//
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepo orderRepo;
//    @Override
//    public void saveData(OrderPojo orderPojo) {
//        Order order=new Order();
//        order.setOrderDate(orderPojo.getOrderDate());
//        order.setCustomerId(orderPojo.getCustomerId());
//        order.setPaymentType(orderPojo.getPaymentType());
//        orderRepo.save(order);
//
//    }
//
//    @Override
//    public List<Order> getAll() {
//        return orderRepo.findAll();
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        orderRepo.deleteById(id.intValue());
//
//    }
//
//    @Override
//    public Optional<Order> findById(Long id) {
//        return orderRepo.findById(id.intValue());
//    }
//
//    public void updateData(Integer id, OrderPojo orderPojo) {
//        Optional<Order> orderOptional = orderRepo.findById(id);
//        if (orderOptional.isPresent()) {
//            Order existingOrder = orderOptional.get();
//
//            updateOrder(existingOrder, orderPojo);
//            orderRepo.save(existingOrder);
//        } else {
//
//            throw new IllegalArgumentException("Order with ID " + id + " not found");
//        }
//    }
//    private void updateOrder(Order existingOrder, OrderPojo orderPojo) {
//        if (orderPojo.getId()!= null) {
//            existingOrder.setOrderDate(orderPojo.getOrderDate());
//            existingOrder.setPaymentType(orderPojo.getPaymentType());
//            existingOrder.setCustomerId(orderPojo.getCustomerId());
//        }
//        throw new IllegalArgumentException("Items with ID " +" not found");
//
//
//    }
//
//    @Override
//    public boolean existsById(Integer id) {
//        return orderRepo.existsById(id.intValue());
//    }
//}
