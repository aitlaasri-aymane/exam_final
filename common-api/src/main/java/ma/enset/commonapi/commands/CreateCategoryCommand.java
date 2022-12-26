package ma.enset.commonapi.commands;

import lombok.Getter;

public class CreateCategoryCommand extends BaseCommand<String> {
    @Getter public String name;
    @Getter public String description;

    public CreateCategoryCommand(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }
}
