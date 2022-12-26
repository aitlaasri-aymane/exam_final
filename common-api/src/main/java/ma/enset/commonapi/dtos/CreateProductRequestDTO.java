package ma.enset.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.commonapi.enums.StateProduct;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequestDTO {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private StateProduct state;
    private String categoryId;
}
