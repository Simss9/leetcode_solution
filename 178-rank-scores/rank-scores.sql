SELECT 
    s1.score,
    COUNT(DISTINCT s2.score) AS `rank`
FROM Scores s1
JOIN Scores s2
ON s1.score <= s2.score
GROUP BY s1.id, s1.score
ORDER BY s1.score DESC;