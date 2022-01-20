package com.example.WMS_Spring_Part1.Controller;

import com.example.WMS_Spring_Part1.model.Item;
import com.example.WMS_Spring_Part1.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;


@Controller
public class HomeController {

 RestTemplate restTemplate;


 /* @GetMapping(value="/")
public String goToIndex(){
  return "This is the Home page";
}*/

@GetMapping(value="/listAllItems")
public String getListAllItemsePage(HttpServletRequest request, Model model) {
  restTemplate = new RestTemplate();
  String itemResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getAllItems";
  String warehouseResourceUrl = "http://localhost:" + request.getLocalPort() + "/warehouse/getWarehouses";

  List<Item> response = restTemplate.getForObject(
          itemResourceUrl,
          List.class
  );

  Set<Integer> warehouseResponse = restTemplate.getForObject(
          warehouseResourceUrl,
          Set.class
  );

  model.addAttribute("warehouses", warehouseResponse);
  model.addAttribute("items", response);
  model.addAttribute("itemCount", response.size());
  return "items_list";
}


}








