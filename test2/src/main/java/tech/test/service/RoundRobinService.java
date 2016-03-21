package tech.test.service;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface RoundRobinService {
	public Map<String, Object> generateGame(int numberOfTeams);
}
