package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryService {
    @Transactional(readOnly = true)
    List<InventoryResponse> isInStock(List<String> skuCode);
}

