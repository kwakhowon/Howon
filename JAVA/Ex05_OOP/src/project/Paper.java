package project;

public class Paper {
	private int paperDefult;
	private int paperUse;

	public int getPaperDefult() {
		return paperDefult;
	}

	public void setPaperDefult(int paperDefult) {
		this.paperDefult = paperDefult;
	}

	public int getPaperUse() {
		return paperUse;
	}

	public void setPaperUse(int paperUse) {
		this.paperUse = paperUse;
	}

	public Paper() {
		paperDefult = 50;
		paperUse = 0;
	}

	public int paperStatus(int paperUse) {
		return (paperDefult - paperUse);
	}
}