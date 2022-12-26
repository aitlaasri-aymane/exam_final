package ma.enset.commonapi.commands;

import lombok.Getter;

import java.util.Date;

public class CreateCustomerCommand extends BaseCommand<String> {
    @Getter public String name;
    @Getter public String address;
    @Getter public String email;
    @Getter public String phone;

    public CreateCustomerCommand(String id, String name, String address, String email, String phone) {
        super(id);
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }
}
