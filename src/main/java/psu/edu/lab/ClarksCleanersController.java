package psu.edu.lab;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
@RestController
public class ClarksCleanersController {

    private HashMap<Integer, Description> DescriptH = new HashMap<>();
    static int catid = 0;


    public ClarksCleanersController() {
        DescriptH.put(0, new Description("Speedy Shirt Service", 10, "Very Fast"));
        DescriptH.put(1, new Description("Slow and Thorough", 120, "Very Slow"));
        DescriptH.put(2, new Description("All Pants", 12, "Pantsy"));
    }


    @GetMapping("/categories")
    public String getCategories() {
        return "Speedy Shirt Service, Slow and Thorough, All Pants";
    }

    @GetMapping("/description")
    public Description getDescription(@RequestParam(name = "id") int id) {
        return DescriptH.get(id);

    }

    @PostMapping("/category/create")
    public int creatCategory(@RequestBody Description description) {
        DescriptH.put(catid, description);
        return catid++;
    }

    @PutMapping("/category/update")
    public int updateOrder(@RequestParam(name = "id") int id, @RequestBody Description description) {
        DescriptH.remove(id);

        DescriptH.put(id, description);

        return id;
    }
    @DeleteMapping("/category/delete")
    public int deleteOrder(@RequestParam(name = "id") int id)
    {
        DescriptH.remove(id);
        return id;
    }
}

