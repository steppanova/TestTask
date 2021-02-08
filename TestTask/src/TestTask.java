import java.util.ArrayList;
import java.util.List;

public class TestTask {
	public static List<FiltersAdapter> generateFigures() {
		FiltersAdapter[] figure = { new FiltersAdapter(new Square(5, "grey")),
				new FiltersAdapter(new Triangle(4, 8, 5, "red")), new FiltersAdapter(new Circle(6, "yellow")),
				new FiltersAdapter(new Trapezoid(5, 8, 4, "green")) };
		int a = 0;
		int b = 10;
		List<FiltersAdapter> arr = new ArrayList<>();
		int numberFigures = a + (int) (Math.random() * b);
		for (int i = 0; i <= numberFigures; i++) {
			arr.add(i, figure[(int) (Math.random() * figure.length)]);
		}
		return arr;
	}

	public static void main(String[] args) {
		Applies.conclusion(generateFigures());
	}
}

interface Figure {
	String name();

	String draw();

	double getArea();

	String getColor();

}

class Filters {
	String name() {
		return getClass().getSimpleName();
	}

	public String draw() {
		return null;
	}

	public double getArea() {
		return 0;
	}

	public String getColor() {
		return null;
	}

}

class FiltersAdapter implements Figure {
	Filters filter;

	public FiltersAdapter(Filters filter) {
		super();
		this.filter = filter;
	}

	@Override
	public String name() {
		return filter.name();
	}

	@Override
	public String draw() {
		return filter.draw();
	}

	@Override
	public double getArea() {
		return filter.getArea();
	}

	@Override
	public String getColor() {
		return filter.getColor();
	}

}

class Square extends Filters {
	int x;
	String col;

	public Square(int x, String col) {
		this.x = x;
		this.col = col;
	}

	public double getArea() {
		int s = x * 2;
		return s;
	}

	public String getColor() {
		System.out.print("lenght side: " + getLenghtSide() + ", ");
		return col;
	}

	public String draw() {
		String s = "квадрат";
		return s;
	}

	public int getLenghtSide() {
		return x;
	}

}

class Triangle extends Filters {
	int a, b, c;

	public Triangle(int a, int b, int c, String col) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.col = col;
	}

	String col;

	public String getColor() {
		System.out.print("hypotenuse length: " + getHypotenuse() + ",");
		return col;
	}

	public double getArea() {
		double s = 0.5 * (a + b + c);
		return s;
	}

	public int getHypotenuse() {
		if (a > b) {
			if (a > c) {
				return a;
			} else {
				return c;
			}
		} else if (b > c) {
			return b;
		} else
			return c;
	}
}

class Circle extends Filters {
	public Circle(int r, String col) {
		super();
		this.col = col;
		this.r = r;
	}

	private double p = 3.14;
	static int r;
	String col;

	public String getColor() {
		return col;
	}

	public double getArea() {
		double s = r * 2 / (4 * p);
		return s;
	}

	public String draw() {
		System.out.print("radius: " + getRadius() + ", ");
		String s = "круг";
		return s;
	}

	public int getRadius() {
		return r;
	}
}

class Trapezoid extends Filters {
	int a, b, h;
	String col;

	public Trapezoid(int a, int b, int h, String col) {
		super();
		this.a = a;
		this.b = b;
		this.h = h;
		this.col = col;
	}

	public String getColor() {
		return col;
	}

	public double getArea() {
		double s = ((a + b) / 2) * h;
		return s;
	}

	public String draw() {
		String s = "трапеция";
		return s;
	}
}

class Applies {
	public static void conclusion(List<FiltersAdapter> f) {
		for (int i = 0; i < f.size(); i++) {
			System.out.print("Фигура: " + f.get(i).name() + ", ");
			System.out.print(f.get(i).draw() + ", ");
			System.out.print("area: " + f.get(i).getArea() + ", ");
			System.out.println("color: " + f.get(i).getColor());
		}
	}
}
