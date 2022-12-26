package ma.enset.commonapi.commands;

import lombok.Getter;

public class CreateCommandLineCommand extends BaseCommand<String> {
    @Getter public String productID;
    @Getter public int quantite;
    @Getter public double prixunitaire;
    @Getter public double remise;

    public CreateCommandLineCommand(String id, String productID, int quantite, double prixunitaire, double remise) {
        super(id);
        this.productID = productID;
        this.quantite = quantite;
        this.prixunitaire = prixunitaire;
        this.remise = remise;
    }
}
