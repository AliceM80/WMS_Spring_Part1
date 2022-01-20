package com.example.WMS_Spring_Part1.Controller;

import com.example.WMS_Spring_Part1.model.Item;
import com.example.WMS_Spring_Part1.repository.WarehouseRepository;
import com.example.WMS_Spring_Part1.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class WarehouseController {


  private final WarehouseService warehouseService;


  //We've @Autowired our WarehouseService. It's used for dependency injection, as this class is a dependency here.
  @Autowired
 public WarehouseController(WarehouseService warehouseService){
    this.warehouseService = warehouseService;
  }




  @GetMapping(value= "warehouse/getWarehouses")
  public Set<Integer> getWarehouses(){return warehouseService.getWarehouses();
  }

  @GetMapping(value="warehouse/getAllItems")
  public List<Item> getAllItems(){return warehouseService.getAllItems();
  }

  @GetMapping(value="warehouse/getAllItems/{warehouseId}")
  public List<Item> getItemsByWarehouse(@PathVariable int warehouseId){
  return warehouseService.getItemsByWarehouse(warehouseId);
  }


  @GetMapping(value="warehouse/getCategories")
  public Set<String> getCategories(){return warehouseService.getCategories();  }


 @GetMapping ( "/warehouse/getItemsByCategory/{category}")
 public List<Item> getItemsByCategory(@PathVariable("category") String category) {
  return warehouseService.getItemsByCategory(category);
 }


}
