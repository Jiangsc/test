package vehicle;

/**
 * @author sanchuanjiang
 *
 */
public class SchoolBus {
	private String Make;
	/**
	 * @return the miles_per_hour
	 */
	public int getMiles_per_hour() {
		return Miles_per_hour;
	}


	/**
	 * @param miles_per_hour the miles_per_hour to set
	 */
	public void setMiles_per_hour(int miles_per_hour) {
		Miles_per_hour = miles_per_hour;
	}

	private String Model;
	private int Year;
	private String Color;
	private double Miles_per_gallon;
	private double sitting_capacity;
	private int Miles_per_hour;
	
	public SchoolBus() {
		
	}

	
	public SchoolBus(String make, String model, int year, String color, double miles_per_gallon, double sitting_capacity, int miles_per_hour) {
		Make = make;
		Model = model;
		Year = year;
		Color = color;
		Miles_per_gallon = miles_per_gallon;
		this.sitting_capacity = sitting_capacity;
		Miles_per_hour = miles_per_hour;
	}


	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getModel() {
		return Model;
	}

	public void setModel(String model) {
		Model = model;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public double getMiles_per_gallon() {
		return Miles_per_gallon;
	}

	public void setMiles_per_gallon(double miles_per_gallon) {
		Miles_per_gallon = miles_per_gallon;
	}

	

	/**
	 * @return the sitting_capacity
	 */
	public double getSitting_capacity() {
		return sitting_capacity;
	}


	/**
	 * @param sitting_capacity the sitting_capacity to set
	 */
	public void setSitting_capacity(double sitting_capacity) {
		this.sitting_capacity = sitting_capacity;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SchoolBus [Make=" + Make + ", Model=" + Model + ", Year=" + Year + ", Color=" + Color
				+ ", Miles_per_gallon=" + Miles_per_gallon + ", sitting_capacity=" + sitting_capacity
				+ ", Miles_per_hour=" + Miles_per_hour + "]";
	}
	
	double calcGasUsed(double distance){
		return distance / this.Miles_per_gallon;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolBus other = (SchoolBus) obj;
		if (Color == null) {
			if (other.Color != null)
				return false;
		} else if (!Color.equals(other.Color))
			return false;
		if (Make == null) {
			if (other.Make != null)
				return false;
		} else if (!Make.equals(other.Make))
			return false;
		if (Double.doubleToLongBits(Miles_per_gallon) != Double.doubleToLongBits(other.Miles_per_gallon))
			return false;
		if (Miles_per_hour != other.Miles_per_hour)
			return false;
		if (Model == null) {
			if (other.Model != null)
				return false;
		} else if (!Model.equals(other.Model))
			return false;
		if (Year != other.Year)
			return false;
		if (Double.doubleToLongBits(sitting_capacity) != Double.doubleToLongBits(other.sitting_capacity))
			return false;
		return true;
	}

}
