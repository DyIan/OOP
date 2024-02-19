package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet
{
	String[] Months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	float[] Rainfall = {200, 260, 300, 150, 100, 50, 10, 40, 67, 160, 400, 420};

	//  Used to mapp triggers on controllers n stuff
	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c - b;
		float r2 = e - d;

		float How_Far = a - b;
		return d + (How_Far / r1) * r2;
	}

	public void settings()
	{
		size(500, 500);

		String[] m1 = Months;

		int Largest = 0;
		int Smallest = 0;
		float Average = 0;

		// Finfing Largest
		for (int i = 0; i < Months.length; i++)
		{
			if (Rainfall[i] > Rainfall[Largest])
			{
				Largest = i;
			}

			if (Rainfall[i] < Rainfall[Smallest])
			{
				Smallest = i;
			}

			Average += Rainfall[i];
		}

		Average = Average / Rainfall.length;

		println("Smallest Month: " + Months[Smallest] + "\t" + Rainfall[Smallest]);
		println("Largest Month: " + Months[Largest] + "\t" + Rainfall[Largest]);
		println("Averge Rainfall: " + Average);

		// a is plugged in, b-c is a range, d-e is range
		// Gets the percent between b-c according to a. And applies it to d-e
		println(map1(5,0,10,0,100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26,25,35,0, 100));
		// 10
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		
		
	}

	
	public void draw()
	{	
		background(0);
		float w = width / Months.length;
		for (int i = 0; i < Months.length; i++)
		{
			float x = map1(1, 0, Months.length, 0, w);
			rect(x, height, w, -Rainfall[i]);
		}
	}
}
