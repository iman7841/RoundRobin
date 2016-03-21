package tech.test.service.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import tech.test.service.RoundRobinService;

@Service
public class RoundRobinServiceImpl implements  RoundRobinService {
	
	public Map<String, Object> generateGame(int numberOfTeams) {
		Map<String, Object> hMap = new HashMap<String, Object>();
		List<String> aList = new ArrayList<String>();
		if(numberOfTeams <= 1) {
			hMap.put("message", "No match can be played with single team or no team at all");
			return hMap;  
		}
		
		int totalMatches = numberOfTeams * (numberOfTeams - 1) / 2;
		int MAX_MATCHES_IN_DAY = numberOfTeams / 2 > 2 ? 2 : numberOfTeams / 2;
		int days = 0;
		int[] a = new int[numberOfTeams - 1];
		for(int i = 0; i < numberOfTeams - 1; i++)
			a[i] = i + 1;
		
		aList.add("Maximum Matches in a Day: " + MAX_MATCHES_IN_DAY);
		
		while(totalMatches != 0) {
			int j = 0;
			int num = MAX_MATCHES_IN_DAY;
			aList.add("Day " + (days + 1) + " Matches :");
			while (num != 0) {
				if(a[j] < numberOfTeams) {
					int matchnumber = numberOfTeams * (numberOfTeams - 1) / 2 - totalMatches + 1;
					aList.add("Match " + matchnumber +": " + "Team " + (j + 1) + " Vs Team " + (a[j] + 1) + " ");
					a[j++] += 1;
					aList.add(Arrays.toString(a));
					totalMatches--;
					num--;
				} else
					j++;
			}
			days++;
		}
		
		aList.add("Total Number of Days is " + days);	
		hMap.put("message", aList);
		
		return hMap;
	}
}
