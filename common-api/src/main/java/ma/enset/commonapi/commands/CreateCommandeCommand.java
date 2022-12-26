package ma.enset.commonapi.commands;

import lombok.Getter;

import java.util.Date;
import java.util.List;

public class CreateCommandeCommand extends BaseCommand<String> {
    @Getter public String clientID;
    @Getter public List<String> commandLinesIDs;
    @Getter public Date dateLivtaison;
    @Getter public String adressLivraison;
    @Getter public String status;

    public CreateCommandeCommand(String id, String clientID, List<String> commandLinesIDs, Date dateLivtaison, String adressLivraison, String status) {
        super(id);
        this.clientID = clientID;
        this.commandLinesIDs = commandLinesIDs;
        this.dateLivtaison = dateLivtaison;
        this.adressLivraison = adressLivraison;
        this.status = status;
    }
}
