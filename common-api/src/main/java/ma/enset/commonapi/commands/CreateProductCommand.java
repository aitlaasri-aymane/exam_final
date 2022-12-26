package ma.enset.commonapi.commands;

import lombok.Getter;
import ma.enset.commonapi.enums.StateProduct;

public class CreateProductCommand extends BaseCommand<String> {
    @Getter public String name;
    @Getter public String description;
    @Getter public double price;
    @Getter public int quantity;
    @Getter public String categoryId;


    public CreateProductCommand(String id, String name, String description, double price, int quantity, String categoryId) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }
}
