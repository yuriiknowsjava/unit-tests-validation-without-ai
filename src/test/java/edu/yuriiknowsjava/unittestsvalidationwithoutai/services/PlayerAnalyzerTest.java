package edu.yuriiknowsjava.unittestsvalidationwithoutai.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import edu.yuriiknowsjava.unittestsvalidationwithoutai.dtos.Player;
import edu.yuriiknowsjava.unittestsvalidationwithoutai.services.PlayerAnalyzer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerAnalyzerTest {
    private static final double ALLOWED_DELTA = 0.00001;
    private final PlayerAnalyzer playerAnalyzer = new PlayerAnalyzer();

    private Player normalPlayer;
    private final double normalPlayerScore = 250.0;

    private Player juniorPlayer;
    private final double juniorPlayerScore = 67.5;

    private Player seniorPlayer;
    private final double seniorPlayerScore = 2520;

    @BeforeEach
    void createPlayers() {
        normalPlayer = new Player();
        normalPlayer.setAge(25);
        normalPlayer.setExperience(5);
        normalPlayer.setSkills(List.of(2, 2, 2));

        juniorPlayer = new Player();
        juniorPlayer.setAge(15);
        juniorPlayer.setExperience(3);
        juniorPlayer.setSkills(List.of(3, 3, 3));

        seniorPlayer = new Player();
        seniorPlayer.setAge(35);
        seniorPlayer.setExperience(15);
        seniorPlayer.setSkills(List.of(4, 4, 4));
    }

    @DisplayName("Test calculate score for normal player")
    @Test
    void calculateScoreForNormalPlayer() {
        double score = playerAnalyzer.calculateScore(List.of(normalPlayer));
        assertEquals(normalPlayerScore, score, ALLOWED_DELTA);
    }

    @DisplayName("Test calculate score for junior player")
    @Test
    void calculateScoreForJuniorPlayer() {
        double score = playerAnalyzer.calculateScore(List.of(juniorPlayer));
        assertEquals(juniorPlayerScore, score, ALLOWED_DELTA);
    }

    @DisplayName("Test calculate score for senior player")
    @Test
    void calculateScoreForSeniorPlayer() {
        double score = playerAnalyzer.calculateScore(List.of(seniorPlayer));
        assertEquals(seniorPlayerScore, score, ALLOWED_DELTA);
    }

    @DisplayName("Test calculate score for multiple players")
    @Test
    void calculateScoreForMultiplePlayers() {
        double score = playerAnalyzer.calculateScore(List.of(normalPlayer, juniorPlayer, seniorPlayer));
        double expected = normalPlayerScore + juniorPlayerScore + seniorPlayerScore;
        assertEquals(expected, score, ALLOWED_DELTA);
    }

    @DisplayName("Test calculate score null skill")
    @Test
    void calculateScoreNullSkill() {
        var nullSkillPlayer = new Player();
        nullSkillPlayer.setSkills(null);
        assertThrows(NullPointerException.class, () -> playerAnalyzer.calculateScore(List.of(nullSkillPlayer)));
    }

    @DisplayName("Test calculate score for empty list")
    @Test
    void calculateScoreEmptyList() {
        double score = playerAnalyzer.calculateScore(List.of());
        assertEquals(0.0, score, ALLOWED_DELTA);
    }
}
