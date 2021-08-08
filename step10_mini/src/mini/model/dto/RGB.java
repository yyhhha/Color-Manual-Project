package mini.model.dto;

public class RGB {
	/** red ��ȣ 0~255 */
	private int red;
	
	/** green ��ȣ 0~255 */
	private int green;
	
	/** blue ��ȣ 0~255 */
	private int blue;

	public RGB() {	}
	public RGB(int red, int green, int blue) {
		super();
//		this.hex = hex;
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	@Override
	public String toString() {
		return "[R : " + red + ", G : " + green + ", B : " + blue + "]";
	}

}
