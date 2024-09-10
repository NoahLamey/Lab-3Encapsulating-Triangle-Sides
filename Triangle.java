

public class Triangle {
	
	private double sideA;
	private double sideB;
	private double sideC;
	private double angleA;
	private double angleB; 
	private double angleC;
	
	public static final Double DEFAULT_SIDE = 1.0;
	 public static final String POLYGONSHAPE = "Triangle";

	public Triangle() {
		this.sideA = DEFAULT_SIDE;
		this.sideB = DEFAULT_SIDE;
		this.sideC = DEFAULT_SIDE;
	}
	public Triangle(Triangle triangle) {
		if(triangle == null){
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		}else {
		this.sideA = triangle.sideA;
		this.sideB = triangle.sideB;
		this.sideC = triangle.sideC;
		
		}
	}
	 public Triangle(double sideA, double sideB, double sideC) {
	        if (isTriangle(sideA, sideB, sideC)) {
	            this.sideA = sideA;
	            this.sideB = sideB;
	            this.sideC = sideC;
	        } else {
	            this.sideA = DEFAULT_SIDE;
	            this.sideB = DEFAULT_SIDE;
	            this.sideC = DEFAULT_SIDE;
	        }
	        }
	 public Triangle(double[] sides) {
		  if (sides == null || sides.length != 3 || !isTriangle(sides[0], sides[1], sides[2])){
			this.sideA = DEFAULT_SIDE;
			this.sideB = DEFAULT_SIDE;
			this.sideC = DEFAULT_SIDE;
		  }else {
			  this.sideA = sides[0];
			  this.sideB = sides[1];
			  this.sideC = sides[2];
		  }
		  }
	  public static boolean isTriangle(double a, double b, double c) {
	        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
	    }
	    public static boolean isTriangle(double[] sides) {
	        if (sides == null || sides.length != 3) {
	            return false;
	        }
	        return isTriangle(sides[0], sides[1], sides[2]);
	    }

	public static double lawOfCosines(double sideA, double sideB, double sideC){ 
		double cosSideC = (sideA * sideA + sideB * sideB - sideC * sideC) / (2 * sideA * sideB);
		double angle = Math.acos(cosSideC);
		double angleInDegrees = Math.toDegrees(angle);
		return angleInDegrees;
	}

	public boolean setSideA(double sideA) {
		if(isTriangle(sideA, this.sideB, this.sideC)) {
		this.sideA = sideA;
		return true;
		}
		return false;
	}

	public boolean setSideB(double sideB) {
		if(isTriangle(this.sideA, sideB, this.sideC)) {
			this.sideB = sideB;
			return true;
			}
			return false;
	}

	public boolean setSideC(double sideC) {
		if(isTriangle(this.sideA, this.sideB, sideC)) {
			this.sideC = sideC;
			return true;
			}
			return false;
	}


	public boolean setSides(double[] sides) {
		if(sides != null && sides.length == 3 && isTriangle(sides[0], sides[1], sides[2])) {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
			return true;
		}
			return false;
		}
		
	public double[] getSides() {
	    return new double[]{sideA, sideB, sideC};
	}
	
	public double getSideA() {
		return sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public double getSideC() {
		return sideC;
	}
	public double getAngleA() {
	    if (isTriangle(sideA, sideB, sideC)) {
	        angleA = lawOfCosines(sideB, sideC, sideA);
	    }
	    return angleA;
	}
	public void setAngleA(double angleA) {
		this.angleA = angleA;
	}
	public double getAngleB() {
	    if (isTriangle(sideA, sideB, sideC)) {
	        angleB = lawOfCosines(sideA, sideC, sideB);
	    }
	    return angleB;
	}
	public void setAngleB(double angleB) {
		this.angleB = angleB;
	}
	public double getAngleC() {
	    if (isTriangle(sideA, sideB, sideC)) {
	        angleC = lawOfCosines(sideA, sideB, sideC);
	    }
	    return angleC;
	}
	public void setAngleC(double angleC) {
		this.angleC = angleC;
	}
	public double[] getAngles() {
		double[] angles = new double[3];
		angles[0] = getAngleA();
		angles[1] = getAngleB();
		angles[2] = getAngleC();
		return angles;
	}
	@Override
	public String toString() {
		return String.format("Triangle(%.4f, %.4f, %.4f)", sideA, sideB, sideC);
	}

}
