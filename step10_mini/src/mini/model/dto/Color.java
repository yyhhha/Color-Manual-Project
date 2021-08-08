package mini.model.dto;

public class Color {
	
	/** color name */
	private String colorName;
	
	/** hex �� #000000 */
	private String hex;
	
	/** RGB ��  */
	private RGB rgb;

	public Color() {
		super();
	}

	public Color(String colorName, String hex, RGB rgb) {
		super();
		this.colorName = colorName;
		this.hex = hex;
		this.rgb = rgb;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public RGB getRgb() {
		return rgb;
	}

	public void setRgb(RGB rgb) {
		this.rgb = rgb;
	}

	@Override
	public String toString() {
		return colorName + " [HEX : " + hex + ", rgb : " + rgb + "]";
	}
	
	
	
}
