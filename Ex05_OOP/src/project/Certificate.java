package project;

public class Certificate extends Paper {
	private String[] certificate;
	private int[] certificatePrice;
	private int certificateNumber;

	public String[] getCertificate() {
		return certificate;
	}

	public void setCertificate(String[] certificate) {
		this.certificate = certificate;
	}

	public int[] getCertificatePrice() {
		return certificatePrice;
	}

	public void setCertificatePrice(int[] certificatePrice) {
		this.certificatePrice = certificatePrice;
	}

	public int getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(int certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	Certificate() { // 기본생성자
		certificate = new String[] { "재학증명서", "졸업증명서", "졸업예정증명서", "성적증명서", "휴학증명서" };
		certificatePrice = new int[] { 300, 1000, 500, 300, 0 };
	}

	public int price(int certificateNumber) {
		this.certificateNumber = certificateNumber;
		int price = (Integer.parseInt(certificate[certificateNumber])) * certificatePrice[certificateNumber];
		setPaperUse(getPaperUse() + 1);

		return price;
	}
}