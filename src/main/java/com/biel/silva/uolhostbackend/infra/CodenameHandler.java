package com.biel.silva.uolhostbackend.infra;


import com.biel.silva.uolhostbackend.model.GroupType;
import com.biel.silva.uolhostbackend.service.CodenameSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CodenameHandler {


    @Autowired
    private CodenameSevice service;
    public String findCodename(GroupType groupType) {
        if(groupType == GroupType.AVENGERS) {
            String fistMatch = service.getAvangersCodenamesList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodenamesList().remove(fistMatch);
            return fistMatch;
        }
        if (groupType == GroupType.TEEN_TITANS) {
            String fistMatch = service.getTeenTitansCodenamesList().stream().findFirst().orElseThrow();
            this.service.getTeenTitansCodenamesList().remove(fistMatch);
            return fistMatch;
        }
        if (groupType == GroupType.FANTASTIC_FOUR) {
            String fistMatch = service.getFantasticFourCodenamesList().stream().findFirst().orElseThrow();
            this.service.getFantasticFourCodenamesList().remove(fistMatch);
            return fistMatch;
        }
        if(groupType == GroupType.X_MEN) {
            String fistMatch = service.getXmenCodenamesList().stream().findFirst().orElseThrow();
            this.service.getXmenCodenamesList().remove(fistMatch);
            return fistMatch;
        }

        String fistMatch = service.getJusliceLeagueCodenamesList().stream().findFirst().orElseThrow();
        this.service.getJusliceLeagueCodenamesList().remove(fistMatch);
        return fistMatch;
    }
}
