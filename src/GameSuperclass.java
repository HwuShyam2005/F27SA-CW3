public abstract class GameSuperclass {
    
    public String gameName;
	public GameSuperclass(String gameName)
	{
		this.gameName = gameName;
	}
	abstract public void printGameIntro();
	abstract public boolean processInput(int value);
}