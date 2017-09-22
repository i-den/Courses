<?php

$teams = array();
$teamScores = array();
$teamsPlayer = array();

while (true) {
    $currentTeamInfo = trim(fgets(STDIN));
    if ($currentTeamInfo === 'Result') {
        break;
    }
    $currentTeamInfo = explode('|', $currentTeamInfo);

    for ($i = 0; $i < count($currentTeamInfo); $i++) {
        $currentTeamInfo[$i] = removeSymbols($currentTeamInfo[$i]);
    }

    $currentTeam = '';
    $currentPlayer = '';
    $currentScore = intval($currentTeamInfo[2]);

    if (preg_match('/\b[A-Z]+\b/', $currentTeamInfo[0])) {
        $currentTeam = $currentTeamInfo[0];
        $currentPlayer = $currentTeamInfo[1];
    } else {
        $currentTeam = $currentTeamInfo[1];
        $currentPlayer = $currentTeamInfo[0];
    }

    $teams[$currentTeam][$currentPlayer] = $currentScore;

    if (empty($teamsPlayer[$currentTeam]) || $teamsPlayer[$currentTeam] == null) {
        $teamsPlayer[$currentTeam] = array();
    }

    if (!array_key_exists('Highest Score', $teamsPlayer[$currentTeam])) {
        $teamsPlayer[$currentTeam]['Highest Score'] = 0;
    }

    if ($teamsPlayer[$currentTeam]['Highest Score'] < $currentScore) {
        $teamsPlayer[$currentTeam]['Highest Score'] = $currentScore;
        $teamsPlayer[$currentTeam]['Most Points'] = $currentPlayer;
    }
}

foreach ($teams as $team => $playerInfo) {
    foreach ($playerInfo as $player => $score) {
        if (!array_key_exists($team, $teamScores)) {
            $teamScores[$team] = 0;
        }

        $teamScores[$team] += $score;
    }
}

arsort($teamScores);

foreach ($teamScores as $team => $score) {
    echo "$team => $score\n";
    $player = $teamsPlayer[$team]['Most Points'];
    echo "Most points scored by $player\n";
}

function removeSymbols($stringWithSymbols)
{
    $pattern = '/[@%$&*]/';
    $result = preg_replace($pattern, '', $stringWithSymbols);
    return $result;
}
