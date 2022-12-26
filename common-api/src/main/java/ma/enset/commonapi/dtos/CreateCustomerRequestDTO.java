package ma.enset.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCustomerRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String address;
}
