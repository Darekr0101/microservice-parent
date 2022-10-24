package com.example.inventoryservice.service.impl;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import com.example.inventoryservice.service.InventoryService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        log.info("Wait started");
//        Thread.sleep(10000);
        log.info("Wait end");
        /*
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();

         */
        List<Inventory> inventory =  inventoryRepository.findBySkuCodeIn(skuCode);
        List<InventoryResponse> inventoryResponses =  inventory.stream()
                .map(inventory1 -> InventoryResponse.builder()
                        .skuCode(inventory1.getSkuCode())
                        .isInStock(inventory1.getQuantity() > 0 ? true : false )
                        .build()
                ).toList();
        return  inventoryResponses;
    }
}
