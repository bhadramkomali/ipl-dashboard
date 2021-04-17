package com.bhadram.ipldashboard.data;

import java.time.LocalDate;
import com.bhadram.model.Match;
import org.springframework.batch.item.ItemProcessor;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        Match match = new Match();
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setId(Long.parseLong(matchInput.getId()));
        match.setMatchWinner(matchInput.getWinner());
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());
        String firstInnigsTeam, secondInningsTeam;
        if("bat".equals(matchInput.getToss_decision())) {
            firstInnigsTeam = matchInput.getToss_winner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam2()) ? 
                                matchInput.getTeam2() : matchInput.getTeam1();
        } else {
            secondInningsTeam = matchInput.getToss_winner();
            firstInnigsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ?
                            matchInput.getTeam1() : matchInput.getTeam2();
        }
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setTeam1(firstInnigsTeam);
        match.setTeam2(secondInningsTeam);
        match.setTossDecision(matchInput.getToss_decision());
        match.setTossWinner(matchInput.getToss_winner();
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());
        return match;
    }

}