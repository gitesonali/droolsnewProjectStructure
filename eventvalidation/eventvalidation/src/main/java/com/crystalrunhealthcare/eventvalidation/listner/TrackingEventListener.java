package com.crystalrunhealthcare.eventvalidation.listner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.drools.core.event.DefaultAgendaEventListener;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.runtime.rule.Match;

public class TrackingEventListener extends DefaultAgendaEventListener  {

    private List<Match> matchList = new ArrayList<Match>();
    
    /**
     * here tracking of all the rules in session is mentioned
     */
    @Override
    public void afterMatchFired(AfterMatchFiredEvent event) {
        Rule rule = event.getMatch().getRule();

        String ruleName = rule.getName();
        Map<String, Object> ruleMetaDataMap = rule.getMetaData();

        matchList.add(event.getMatch());
        StringBuilder sb = new StringBuilder("Rule fired: " + ruleName);

        if (ruleMetaDataMap.size() > 0) {
            sb.append("\n  With [" + ruleMetaDataMap.size() + "] meta-data:");
            for (String key : ruleMetaDataMap.keySet()) {
                sb.append("\n    key=" + key + ", value="
                        + ruleMetaDataMap.get(key));
            }
        }
    }
/**
 * rulename matches with the rule present in session
 * @param ruleName
 * @return boolean value
 */
    public boolean isRuleFired(String ruleName) {
        for (Match a : matchList) {
            if (a.getRule().getName().equals(ruleName)) {
                return true;
            }
        }
        return false;
    }
/**
 * reset the matchlist
 */
    public void reset() {
        matchList.clear();
    }
/**
 * it returns the matchList
 * @return matchlist
 */
    public final List<Match> getMatchList() {
        return matchList;
    }

    /**
     * convert the final value to string
     * @return string
     */
    public String matchsToString() {
        if (matchList.size() == 0) {
            return "No matchs occurred.";
        } else {
            StringBuilder sb = new StringBuilder("Matchs: ");
            int i=1;
            for (Match match : matchList) {
                sb.append(i).append(")rule: ").append(match.getRule().getName()).append(" ");
                i++;
            }
            return sb.toString();
        }
    }
}
