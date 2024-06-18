//package com.example.meatshop.Service.Impl;
//
//import com.example.meatshop.Entity.Items;
//import com.example.meatshop.Pojo.ItemsPojo;
//import com.example.meatshop.Pojo.OrderPojo;
//import com.example.meatshop.Repo.OrderRepo;
//import com.example.meatshop.Service.OrderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class OrderServiceImpl implements OrderService {
//    private final OrderRepo orderRepo;
//
//    @Override
//    public void saveData(OrderPojo orderPojo) {
//        Order order = new Order();
//        order.setOrderDate(orderPojo.getOrderDate());
//        order.setCustomerId(orderPojo.getCustomerId());
//
//        List<Items> itemsList = new ArrayList<>();
//        for (ItemsPojo itemPojo : orderPojo.getItems()) {
//            Items item = new Items();
//            item.setItemName(itemPojo.getItemName());
//            item.setPrice(itemPojo.getPrice());
////            item.setOrder(order);  // Set the relationship
//            itemsList.add(item);
//        }
//        order.setItems(itemsList);
//
//        orderRepo.save(order);
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
//    }
//
//    @Override
//    public Optional<Order> findById(Long id) {
//        return orderRepo.findById(id.intValue());
//    }
//
//    @Override
//    public void updateData(Integer id, OrderPojo orderPojo) {
//        Optional<Order> orderOptional = orderRepo.findById(id);
//        if (orderOptional.isPresent()) {
//            Order existingOrder = orderOptional.get();
//            updateOrder(existingOrder, orderPojo);
//            orderRepo.save(existingOrder);
//        } else {
//            throw new IllegalArgumentException("Order with ID " + id + " not found");
//        }
//    }
//
//    private void updateOrder(Order existingOrder, OrderPojo orderPojo) {
//        existingOrder.setOrderDate(orderPojo.getOrderDate());
//        existingOrder.setCustomerId(orderPojo.getCustomerId());
//
//        List<Items> existingItems = existingOrder.getItems();
//        List<Items> updatedItems = new ArrayList<>();
//
//        for (ItemsPojo itemPojo : orderPojo.getItems()) {
//            Optional<Items> itemOptional = existingItems.stream()
//                    .filter(item -> item.getId().equals(itemPojo.getId()))
//                    .findFirst();
//
//            Items item;
//            if (itemOptional.isPresent()) {
//                item = itemOptional.get();
//            } else {
//                item = new Items();
////                item.setOrder(existingOrder); // Set the relationship
//            }
//
//            item.setItemName(itemPojo.getItemName());
//            item.setPrice(itemPojo.getPrice());
//
//            updatedItems.add(item);
//        }
//
//        // Remove items that are not in the updated list
//        existingItems.removeIf(item -> updatedItems.stream().noneMatch(updatedItem -> updatedItem.getId().equals(item.getId())));
//
//        // Add or update items
//        existingItems.clear();
//        existingItems.addAll(updatedItems);
//
//        existingOrder.setItems(existingItems);
//    }
//
//    @Override
//    public boolean existsById(Integer id) {
//        return orderRepo.existsById(id);
//    }
//}
