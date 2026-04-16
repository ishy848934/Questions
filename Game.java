public class Game
{
    private Level levelOne;
    private Level levelTwo;
    private Level levelThree;

    /** Postcondition: All instance variables have been initialized. */
    public Game()
    { }

    /** Returns true if this game is a bonus game and returns false otherwise */
    public boolean isBonus()
    { return GameTest.getNextBonus(); }

    /** Simulates the play of this Game (consisting of three levels) and updates all relevant
     * game data
     */
    public void play()
    {
        levelOne = GameTest.getNextLevel();
        levelTwo = GameTest.getNextLevel();
        levelThree = GameTest.getNextLevel();
    }

    /* Part (a) */

    public int getScore()
    {
        int total = levelOne.getScore()
                  + levelTwo.getScore()
                  + levelThree.getScore();

        if (isBonus())
            total *= 2;

        return total;
    }

    /* Part (b) */

    public int playManyTimes(int num)
    {
        int highest = 0;

        for (int i = 0; i < num; i++)
        {
            play();
            int score = getScore();

            if (score > highest)
                highest = score;
        }
        return highest;
    }
}
