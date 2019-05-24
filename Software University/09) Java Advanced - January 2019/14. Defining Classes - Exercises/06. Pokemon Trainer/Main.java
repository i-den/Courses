import Pokemon.Controller.TournamentController;

public class Main {

    public static void main(String[] args) {
        TournamentController tournamentController = new TournamentController();

        tournamentController.addTrainersFromInput();
        tournamentController.doTournament();
        tournamentController.displayTrainers();
    }
}