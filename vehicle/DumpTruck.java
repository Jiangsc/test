package vehicle;
/**
 * @author sanchuanjiang
 *
 */

public class DumpTruck {
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	private double Load_capacity;
	private int  Miles_per_hour;
	
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
		DumpTruck other = (DumpTruck) obj;
		if (Color == null) {
			if (other.Color != null)
				return false;
		} else if (!Color.equals(other.Color))
			return false;
		if (Double.doubleToLongBits(Load_capacity) != Double.doubleToLongBits(other.Load_capacity))
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
		return true;
	}


	public DumpTruck() {
		
	}

	
	public DumpTruck(String make, String model, int year, 
			String color, double miles_per_gallon, double load_capacity, 
			int miles_per_hour) {
		super();
		Make = make;
		Model = model;
		Year = year;
		Color = color;
		Miles_per_gallon = miles_per_gallon;
		Load_capacity = load_capacity;
		Miles_per_hour=miles_per_hour;
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

	public double getLoad_capacity() {
		return Load_capacity;
	}

	public void setLoad_capacity(double load_capacity) {
		Load_capacity = load_capacity;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DumpTruck [Make=" + Make + ", Model=" + Model + ", Year=" + Year + ", Color=" + Color
				+ ", Miles_per_gallon=" + Miles_per_gallon + ", Load_capacity=" + Load_capacity + ", Miles_per_hour="
				+ Miles_per_hour + "]";
	}
	
	double calcGasUsed(double distance){
		return distance / this.Miles_per_gallon;
	}
	
	
// }

}
